package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.entities.Comment;
import pl.coderslab.entities.Tweet;

public interface CommentRepository extends JpaRepository<Comment,Long>{
	List<Comment>findByTweet(Tweet tweet);
	List<Comment>findByTweetId(Long id);
	@Query("SELECT c FROM Comment c WHERE c.tweet.id = ?1 ORDER BY c.created DESC")
	List<Comment>findIdByOrderByCreatedDesc(Long id);
	
}