package com.skillsync.skillsync.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String filePath;

    @Column(length = 10000)
    private String extractedText;

    private String skills; // extracted skills (comma-separated)

    // 🔽 Default Constructor
    public Resume() {}

    // 🔽 Parameterized Constructor
    public Resume(Long id, String fileName, String filePath, String extractedText, String skills) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.extractedText = extractedText;
        this.skills = skills;
    }

    // 🔽 Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getExtractedText() {
        return extractedText;
    }

    public void setExtractedText(String extractedText) {
        this.extractedText = extractedText;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}