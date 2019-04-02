package com.example.server.repositories;

import com.example.server.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.net.URISyntaxException;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  ResponseEntity<User> createUser(User user) throws URISyntaxException;
  ResponseEntity<User> updateUser(User user);
  ResponseEntity<User> deleteUser(Long id);
  ResponseEntity<?> getUser(Long id);
  Iterable<User> getAllUsers();
}
