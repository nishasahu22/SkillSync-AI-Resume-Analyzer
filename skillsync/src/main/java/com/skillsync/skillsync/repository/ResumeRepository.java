package com.skillsync.skillsync.repository;

import com.skillsync.skillsync.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    // 🔍 Find by file name
    List<Resume> findByFileNameContainingIgnoreCase(String fileName);

    // 🔍 Find resumes containing specific skill
    List<Resume> findBySkillsContainingIgnoreCase(String skill);

    // 🔍 Find resumes by extracted text keyword
    List<Resume> findByExtractedTextContainingIgnoreCase(String keyword);
}