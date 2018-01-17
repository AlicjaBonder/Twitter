package pl.coderslab.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entities.Comment;
import pl.coderslab.entities.Tweet;
import pl.coderslab.entities.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/tweets")
public class TweetController {
	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommentRepository commentRepository;

	@GetMapping("/add")
	public String showAddTweetForm(Model model) {
		model.addAttribute("tweet", new Tweet());
		return "tweetForm";
	}

	@GetMapping("/details/{tweetId}")
	public String showTweetDetails(@PathVariable Long tweetId, Model model) {
		Tweet tweet = tweetRepository.findOne(tweetId);
		List<Comment> comments = commentRepository.findIdByOrderByCreatedDesc(tweetId);
		model.addAttribute("comments", comments);
		model.addAttribute("tweet", tweet);
		model.addAttribute("comment", new Comment());
		return "tweetInfo";

	}

	@PostMapping("/add")
	public String ProcessTweetForm(@Valid @ModelAttribute Tweet tweet, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/Warsztat6";
		} else {
			if (request.getSession().getAttribute("userId") != null) {
				tweetRepository.save(tweet);
			}
			return "redirect:/";
		}
	}

	@ModelAttribute("users")
	public List<User> findUsers() {
		return userRepository.findAll();
	}

	@ModelAttribute("loggedUser")
	public User getLoggedUser(HttpServletRequest request) {
		if (request.getSession().getAttribute("userId") != null) {
			return userRepository.findOne((Long) request.getSession().getAttribute("userId"));
		} else {
			User notLoggedIn = new User();
			notLoggedIn.setUsername("niezalogowany uzytkowniku");
			notLoggedIn.setLoggedIn(false);
			return notLoggedIn;
		}
	}

}