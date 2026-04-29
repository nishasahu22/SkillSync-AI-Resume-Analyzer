package com.skillsync.skillsync.controller;

import com.skillsync.skillsync.model.Resume;
import com.skillsync.skillsync.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin("*")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    // ✅ Upload Resume
    @PostMapping("/upload")
    public Resume uploadResume(@RequestParam("file") MultipartFile file) {

        System.out.println("🔥 API HIT");
        System.out.println("File name: " + file.getOriginalFilename());

        return resumeService.saveResume(file);
    }

    // ✅ Get All Resumes
    @GetMapping("/all")
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    // ✅ Get Resume by ID
    @GetMapping("/{id}")
    public Resume getResumeById(@PathVariable Long id) {
        return resumeService.getResumeById(id);
    }

    // ✅ Delete Resume
    @DeleteMapping("/delete/{id}")
    public String deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return "Resume deleted successfully";
    }
}