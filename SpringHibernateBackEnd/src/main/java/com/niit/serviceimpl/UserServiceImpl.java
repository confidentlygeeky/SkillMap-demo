package com.niit.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDAO;
import com.niit.model.User;
import com.niit.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public List<User> getUserList() {
		return userDAO.getUserList();
	}

	public boolean createUser(User user) {
		userDAO.createUser(user);
		return true;
	}

	public User getUserById(int user_id) {
		return userDAO.getUserById(user_id);
	}

	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}

	public List<User> getUserforActivation() {
		return userDAO.getUserforActivation();
	}

	public List<User> getUserOnSearch(String fname) {
		return userDAO.getUserOnSearch(fname);
		
	}

	public boolean getUserActivated(int user_id) {
		userDAO.getUserActivated(user_id);
		return true;
	}

	public boolean updateUser(User user) {
		userDAO.updateUser(user);
		return true;
	}

	public boolean deleteUser(User user) {
		userDAO.deleteUser(user);
		return true;
	}

}
