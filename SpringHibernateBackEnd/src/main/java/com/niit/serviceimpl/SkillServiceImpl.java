package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.SkillsDAO;
import com.niit.model.Skills;
import com.niit.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillsDAO skillDAO;

	public List<Skills> getSkillList() {
		return skillDAO.getSkillList();
	}

	public boolean createSkills(Skills skill) {
		skillDAO.createSkills(skill);
		return true;
	}

	public Skills getSkillById(int skill_id) {
		return skillDAO.getSkillById(skill_id);
	}

	public Skills getSkillByName(String skill_name) {
		return skillDAO.getSkillByName(skill_name);
	}

	public boolean updateSkill(Skills skill) {
		skillDAO.updateSkill(skill);
		return true;
	}

	public boolean deleteSkill(int skill_id) {
		skillDAO.deleteSkill(skill_id);
		return true;
	}

}
