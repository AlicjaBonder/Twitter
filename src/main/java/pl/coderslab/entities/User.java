package pl.coderslab.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	@Column(nullable=false)
	private String username;
	@NotNull
	@NotBlank
	@Column(nullable=false)
	private String password;
	
	private boolean enabled;
	
	@NotNull
	@NotBlank
	@Column(nullable=false, unique = true)
	@Email
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<Tweet> tweets = new ArrayList<Tweet>();
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments = new ArrayList<Comment>();
	
	@OneToMany(mappedBy="receiver")
	private List<Message>received = new ArrayList<Message>();
	
	@OneToMany(mappedBy="sender")
	private List<Message>  sent = new ArrayList<Message>();
	private boolean loggedIn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
