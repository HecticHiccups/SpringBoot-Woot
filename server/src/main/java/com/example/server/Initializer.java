package com.example.server;

import com.example.server.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import com.example.server.models.User;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

// Have to annotate this class to mark it as a Spring Bean inside the Spring context.
@Component
public class Initializer implements CommandLineRunner {

	private final UserRepository repository;

	public Initializer(UserRepository repository){
		this.repository = repository;
	}

	@Override
	public void run(String...strings){
		// Loads some data.
	}
}
