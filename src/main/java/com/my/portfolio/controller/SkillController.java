package com.my.portfolio.controller;

import com.my.portfolio.dto.SkillRequest;
import com.my.portfolio.model.Skill;
import com.my.portfolio.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> getSkills() {
        return skillService.getAllSkills();
    }

    @PostMapping
    public Skill createSkill(@Valid @RequestBody SkillRequest request) {
        return skillService.createSkill(request);
    }
}
