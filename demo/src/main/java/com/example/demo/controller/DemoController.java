package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entity.User;
import com.example.demo.exception.GenericException;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserServiceImpl;



@RestController
@RequestMapping("/user")
public class DemoController {
	private static final String CLASS_NAME = DemoController.class.getName();
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserServiceImpl userService;
	Map<String, Object> map = new HashMap<String, Object>();
	  @PostMapping(value = "/create", consumes = "application/json", produces = "application/json") 
	  public Map<String, Object> createUser(@RequestBody User user) {
		 // System.out.println("Hi from the 1=>" + user);
		try {	 
			if(userService.setUser(user)) {
				//userRepo.save(user);
			  	map.put("code", 201);
				map.put("isSuccess", true);
				map.put("verbose", "registered successfully");
				return map;
			} else {
				map.put("code", 201);
				map.put("isSuccess", false);
				map.put("verbose", "something went wrong");
				return map;
			}	
			
		} catch(Exception exception) {
			System.out.println("In the exception");
			throw new GenericException("Hi! From the Generic Exception 1");
			
		}	
	  }
	 
	 

	@GetMapping("/count")
	public Map<String, Object> countUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {	 
			Long count = (long) userService.countUser();
			System.out.println("The count=>" + count);
			if(count > 0) {
				//userRepo.save(user);
			  	map.put("code", 201);
				map.put("isSuccess", true);
				map.put("verbose", "total user count =>" + count);
				return map;
			} else {
				map.put("code", 201);
				map.put("isSuccess", false);
				map.put("verbose", "something went wrong");
				return map;
			}	
			
		} catch(Exception exception) {
			System.out.println("In the exception");
			throw new GenericException("Hi! From the Generic Exception 1");
			
		}
		
	}
	
	@PutMapping("/login")
	public Map<String, Object> authUser(@RequestParam("email") String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("The email=>" + email);
		try {	 
			Boolean count = userService.authUser(email);
			System.out.println("The count=>" + count);
			if(count) {
				//userRepo.save(user);
			  	map.put("code", 201);
				map.put("isSuccess", true);
				map.put("verbose", "user is valid");
				return map;
			} else {
				map.put("code", 201);
				map.put("isSuccess", false);
				map.put("verbose", "something went wrong");
				return map;
			}	
			
		} catch(Exception exception) {
			System.out.println("In the exception");
			throw new GenericException("Hi! From the Generic Exception 1");
			
		}
		
	}
	
	@PutMapping("/getUsers")
	public Map<String, Object> getUsers(@RequestParam Map<String,String> requestParams) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String startdate=requestParams.get("startdate");
		String enddate=requestParams.get("enddate");
	
		System.out.println("startdate =>" + startdate);
		System.out.println("enddate =>" + enddate);
		
		map.put("code", 201);
		map.put("isSuccess", true);
		map.put("verbose", "user is valid");
		return map;
		
	}
}
