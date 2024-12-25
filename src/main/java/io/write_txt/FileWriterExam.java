package io.write_txt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriterExam {

    private static final Logger LOGGER = Logger.getLogger(FileWriterExam.class.getName());

    public static void main(String[] args) {
        /*
         * Notes on FileWriter:
         * - The path provided to FileWriter is interpreted relative to the root folder.
         * - FileWriter will automatically create the file if it does not exist.
         * - However, the parent directory must already exist. If it does not exist, you need to create it first.
         *
         * Creating directories:
         * - Use Files.createDirectories to create directories. This method is preferred over mkdirs.
         * - Unlike mkdirs, which returns a boolean on failure, createDirectories throws an exception if directory creation fails.
         * - You do not need to check whether the directory already exists:
         *   - If the directory exists, it does nothing.
         *   - If the directory does not exist, it creates it.
         *   - If directory creation fails, an exception is thrown.
         */

        Path basePath = Paths.get("output/io"); // Base directory for the file
        Path filePath = basePath.resolve("hello.txt"); // Full path to the file

        String content = "Hello, FileWriter!";

        try {
            // Step 1: Create directories if needed
            Files.createDirectories(basePath);

            // Step 2: Write to the file
            try (FileWriter writer = new FileWriter(filePath.toFile())) {
                writer.write(content);
            }
            LOGGER.info("File successfully written to: " + filePath);

        } catch (IOException e) {
            // Log any errors during directory creation or file writing
            LOGGER.log(Level.SEVERE, "An error occurred while writing the file", e);
        }
    }
}
