package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.User;
import com.niit.service.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUserList() {
		userService.getUserList();
		return new ResponseEntity<List<User>>(userService.getUserList(),HttpStatus.OK);		
	}
	
	@PostMapping("/")
	public ResponseEntity <Void> addUser(@RequestBody User user){
		
		userService.createUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<User> getUserById(@PathVariable("user_id") int user_id) {
		return new ResponseEntity<User>(userService.getUserById(user_id), HttpStatus.OK);

	}
	
//	@GetMapping("/{searchBy}/{search}")
//	public ResponseEntity<List<User>> searchUser(@PathVariable("searchBy") String searchBy,@PathVariable("search") String search ) throws Exception 
//	{
//		System.out.println(searchBy+"\n");
//		System.out.println("search "+search);
//		userService.searchUser(searchBy, search);
//		return new ResponseEntity<List<User>>(userService.searchUser(searchBy, search),HttpStatus.OK);
//	}
	
	@PostMapping("/user")
	public ResponseEntity<User> getUserByUsername(@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.getUserByUsername(user.getFname()),HttpStatus.OK);
	}
	
	@PutMapping("/{user_id}")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
	
	userService.updateUser(user);
	return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{user_id}")
	public ResponseEntity <Void> deleteUser(@PathVariable("userId") int userId){
		User user=userService.getUserById(userId);
		userService.deleteUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/*@PutMapping("/activate/{user_id}")
	public ResponseEntity<Void> activateUser(@PathVariable("user_id") int user_id) {
		if (userService.getUserById(user_id) != null) {
			userService.getUserActivated(user_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/toapprove")
	public ResponseEntity<List<User>> userListToApprove() {
		if (userService.getUserList().size() != 0) {
			return new ResponseEntity<List<User>>(userService.getUserforActivation(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	}*/
}
