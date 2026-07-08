package com.my.portfolio.service;

import com.my.portfolio.dto.SkillRequest;
import com.my.portfolio.model.Skill;
import com.my.portfolio.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAllByOrderBySortOrderAsc();
    }

    public Skill createSkill(SkillRequest request) {
        Skill skill = new Skill();
        skill.setName(request.name());
        skill.setSortOrder(request.sortOrder());
        return skillRepository.save(skill);
    }
}
