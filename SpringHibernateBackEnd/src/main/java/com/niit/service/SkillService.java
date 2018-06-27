package com.niit.service;

import java.util.List;

import com.niit.model.Skills;

public interface SkillService {

	public List<Skills> getSkillList();
	public boolean createSkills(Skills skill);
	public Skills getSkillById(int skill_id);
	public Skills getSkillByName(String skill_name);
	
	public boolean updateSkill(Skills skill);
	public boolean deleteSkill(int skill_id);
}
