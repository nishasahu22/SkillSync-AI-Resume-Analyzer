package com.skillsync.skillsync.controller;

import com.skillsync.skillsync.service.SkillExtractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private SkillExtractionService service;

    // =====================================
    // 🔥 SKILL GAP ANALYSIS (ADVANCED)
    // =====================================
    @PostMapping("/analyze")
    public Map<String, Object> analyze(@RequestBody List<String> userSkills) {

        // 🎯 Target Job Skills
        List<String> jobSkills = List.of("Java", "Spring Boot", "Microservices");

        // ✅ Missing Skills
        List<String> missingSkills = service.findSkillGap(userSkills, jobSkills);

        // ✅ Matched Skills
        List<String> matchedSkills = new ArrayList<>();
        for (String skill : jobSkills) {
            if (userSkills.stream().anyMatch(s -> s.equalsIgnoreCase(skill))) {
                matchedSkills.add(skill);
            }
        }

        // ✅ Score Calculation
        double score = jobSkills.isEmpty() ? 0 :
                (matchedSkills.size() * 100.0) / jobSkills.size();

        // ✅ Final Response
        return Map.of(
                "status", "success",
                "matchedSkills", matchedSkills,
                "missingSkills", missingSkills,
                "score", score
        );
    }
}