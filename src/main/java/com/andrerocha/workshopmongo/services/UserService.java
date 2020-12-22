package com.andrerocha.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrerocha.workshopmongo.domain.User;
import com.andrerocha.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	//INSTANCIAR ALTOMATICAMENTE UM OBJETO
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll(); 
	}
	
}
