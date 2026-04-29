package com.skillsync.skillsync.service;

import com.skillsync.skillsync.model.Job;
import com.skillsync.skillsync.model.Resume;
import com.skillsync.skillsync.repository.JobRepository;
import com.skillsync.skillsync.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobMatchingService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    // ✅ Get matched jobs based on resume ID
    public List<Job> matchJobs(Long resumeId) {

        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);

        if (optionalResume.isEmpty()) {
            throw new RuntimeException("Resume not found");
        }

        Resume resume = optionalResume.get();

        String resumeSkills = resume.getSkills();
        if (resumeSkills == null || resumeSkills.isEmpty()) {
            throw new RuntimeException("No skills found in resume");
        }

        List<String> resumeSkillList = Arrays.asList(resumeSkills.toLowerCase().split(","));

        List<Job> allJobs = jobRepository.findAll();

        // 🔥 Sort jobs by matching score
        allJobs.sort((job1, job2) ->
                Integer.compare(
                        calculateMatchScore(job2, resumeSkillList),
                        calculateMatchScore(job1, resumeSkillList)
                )
        );

        return allJobs;
    }

    // ✅ Calculate matching score
    private int calculateMatchScore(Job job, List<String> resumeSkills) {

        if (job.getSkillsRequired() == null) return 0;

        List<String> jobSkills = Arrays.asList(job.getSkillsRequired().toLowerCase().split(","));

        int score = 0;

        for (String skill : resumeSkills) {
            for (String jobSkill : jobSkills) {
                if (jobSkill.trim().contains(skill.trim())) {
                    score++;
                }
            }
        }

        return score;
    }
}