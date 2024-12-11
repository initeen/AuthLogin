package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;

	public AuthController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password){
		
		Optional<User> user = userRepository.findByUsername(username);
		
		if(user.isPresent() && user.get().getPassword().equals(password)) {
			return ResponseEntity.ok("Login Successful");
		} else {
			return ResponseEntity.status(401).body("Invalid Credentials");
		}
	}
}
