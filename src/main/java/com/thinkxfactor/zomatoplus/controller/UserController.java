package com.thinkxfactor.zomatoplus.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;


@RestController
@RequestMapping("/user")//class level mapping
public class UserController {
 
	

	/*@GetMapping("/login")
	//without taking parameters
	//user/login
	public User userLogin() {
		User usr = new User();
		usr.setUsername("Shreya");
		usr.setPassword("abcd");
		return usr;
	}
	//taking parameters from user
	//user/login?username=...&password=...
	public User userLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		User usr = new User();
		usr.setUsername(username);
		usr.setPassword(password);
		return usr;
	}
	@GetMapping("/all")
	//for multiple objects, to list all users
	//user/all
	public List<User> userList() {
		List<User> users = new ArrayList<>();
		User usr1,usr2,usr3;
		usr1 = new User("Shreya","abcd");
		usr2 = new User("Akshay","xyz");
		usr3 = new User("Ananya","pqr");
		users.add(usr1);
		users.add(usr2);
		users.add(usr3);
		return users;
	}
	
	//creating user registration
	@PostMapping("/create")
	public User userCreate(@RequestBody User user)
	{
		System.out.println(user.toString());
		return user;
	}
	//user login of post type for user/login
	@PostMapping("/login")
	public User userLogin(@RequestBody User user)
	{
		System.out.println(user.toString());
		return user;
	}*/
	@Autowired  //spring will create all the objects for us (dependency injection)(IOC)
	private UserRepository userRepository;
	
	@PostMapping("/add")//method level mapping
	public User addUser(@RequestBody User user)
	{
		User persistedUser=userRepository.save(user);//inserting in the database
		return persistedUser;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll()
	{
		List<User> listofusers = userRepository.findAll();//retrieving all the records from the database
		return listofusers;
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam("name") String username, @RequestParam("password") String password)
	{
		User persistedUser = userRepository.findByNameAndPassword(username, password);
		return persistedUser;
	}
	@PostMapping("/login")
	public User login(@RequestBody User user )
	{
		User persistedUser = userRepository.findByNameAndPassword(user.getName(),user.getPassword());
		return persistedUser;
	}
}
 