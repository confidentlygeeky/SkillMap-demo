package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserSkillMappingDAO;
import com.niit.model.UserSkillMapping;

@Repository
@Transactional
public class UserSkillMappingImpl implements UserSkillMappingDAO {

	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<UserSkillMapping> getSkillList() {
		return sessionFactory.getCurrentSession().createQuery("from UserSkillMapping").list();
	}

	public boolean createUserSkillMapping(UserSkillMapping userSkillMapping) {
		sessionFactory.getCurrentSession().save(userSkillMapping);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<UserSkillMapping> getUserSkillMappingByUserId(int user_id) {
		return sessionFactory.getCurrentSession().createQuery("from UserSkillMapping where user_id=" + user_id).list();
	}

	public List<UserSkillMapping> getUserSkillMappingBySkillId(int skill_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateUserSkillMapping(UserSkillMapping userSkillMapping) {
		sessionFactory.getCurrentSession().update(userSkillMapping);
		return true;
	}

	public boolean deleteUserSkillMapping(int userSkill_id) {
		sessionFactory.getCurrentSession().delete(getUserSkillMappingById(userSkill_id));
		return true;
	}

	public UserSkillMapping getUserSkillMappingById(int userSkill_id) {
		String hql = "from UserSkillMapping where userSkill_id=" + userSkill_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		UserSkillMapping userSkillMapping = (UserSkillMapping) query.uniqueResult();
		return userSkillMapping;
	}

	public UserSkillMapping getSkillByName(String skill_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
