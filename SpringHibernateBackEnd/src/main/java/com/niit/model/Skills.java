package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int skill_id;
	
	private String skill_name;
	private int hours_taught;
	private int experience;
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public int getHours_taught() {
		return hours_taught;
	}
	public void setHours_taught(int hours_taught) {
		this.hours_taught = hours_taught;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
}
