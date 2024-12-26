package io.write_txt.centralized_try_catch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());

    /**
     * Ensures the parent directories of the given file path exist.
     */
    private static void ensureParentDirectories(Path filePath) {
        try {
            Files.createDirectories(filePath.getParent());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to create directories for: " + filePath, e);
            throw new RuntimeException("Directory creation failed", e); // Wrap in RuntimeException
        }
    }

    /**
     * Handles file operations with centralized exception handling.
     * The actual file operation logic is passed as a lambda expression.
     */
    public static void writeToFile(
            Path filePath, ThrowingRunnable fileOperation) {

        ensureParentDirectories(filePath);

        try {
            fileOperation.run(); // Perform the file operation
            LOGGER.info("File successfully written to: " + filePath);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred while writing to file: " + filePath, e);
            throw new RuntimeException("File writing failed", e); // Wrap in RuntimeException
        }
    }
}
