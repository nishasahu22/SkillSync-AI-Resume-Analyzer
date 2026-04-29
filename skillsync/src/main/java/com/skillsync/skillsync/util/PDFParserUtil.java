package com.skillsync.skillsync.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class PDFParserUtil {

    // ✅ Extract text from PDF file
    public static String extractText(File file) {

        if (file == null || !file.exists()) {
            return "No file content";
        }

        try (PDDocument document = PDDocument.load(file)) {

            if (document.isEncrypted()) {
                return "Encrypted PDF - content not readable";
            }

            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error reading PDF";
        }
    }
}