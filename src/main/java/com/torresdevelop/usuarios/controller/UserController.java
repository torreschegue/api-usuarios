package com.torresdevelop.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torresdevelop.usuarios.entity.User;
import com.torresdevelop.usuarios.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Para Mostrar Todos
	@GetMapping
	public ResponseEntity<List<User>> getUserAll(){
		return new ResponseEntity<List<User>>(userService.getUser(), HttpStatus.OK);
	}
	
	// Mostrar Por UserName
	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username")String username){
		return new ResponseEntity<User>(userService.getUserByUserName(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User>CreateUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username")String username,
			@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, username), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username")String username){
		userService.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
