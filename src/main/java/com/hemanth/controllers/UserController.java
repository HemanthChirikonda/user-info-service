package com.hemanth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hemanth.entities.User;
import com.hemanth.exceptions.UserNotFoundException;
import com.hemanth.services.UserService;

@Controller
public class UserController {
	
	@Autowired UserService service;
	
	
	@GetMapping("/users")
	public List<User> listAllUsers(){
		List<User> users= service.listAll();
		return users;
		
	}
	
	@PostMapping("/users/save")
	public String SaveUser(@Validated @RequestBody User user, RedirectAttributes ra) {
		service.save(user);
		ra.addAttribute("message", "The user has been saved succcessfully!");
		return "redirect:/users";
		
	}
	
	
	@PutMapping("/user/edit/{id}")
	public String updateUser(@PathVariable Integer id, RedirectAttributes ra, @Validated @RequestBody User requestBodyUser) {
		try {
			User user = service.get(id);
			user.setEmail(requestBodyUser.getEmail());
			user.setName(requestBodyUser.getName());
			user.setPassword(requestBodyUser.getPassword());
		     service.save(user);
		     ra.addFlashAttribute("message","The user has been updated successfully!");
		} catch (UserNotFoundException e) {
			 ra.addAttribute("error", e.getMessage());
		}
		 return "redirect:/users";
		
	}
	
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable Integer id, RedirectAttributes ra, Model model) {
		try {
			service.delete(id);
			ra.addFlashAttribute("message","The user deleted successfully!");
		} catch (UserNotFoundException e) {
			 ra.addAttribute("error", e.getMessage());
		}	
		 return "redirect:/users";
		
	}

}
