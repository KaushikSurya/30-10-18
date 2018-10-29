 package com.skilltrace.service;

import java.util.List;

import com.skilltrace.model.Skill;

public interface SkillService {
	
	public Skill addSkill(Skill skill);
	public Skill updateSkill(Skill skill);
	public boolean deleteSkill(long skillId);
	public double calculateFinalScore(long employeeId);
	public List<Skill> getAllSkills();
	public Skill getSkillById(long skillId);
	
}
