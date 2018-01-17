package pl.coderslab.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.entities.Tweet;
import pl.coderslab.entities.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TweetRepository tweetRepository;



	@GetMapping("/authenticated")
	@ResponseBody
	public String isAuthenticated(@SessionAttribute Long userId) {
		if (userId != null) {
			return "id zalogowanego usera to " + userId;
		} else {
			return "nie zalogowano";
		}

	}


	@GetMapping("/myTweets")
	public String showUsersTweets(HttpServletRequest request, Model model) {

		List<Tweet> myTweets = tweetRepository.findByUserId((Long) request.getSession().getAttribute("userId"));
		model.addAttribute("myTweets", myTweets);
		return "myTweets";
	}

	@GetMapping("/list")
	public String showUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "userList";

	}

}