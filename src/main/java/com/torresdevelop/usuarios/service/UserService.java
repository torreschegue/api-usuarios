package com.torresdevelop.usuarios.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			user.add((new User(faker.idNumber().invalid(),faker.funnyName().name(), faker.name().username(),faker.dragonBall().character() )));
		}
	}

	public List<User> getUser() {
		return user;
	}
	
	
	
	
}
