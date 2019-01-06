package com.example.server.services;

import com.example.server.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.server.models.User;
import com.example.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import javax.validation.Valid;
import java.net.URISyntaxException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.net.URI;


/**
 * User CRUD API, Request with combination of /api/user/{id}
 * NoteToSelf:Responsive Entities are Generics, they can return any type except Optional.
 * Optionals are returned by Repository methods.
 */

@RestController
@RequestMapping("/api")
public class UserService {

	private final Logger log = LoggerFactory.getLogger(UserService.class);


	@Autowired
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	//@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException{
		log.info("Request to create user: {}", user);
		User result = userRepository.save(user);
		return ResponseEntity.created(new URI("/api/user/" + result.getUserID())).body(result);
	}

	//@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(value = "/user")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
		log.info("Request to update group: {}", user);
		User result = userRepository.save(user);
		return ResponseEntity.ok().body(result);
	}

	//@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id){
		log.info("Request to delete user: {}", id);
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/user/{id}")
	ResponseEntity<?> getUser(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/users")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
