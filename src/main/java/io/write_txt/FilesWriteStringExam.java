package io.write_txt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilesWriteStringExam {

    private static final Logger LOGGER = Logger.getLogger(FilesWriteStringExam.class.getName());

    public static void main(String[] args) {

        Path basePath = Paths.get("output/io"); // Base directory for the file
        Path filePath = basePath.resolve("hello.txt"); // Full path to the file

        String content = "Hello, Files.writeString!";
        try {
            // Step 1: Create directories if needed
            Files.createDirectories(basePath);

            // Step 2: Write to the file
            Files.writeString(filePath, content);
            LOGGER.info("File successfully written to: " + filePath);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while writing the file", e);
        }
    }
}
