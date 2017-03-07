package com.softtek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.user.User;
import com.softtek.user.UserRepository;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public User getUser(@PathVariable(value="name")String name){
		return userRepository.findByName(name);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addUser(@RequestBody User user){
		userRepository.insert(user);
	}
	
}
