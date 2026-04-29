package com.skillsync.skillsync.repository;

import com.skillsync.skillsync.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    // 🔍 Find jobs by title
    List<Job> findByTitleContainingIgnoreCase(String title);

    // 🔍 Find jobs by company
    List<Job> findByCompanyContainingIgnoreCase(String company);

    // 🔍 Find jobs by location
    List<Job> findByLocationContainingIgnoreCase(String location);

    // 🔍 Find jobs by required skills (basic match)
    List<Job> findBySkillsRequiredContainingIgnoreCase(String skill);
}