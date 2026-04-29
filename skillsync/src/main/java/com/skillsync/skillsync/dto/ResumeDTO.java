package com.skillsync.skillsync.dto;

public class ResumeDTO {

    private Long id;
    private String fileName;
    private String skills;

    // 🔽 Default Constructor
    public ResumeDTO() {}

    // 🔽 Parameterized Constructor
    public ResumeDTO(Long id, String fileName, String skills) {
        this.id = id;
        this.fileName = fileName;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}