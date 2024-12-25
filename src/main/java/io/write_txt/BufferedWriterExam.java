package io.write_txt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BufferedWriterExam {

    private static final Logger LOGGER = Logger.getLogger(BufferedWriterExam.class.getName());

    public static void main(String[] args) {

        /*
         * Both FileWriter and BufferedWriter use buffering,
         * but FileWriter has a 1KB buffer, whereas BufferedWriter has an 8KB buffer,
         * making BufferedWriter faster in most cases.
         * A larger buffer doesn't always guarantee better performance,
         * but BufferedWriter's buffer size is optimally chosen for most tasks.
         * Buffers improve performance by collecting data and writing it in bulk,
         * reducing the number of disk access operations.
         */


        Path basePath = Paths.get("output/io"); // Base directory for the file
        Path filePath = basePath.resolve("hello.txt"); // Full path to the file

        String content = "Hello, BufferedWriter!";

        try {
            // Step 1: Create directories if needed
            Files.createDirectories(basePath);

            // Step 2: Write to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                writer.write(content);
            }
            LOGGER.info("File successfully written to: " + filePath);

        } catch (IOException e) {
            // Log any errors during directory creation or file writing
            LOGGER.log(Level.SEVERE, "An error occurred while writing the file", e);
        }
    }
}
