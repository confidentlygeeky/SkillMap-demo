package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.SkillsDAO;
import com.niit.model.Skills;

@Repository
@Transactional
public class SkillsDAOImpl implements SkillsDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Skills> getSkillList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Skills").list();
	}

	public boolean createSkills(Skills skill) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(skill);
		return true;
	}

	public Skills getSkillById(int skill_id) {
		// TODO Auto-generated method stub
		return (Skills) sessionFactory.getCurrentSession().createQuery("from Skills where skill_id = "+skill_id).uniqueResult();
	}

	public Skills getSkillByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateSkill(Skills skill) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(skill);
		return true;
	}

	public boolean deleteSkill(int skill_id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getSkillById(skill_id));
		return true;
	}

}
