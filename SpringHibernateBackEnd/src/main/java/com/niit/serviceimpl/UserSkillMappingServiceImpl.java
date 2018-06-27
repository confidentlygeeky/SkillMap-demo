package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserSkillMappingDAO;
import com.niit.model.UserSkillMapping;
import com.niit.service.UserSkillMappingService;

@Service
public class UserSkillMappingServiceImpl implements UserSkillMappingService {

	@Autowired
	private UserSkillMappingDAO userSkillMappingDAO;

	public List<UserSkillMapping> getSkillList() {
		return userSkillMappingDAO.getSkillList();
	}

	public boolean createUserSkillMapping(UserSkillMapping userSkillMapping) {
		userSkillMappingDAO.createUserSkillMapping(userSkillMapping);
		return true;
	}

	public UserSkillMapping getUserSkillMappingById(int skill_id) {
		return userSkillMappingDAO.getUserSkillMappingById(skill_id);
	}

	public List<UserSkillMapping> getUserSkillMappingByUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserSkillMapping> getUserSkillMappingBySkillId(int skill_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserSkillMapping getSkillByName(String skill_name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateUserSkillMapping(UserSkillMapping userSkillMapping) {
		userSkillMappingDAO.updateUserSkillMapping(userSkillMapping);
		return true;
	}

	public boolean deleteUserSkillMapping(int userSkill_id) {
		userSkillMappingDAO.deleteUserSkillMapping(userSkill_id);
		return true;
	}

}
