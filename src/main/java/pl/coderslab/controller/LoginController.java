package pl.coderslab.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entities.User;
import pl.coderslab.repository.UserRepository;



@Controller
public class LoginController {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String login,@RequestParam String password,HttpSession session, Model model) {
		
		User user = userRepo.findFirstByUsername(login);
		
		if(user != null && BCrypt.checkpw(password, user.getPassword()))
		{
			
			session.setAttribute("logged", user);
		}else {
				
				model.addAttribute("info","Błędny login lub hasło");
				session.setAttribute("logged", null);
				return "loginForm";
		}
		return "redirect:/user";
		
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.setAttribute("loggedUser",null);
		return "Zostałeś wylogowany";
	}
	
	
//	@GetMapping( "/logout")
//	public String logoutUser(HttpServletRequest request) {
//		User userToLogOut = userRepository.findOne((Long) request.getSession().getAttribute("userId"));
//		userToLogOut.setLoggedIn(false);
//		userRepository.save(userToLogOut);
//		request.getSession().removeAttribute("userId");
//		return "redirect:/";
//
//	}
	
	}
