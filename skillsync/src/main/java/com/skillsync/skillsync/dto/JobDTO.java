package com.skillsync.skillsync.dto;

public class JobDTO {

    private Long id;
    private String title;
    private String company;
    private String location;
    private String skillsRequired;

    // 🔽 Default Constructor
    public JobDTO() {}

    // 🔽 Parameterized Constructor
    public JobDTO(Long id, String title, String company, String location, String skillsRequired) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.skillsRequired = skillsRequired;
    }

    // 🔽 Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }
}