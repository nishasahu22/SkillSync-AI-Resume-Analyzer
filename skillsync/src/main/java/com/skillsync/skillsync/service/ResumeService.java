package com.skillsync.skillsync.service;

import com.skillsync.skillsync.model.Resume;
import com.skillsync.skillsync.repository.ResumeRepository;
import com.skillsync.skillsync.util.PDFParserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@Service
public class ResumeService {

    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @Autowired
    private ResumeRepository resumeRepository;

    // ✅ Upload + Save Resume
    public Resume saveResume(MultipartFile file) {

        try {
            // 🔹 Create folder if not exists
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            // 🔹 Save file
            String filePath = UPLOAD_DIR + file.getOriginalFilename();
            File dest = new File(filePath);
            file.transferTo(dest);

            // 🔹 Extract text from PDF
            String extractedText;
            try {
                extractedText = PDFParserUtil.extractText(dest);
            } catch (Exception e) {
                extractedText = "Could not extract text";
            }

            String skills = extractSkills(extractedText);

            // 🔹 Save to DB
            Resume resume = new Resume();
            resume.setFileName(file.getOriginalFilename());
            resume.setFilePath(filePath);
            resume.setExtractedText(extractedText);
            resume.setSkills(skills);

            return resumeRepository.save(resume);

        } catch (Exception e) {
            throw new RuntimeException("Error uploading resume: " + e.getMessage());
        }
    }

    // ✅ Get all resumes
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    // ✅ Get resume by ID
    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));
    }

    // ✅ Delete resume
    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }

    // 🔥 BASIC SKILL EXTRACTION (IMPORTANT)
    private String extractSkills(String text) {

        List<String> predefinedSkills = Arrays.asList(
                "java", "spring", "spring boot", "mysql",
                "python", "machine learning", "data science",
                "react", "angular", "javascript", "html", "css"
        );

        List<String> foundSkills = new ArrayList<>();

        String lowerText = text.toLowerCase();

        for (String skill : predefinedSkills) {
            if (lowerText.contains(skill)) {
                foundSkills.add(skill);
            }
        }

        return String.join(", ", foundSkills);
    }
}