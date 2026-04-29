package com.skillsync.skillsync.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SkillExtractionService {

    // 🔥 Predefined skills list
    private static final List<String> SKILLS_DB = Arrays.asList(
            "java", "spring", "spring boot", "hibernate",
            "mysql", "sql", "mongodb",
            "python", "machine learning", "data science",
            "deep learning", "nlp",
            "react", "angular", "javascript",
            "html", "css", "bootstrap",
            "c", "c++", "c#", "docker", "kubernetes"
    );

    // ✅ Extract skills from resume text
    public String extractSkills(String text) {

        if (text == null || text.isEmpty()) {
            return "";
        }

        String lowerText = text.toLowerCase();
        Set<String> foundSkills = new LinkedHashSet<>();

        for (String skill : SKILLS_DB) {
            if (lowerText.contains(skill)) {
                foundSkills.add(skill);
            }
        }

        return String.join(", ", foundSkills);
    }

    // 🔥 FIND SKILL GAP (IMPORTANT FEATURE)
    public List<String> findSkillGap(List<String> userSkills, List<String> jobSkills) {

        // Null safety
        if (userSkills == null) userSkills = new ArrayList<>();
        if (jobSkills == null) jobSkills = new ArrayList<>();

        // Normalize (lowercase + trim)
        Set<String> userSkillSet = new HashSet<>();
        for (String skill : userSkills) {
            userSkillSet.add(skill.toLowerCase().trim());
        }

        List<String> missingSkills = new ArrayList<>();

        for (String jobSkill : jobSkills) {
            String normalizedJobSkill = jobSkill.toLowerCase().trim();

            if (!userSkillSet.contains(normalizedJobSkill)) {
                missingSkills.add(jobSkill); // original format return
            }
        }

        return missingSkills;
    }
}