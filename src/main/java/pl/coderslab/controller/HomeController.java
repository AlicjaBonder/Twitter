package pl.coderslab.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.entities.Tweet;
import pl.coderslab.entities.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;



@Controller 
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/user")
	public String showAddBookForm(Model model, HttpSession session){

		if(session.getAttribute("loggedUser") != null)
		{
			model.addAttribute("info", "jesteś zalogowany");
			model.addAttribute("tweets",tweetRepository.findAllByOrderByCreatedDesc());
			model.addAttribute("tweet", new Tweet());
		}
		return "userPanel";
			
	}
	
	
	@ModelAttribute("loggedUser")
	public User getLoggedUser(HttpServletRequest request){
		if(request.getSession().getAttribute("userId")!= null){
			return userRepository.findOne((Long) request.getSession().getAttribute("userId"));
		}else{
			User notLoggedIn = new User();
			notLoggedIn.setUsername("niezalogowany uzytkowniku");
			notLoggedIn.setLoggedIn(false);
			return notLoggedIn;
		}
	}
	
	
	

}