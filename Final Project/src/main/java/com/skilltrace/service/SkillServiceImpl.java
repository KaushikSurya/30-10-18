package com.skilltrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltrace.model.EmployeeSkill;
import com.skilltrace.model.Skill;
import com.skilltrace.repo.EmployeeSkillRepo;
import com.skilltrace.repo.SkillRepo;


@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepo skillRepo;
	
	@Autowired
	private EmployeeSkillRepo empSkillRepo;

	@Override
	public Skill addSkill(Skill skill) {
		skillRepo.save(skill);
		return skill;
	}
	
	@Override
	public Skill updateSkill(Skill skill) {
		if(skillRepo.existsById(skill.getSkillId()))
			skillRepo.save(skill);
		return skill;
	}

	@Override
	public boolean deleteSkill(long skillId) {
		boolean isDeleted = false;
		if (skillRepo.existsById(skillId)) {
			skillRepo.deleteById(skillId);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public double calculateFinalScore(long employeeId) {
		double finalScore = 0;
		int totalLevel = 0;
		double avgLevel = 0;
		int totalScore = 0;
		double avgScore = 0.0;
		List<Skill> skills = getAllSkills();
		List<EmployeeSkill> empSkills = empSkillRepo.findAllByEmployeeId(employeeId);
		for (int i = 0; i < empSkills.size(); i++) {
			EmployeeSkill empSkill1 = empSkills.get(i);
			totalLevel += empSkill1.getLevel();
			for (int j = 0; j < skills.size(); j++) {
				Skill skill = skills.get(j);
				if(skill.getSkillId()==empSkill1.getSkillId()) {
					totalScore += skill.getScore();
			}
			}
		}
		avgLevel = totalLevel / empSkills.size();
		avgScore = totalScore / empSkills.size();
		finalScore = (2 * avgLevel + 3 * avgScore)/5;
		return finalScore;
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillRepo.findAll();
	}

	@Override
	public Skill getSkillById(long skillId) {
		Optional<Skill> opt = skillRepo.findById(skillId);
		return opt.isPresent() ? opt.get() : null;
	}

}
