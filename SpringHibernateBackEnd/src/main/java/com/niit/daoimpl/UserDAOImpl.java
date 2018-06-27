package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
	
		return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
	}

	public boolean createUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	public User getUserById(int user_id) {
		
		return (User) sessionFactory.getCurrentSession().createQuery("from User where user_id = "+user_id).uniqueResult();
	}

	public User getUserByUsername(String username) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where fname ='"+username+"'").uniqueResult();
	}
	

	public List<User> getUserforActivation() {
	
//		String hql = "from User where status = false" ;
//		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		
//		@SuppressWarnings("unchecked")
//		List<User> userList = (List<User>) query.list();
//		
//		if (userList != null && !userList.isEmpty()) {
//			return userList;
//		}
		return null;
	}

	public List<User> getUserOnSearch(String fname) {
		String hql = "from User where status=true and fname like "+ "'%"+ fname + "%'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return userList;
		}
		return null;
	}

	public boolean getUserActivated(int user_id) {
	
		//sessionFactory.getCurrentSession().createQuery("update User set status = true where user_id = "+user_id).executeUpdate();
		return true;	
	}

	public boolean updateUser(User user) {
	
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	public boolean deleteUser(User user) {
	
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

}
