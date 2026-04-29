# SkillSync - AI Resume Analyzer

## 📌 Project Description
SkillSync is an AI-based Resume Analyzer web application that allows users to upload resumes and automatically extracts skills using Java Spring Boot backend and a simple frontend.

## 🚀 Features
- Upload resume (PDF)
- Extract text using Apache PDFBox
- Skill detection (Java, Python, React, etc.)
- Store resume data in MySQL database
- View uploaded resumes

## 🛠️ Tech Stack
- Frontend: HTML, CSS, JavaScript
- Backend: Spring Boot (Java)
- Database: MySQL
- Library: Apache PDFBox

## 📂 Project Structure
- Controller → Handles API requests
- Service → Business logic
- Repository → Database layer
- Util → PDF parsing logic

## 🔗 API Endpoints
- POST /api/resume/upload → Upload resume
- GET /api/resume/all → Get all resumes
- GET /api/resume/{id} → Get resume by ID
- DELETE /api/resume/delete/{id} → Delete resume

## ⚡ How to Run
1. Start MySQL server
2. Run Spring Boot application
3. Open frontend (upload.html / dashboard.html)
4. Upload resume

## 👩‍💻 Author
Nisha Sahu
