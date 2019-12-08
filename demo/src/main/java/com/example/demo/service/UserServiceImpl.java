package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAOImpl;
import com.example.demo.entity.User;
import com.example.demo.exception.GenericException;
import com.example.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	private static final String CLASS_NAME = UserServiceImpl.class.getName();
	
	@Autowired
	private UserRepo userRepo;
	
	//@Autowired
	//private UserDAOImpl userDao;
	
	//@Autowired
	//private User user;
	 
	
	@Override
	public Boolean setUser(User user) {
		
		try {	
			/*
			 * Object ref = null; ref.toString();
			 */
			if(userRepo.save(user) != null) {
				 return true;
			 } else {
				 return false;
			 }
			
		} catch(Exception exception) {
			System.out.println("In the exception");
			throw new GenericException("Hi! From the Generic Exception 2");
			
		}	
		
	}
	
	@Override
	public double countUser() {
		
		try {	
			/*
			 * Object ref = null; ref.toString();
			 */
			double count = userRepo.count();
			if(count > 0) {
				System.out.println("In if"); 
				return count;
			 } else {
				 System.out.println("In Else");
				 return count;
			 }
			
		} catch(Exception exception) {
			System.out.println("In the exception");
			throw new GenericException("Hi! From the Generic Exception 2");
		}
		
	}
	
	
	
	public Boolean authUser(String email) {
		try {	
			
			if(userRepo.findByEmail(email) != null) {
				return true;
			 } else {
				 return false;
			 }
			
		} catch(Exception exception) {
			System.out.println("In the exception");
			throw new GenericException("Hi! From the Generic Exception 2");
			
		}	
	}

	@Override
	public List getUsers() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Boolean authUser() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
