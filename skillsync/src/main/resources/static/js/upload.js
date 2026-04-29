window.onload = function () {

    console.log("Page Loaded");

    document.getElementById("uploadBtn").onclick = function () {

        console.log("Button Clicked");

        let fileInput = document.getElementById("file");

        if (fileInput.files.length === 0) {
            alert("Select file first");
            return;
        }

        let formData = new FormData();
        formData.append("file", fileInput.files[0]);

        fetch("http://localhost:8081/api/resume/upload", {
            method: "POST",
            body: formData
        })
        .then(res => {
            console.log("Status:", res.status);
            return res.text();
        })
        .then(data => {
            console.log("Response:", data);
            document.getElementById("msg").innerText = "Upload done";
        })
        .catch(err => {
            console.error("Error:", err);
        });
    };
};