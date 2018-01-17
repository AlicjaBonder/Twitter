package pl.coderslab.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findFirstByUsername(String login);

	User findByEmail(String email);
	

}
