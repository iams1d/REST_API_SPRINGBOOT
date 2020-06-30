package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;

@RestController
public class UserController {

	@Autowired
	UserRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		User u = repo.getOne(id);
		repo.delete(u);
		return "deleted";

	}

	@PostMapping(path = "/user")
	public User addUser(User user) {
		repo.save(user);
		return user;
	}

	@GetMapping(path = "/users")
	public List<User> getUsers() {

		return repo.findAll();

	}

	@PutMapping(path = "/user")
	public User saveOrUpdateUser(User user) {
		repo.save(user);
		return user;
	}

	@RequestMapping(path = "/user/{id}")
	public Optional<User> getUsers(@PathVariable("id") int id) {

		return repo.findById(id);

	}

}
