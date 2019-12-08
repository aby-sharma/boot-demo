package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

	public Boolean setUser(User user);
	public Boolean authUser();
	public List getUsers();
	public double countUser();

}
