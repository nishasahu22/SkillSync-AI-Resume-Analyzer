package com.skillsync.skillsync.controller;

import com.skillsync.skillsync.model.Job;
import com.skillsync.skillsync.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    // ✅ Add Job
    @PostMapping("/add")
    public Job addJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    // ✅ Get All Jobs
    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // ✅ Search by Title
    @GetMapping("/search/title")
    public List<Job> searchByTitle(@RequestParam String title) {
        return jobRepository.findByTitleContainingIgnoreCase(title);
    }

    // ✅ Search by Company
    @GetMapping("/search/company")
    public List<Job> searchByCompany(@RequestParam String company) {
        return jobRepository.findByCompanyContainingIgnoreCase(company);
    }

    // ✅ Search by Location
    @GetMapping("/search/location")
    public List<Job> searchByLocation(@RequestParam String location) {
        return jobRepository.findByLocationContainingIgnoreCase(location);
    }

    // ✅ Search by Skills
    @GetMapping("/search/skill")
    public List<Job> searchBySkill(@RequestParam String skill) {
        return jobRepository.findBySkillsRequiredContainingIgnoreCase(skill);
    }
}