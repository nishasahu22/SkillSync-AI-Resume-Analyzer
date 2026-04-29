const BASE_URL = "http://localhost:8081/api";

// 🔹 Upload Resume
export async function uploadResume(file) {
    let formData = new FormData();
    formData.append("file", file);

    let res = await fetch(`${BASE_URL}/resume/upload`, {
        method: "POST",
        body: formData
    });

    return res.json();
}

// 🔹 Get All Resumes
export async function getAllResumes() {
    let res = await fetch(`${BASE_URL}/resume/all`);
    return res.json();
}

// 🔹 Delete Resume
export async function deleteResume(id) {
    let res = await fetch(`${BASE_URL}/resume/delete/${id}`, {
        method: "DELETE"
    });

    return res.text();
}