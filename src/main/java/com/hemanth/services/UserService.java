package com.hemanth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemanth.entities.User;
import com.hemanth.exceptions.UserNotFoundException;
import com.hemanth.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository repo;

	
	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}

	
	public void save(User user) {
		repo.save(user);

	}
	
	public User get(Integer id) throws UserNotFoundException {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		 throw new UserNotFoundException("Couldn't find the user with id: "+ id);
	}
	
	public void delete(Integer id) throws UserNotFoundException {
	
		Optional<User> user = repo.findById(id);
		if(user.get() == null || !user.isPresent()) {
			 throw new UserNotFoundException("Couldn't find the user with id: "+ id);
		}
		
		 repo.deleteById(id);
		
	}
	
}
