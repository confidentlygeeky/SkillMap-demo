package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.config.DBConfig;
import com.niit.model.User;
import com.niit.service.UserService;

@RunWith(SpringRunner.class)

@SpringJUnitConfig(classes=DBConfig.class)
public class UserTest {

	@Autowired
	UserService userService;
	
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
	}
	
	@After
	public void tearDown() throws Exception {
		userService=null;
	}
	
	@Test
	public void getuserList() {
		List<User> getUserList = userService.getUserList();
		for(User user:getUserList) {
			System.out.println("First Name: "+user.getFname());
			System.out.println("Last Name: "+user.getLname());
			System.out.println("Email: "+user.getEmail());
			System.out.println("Password: "+user.getPassword());
			System.out.println("Contact: "+user.getContact());
			System.out.println("Role: "+user.getRole());
			System.out.println("Skill: "+user.getSkill());
			
		}
		assertEquals(getUserList.size() >0, userService.getUserList());		
	}
	
	@Test
	public void createUserTest() {
		User user=new User();
		user.setFname("Manoj");
		user.setLname("Umrigar");
		user.setEmail("mumrigar@gmail.com");
		user.setPassword("pass@123");
		user.setContact("9821284924");
		user.setRole("Employee");
		user.setSkill("Java");
		
		assertEquals(true, userService.createUser(user));
		System.out.println("Record added");
		
	}
	
	@Ignore
	@Test
	public void updateUserTest() {
		User user = userService.getUserById(1);
		
		System.out.println("-----In edit mode------");
		user.setFname("Kunaal");
		user.setLname("Umrigar");
		user.setEmail("kunaal@gmail.com");
		user.setPassword("abc@123");
		user.setContact("9969684625");
		user.setRole("HR");
		user.setSkill("Leadership");
		assertEquals(true, userService.updateUser(user));
	}
	
	@Ignore
	@Test
	public void deleteUserTest() {
		User user = userService.getUserById(1);
		assertEquals(true, userService.deleteUser(user));
		System.out.println("Record deleted");
	}
	
	@Ignore
	@Test
	public void getUserActivatedTest() {
		if (userService.getUserById(1) != null) {
			assertEquals("User got activated", true, userService.getUserActivated(1));
		}
	}
	
	
//	@Test
//	public void getUserOnSearchTest() {
//		if (userService.getUserList() != null) {
//
//			String search = "Ku";
//			boolean flag = true;
//			if (flag = true) {
//
//				if (userService.getUserOnSearch(search) != null) {
//					flag = true;
//					userService.getUserOnSearch(search);
//					assertTrue("Test case Succeed", flag);
//					System.out.println("Search successful");
//				}
//			} else {
//
//				flag = false;
//				assertFalse("Test case failed", flag);
//				System.out.println("Unsuccessful");
//			}
//		}
//	}
}
