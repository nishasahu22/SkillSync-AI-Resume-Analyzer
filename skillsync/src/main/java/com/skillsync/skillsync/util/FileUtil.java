package com.skillsync.skillsync.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {

    // ✅ Save file to directory
    public static String saveFile(String uploadDir, MultipartFile file) throws IOException {

        // 🔹 Create directory if not exists
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 🔹 Generate unique file name (avoid overwrite)
        String originalFileName = file.getOriginalFilename();
        String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;

        // 🔹 Full path
        String filePath = uploadDir + File.separator + uniqueFileName;

        // 🔹 Save file
        File dest = new File(filePath);
        file.transferTo(dest);

        return filePath;
    }
}