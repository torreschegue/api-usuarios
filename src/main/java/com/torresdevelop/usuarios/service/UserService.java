package com.torresdevelop.usuarios.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;
import com.torresdevelop.usuarios.entity.User;

@Service
public class UserService {

	@Autowired
	private Faker faker;
	
	// lista de usuarios
	private List<User> user = new ArrayList<>();
	
	@PostConstruct // Indicar que este metodo tenga peoridad de inicializar cada vez que sea ejecutado
	public void init() {
		for(int i = 0; i<10; i++) {
			user.add((new User(faker.internet().uuid(),faker.funnyName().name(), faker.name().username(),faker.dragonBall().character() )));
		}
	}
	
	// Muestra Todo
	public List<User> getUser() {
		return user;
	}
	
	// Busca Por UserName
	public User getUserByUserName(String username){
		return user.stream()
				.filter(u -> u.getUserName().equals(username)).findAny()
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						String.format("User %s not found",username)));
	}
	
	// Crea un user
	public User createUser(User users) {
		if(user.stream().anyMatch(u -> u.getUserName().equals(users.getUserName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format("User %s Already Exists", users.getUserName()));
		}
		user.add(users);
		return users;
	}
	
	// Modifica Un User
	public User updateUser(User user, String username) {
		User userTobeUpdate = getUserByUserName(username);
		userTobeUpdate.setNickName(user.getNickName());
		userTobeUpdate.setPassword(user.getPassword());
		return userTobeUpdate;
	}
	
	// Elimina Un User
	public void deleteUser(String username) {
		User userTobeUpdate = getUserByUserName(username);
		user.remove(userTobeUpdate);
	}
	
	
}
