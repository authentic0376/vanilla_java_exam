package io.write_txt;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintWriterExam {
    private static final Logger LOGGER = Logger.getLogger(PrintWriterExam.class.getName());

    public static void main(String[] args) {

        /*
         * print, println, and printf can be used.
         */

        Path basePath = Paths.get("output/io"); // Base directory for the file
        Path filePath = basePath.resolve("hello.txt"); // Full path to the file

        try {
            // Step 1: Create directories if needed
            Files.createDirectories(basePath);

            // Step 2: Write to the file
            try (PrintWriter writer = new PrintWriter(filePath.toFile())) {

                // --- write ---
                // Only characters or strings can be handled.
                // They are treated as characters, not numbers.
                writer.write(97);

                // --- print ---
                writer.print("Hello, ");
                writer.print("World!");

                // --- println ---
                writer.println("Hello, ");
                writer.println("World!");

                // --- printf ---
                String name = "Alice";
                int age = 25;
                double height = 170.5;

                writer.printf("Name: %s, Age: %d, Height: %.2f cm%n", name, age, height);
            }
            LOGGER.info("File successfully written to: " + filePath);

        } catch (IOException e) {
            // Log any errors during directory creation or file writing
            LOGGER.log(Level.SEVERE, "An error occurred while writing the file", e);
        }
    }
}
