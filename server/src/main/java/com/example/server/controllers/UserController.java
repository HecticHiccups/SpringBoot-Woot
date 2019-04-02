package com.example.server.controllers;

import com.example.server.models.User;
import com.example.server.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(value = "/create-user")
  public ResponseEntity createUser(@Valid @RequestBody User user) {

    User createdUser = userService.createUser(user);

    if (createdUser != null) {
      try {
        return ResponseEntity.created(new URI("/api/user/" + createdUser.getUserID())).body(createdUser);
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    }
    return ResponseEntity.noContent().build();
  }

  @PutMapping(value = "/user")
  public ResponseEntity updateUser(@Valid @RequestBody User user) {

    User userUpdated = userService.updateUser(user);

      try {
        if (userUpdated != null) {
          return ResponseEntity.ok().body(userUpdated);
        }
      } catch (NullPointerException e) {
        e.printStackTrace();
      }
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/user/{id}")
  public ResponseEntity deleteUser(@PathVariable Long id){
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/user/{id}")
  public ResponseEntity getUser(@PathVariable Long id) {

    User user = userService.getUser(id);

    if (user != null) {
      return ResponseEntity.ok().body(user);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping(value = "/users")
  public List<User> getAllUsers() {
    return (List<User>) userService.getAllUsers();
  }

}
