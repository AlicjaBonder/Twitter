package pl.coderslab.controller;


import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entities.Comment;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/comments")
public class CommentController {
//	@Autowired
//	private CommentRepository commentRepository;
//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private TweetRepository tweetRepository;
//	
//	@PostMapping("/add/{id}")
//	public String ProcessCommentForm(@Valid @ModelAttribute Comment comment, BindingResult result, HttpServletRequest request, @PathVariable Long id){
//		if(result.hasErrors()){
//			return "tweetInfo";
//		}else{
//			if(request.getSession().getAttribute("userId")!= null){
//				Comment com = new Comment();
//				com.setTweet(tweetRepository.findOne(id));
//				com.setUser(userRepository.findOne(((Long) request.getSession().getAttribute("userId"))));
//				Timestamp now = new Timestamp(new Date().getTime());
//				com.setCreated(now);
//				com.setText(comment.getText());
//				commentRepository.save(com);
//			}
//			return "redirect:/tweets/details/"+id;
//		}
//	}
//	
	
//	@RequestMapping(path="/addCustom", method=RequestMethod.GET)
//	public String addCustomComment(HttpServletRequest request){
//		Comment comment = new Comment();
//		comment.setText("ZZZZZ");
//		comment.setUser(userRepository.findOne((Long) request.getSession().getAttribute("userId")));
//		comment.setCreated(new Timestamp(new Date().getTime()));
//		comment.setTweet(tweetRepository.findOne(15L));
//		commentRepository.save(comment);
//		return "tweetInfo";
//		
//	}

}