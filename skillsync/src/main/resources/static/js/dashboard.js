import { getAllResumes, deleteResume } from "./api.js";

// 🔹 Load resumes on page load
window.onload = async function () {
    loadResumes();
};

async function loadResumes() {
    let table = document.getElementById("resumeTable");

    table.innerHTML = "<tr><th>ID</th><th>File</th><th>Skills</th><th>Action</th></tr>";

    let resumes = await getAllResumes();

    resumes.forEach(resume => {
        let row = `
            <tr>
                <td>${resume.id}</td>
                <td>${resume.fileName}</td>
                <td>${resume.skills}</td>
                <td>
                    <button onclick="deleteResumeById(${resume.id})">Delete</button>
                </td>
            </tr>
        `;

        table.innerHTML += row;
    });
}

// 🔹 Delete function
async function deleteResumeById(id) {
    if (!confirm("Are you sure?")) return;

    await deleteResume(id);

    alert("Deleted Successfully ✅");

    loadResumes(); // reload table
}

// 🔹 global access
window.deleteResumeById = deleteResumeById;