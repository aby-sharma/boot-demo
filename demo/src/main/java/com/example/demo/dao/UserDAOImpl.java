package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.User;

@Repository
public class UserDAOImpl {
	
	private static final String CLASS_NAME = UserDAOImpl.class.getName();
	
	
	
	public Boolean setUser(User user) {
		System.out.println("Hi from the =>"  + CLASS_NAME);
		System.out.println(user.toString());
		return true;
	}

	
	public Boolean authUser() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public double countUser() {
		// TODO Auto-generated method stub
		return 0;
	}

}
