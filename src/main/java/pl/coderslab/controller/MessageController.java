package pl.coderslab.controller;

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

import pl.coderslab.entities.Message;
import pl.coderslab.entities.User;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/myMessages")
	public String showMessagesOfUser( Model model, HttpServletRequest request){
		Long id = (Long) request.getSession().getAttribute("userId");
		List<Message>received = messageRepository.findReceivedMessages(id);
		List<Message>sent = messageRepository.findSentMessages(id);
		model.addAttribute("receivedMessages", received);
		model.addAttribute("sentMessages", sent);
		
		return "showMessages";
	}
	
	@GetMapping("/send/{id}")
	public String showMessageForm(@PathVariable Long id, Model model, HttpServletRequest request){
		User sender = userRepository.findOne((Long)request.getSession().getAttribute("userId"));
		User receiver = userRepository.findOne(id);
		model.addAttribute("message", new Message());
		model.addAttribute("receiver",receiver);
		model.addAttribute("sender", sender);
		return "messageForm";
	}
	
	@PostMapping("/send")
	public String sendMessage(@Valid @ModelAttribute Message message, BindingResult result){
		if(result.hasErrors()){
			return "users/list";
		}
		messageRepository.save(message);
		return "redirect:/messages/myMessages";
		
		
	}

}