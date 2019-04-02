package com.example.server.services;

import org.springframework.stereotype.Service;
import com.example.server.models.User;
import com.example.server.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

import java.net.URISyntaxException;

/**
 * User CRUD API, Request with combination of /api/user/{id}
 * NoteToSelf:Responsive Entities are Generics, they can return any type except Optional.
 * Optionals are returned by Repository methods.
 */
@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	/**
	 * Updates
	 * @param user
	 * @return
	 * @throws URISyntaxException
	 */
	public User createUser(User user) {
		log.info("Request to create user: {}", user);
		return userRepository.save(user);
	}

	/**
	 * Updates Object of user being sent with ID
	 * @param user
	 * @return
	 * TODO:Create partial updates patch https://www.baeldung.com/http-put-patch-difference-spring
	 *
	 */
	public User updateUser(User user){
		log.info("Request to update group: {}", user);
		return userRepository.save(user);
	}

	/**
	 * Deletes specific user by ID
	 * @param id
	 * @return
	 */
	public void deleteUser(Long id){
		log.info("Request to delete user: {}", id);
		userRepository.deleteById(id);
	}

	/**
	 * Retrieves specific user by ID param
	 * @param id
	 * @return
	 */
	public User getUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

	/**
	 * Returns all Users
	 * @return Iterable of User
	 */
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
