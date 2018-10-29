package com.skilltrace.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilltrace.model.Skill;
import com.skilltrace.service.SkillService;

@RestController
@CrossOrigin
@RequestMapping("/skills")
public class SkillApi {
	
	@Autowired
	private SkillService skillService;

	@GetMapping
	public ResponseEntity<List<Skill>> getAllSkills() {
		return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);
	}
	
	@GetMapping("/{skillId}")
	public ResponseEntity<Skill> getEmployeeById(@PathVariable("skillId") long skillId) {
		ResponseEntity<Skill> resp;

		Skill skill = skillService.getSkillById(skillId);
		if (skill == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(skill, HttpStatus.OK);
		return resp;
	}

	@PostMapping
	public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
		ResponseEntity<Skill> resp = null;

		//if (skillService.existsByBasic(Skill.getBasic()))
			//resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		
		if (resp == null) {
			System.out.println(skill);
			Skill skill1 = skillService.addSkill(skill);
			System.out.println(skill1);
			if (skill1 == null)
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<>(skill1, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping
	public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill) {
		ResponseEntity<Skill> resp = null;

		Skill c = skillService.getSkillById(skill.getSkillId());

		//if (!((skill.getBasic())==c.getBasic()))
		//	if (skillService.existsByBasic(skill.getBasic())) {
		//		resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		//	}

		if (resp == null) {
			c = skillService.updateSkill(skill);
			if (c == null)
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<>(c, HttpStatus.OK);
		}
		return resp;
	}

	@DeleteMapping("/{skillId}")
	public ResponseEntity<Void> deleteSkill(@PathVariable("skillId") long skillId) {
		ResponseEntity<Void> resp = null;
		if (skillService.deleteSkill(skillId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}
	
}
