package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entities.Tweet;
import pl.coderslab.entities.User;



public interface TweetRepository extends JpaRepository<Tweet,Long>{
	List<Tweet> findByUser(User user);
	List<Tweet> findByUserId(Long id);
	List<Tweet>	findAllByOrderByCreatedDesc();
}
