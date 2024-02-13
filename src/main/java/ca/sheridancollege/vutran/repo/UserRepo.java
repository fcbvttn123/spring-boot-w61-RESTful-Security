package ca.sheridancollege.vutran.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.User;

public interface UserRepo extends JpaRepository<User, Long> {
	public Optional<User> findByEmail(String email);
}
