/*
* Note: The Files.readString method is similar to Files.readAllBytes in that it loads the entire file content into
* memory, but it directly returns a String. It is not suitable for reading large files as it may lead to memory issues.
*/

package io.read_txt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilesReadStringExam {

    private static final Logger LOGGER = Logger.getLogger(FilesReadStringExam.class.getName());
    private static final String RESOURCE_PATH = "io/input.txt";

    public static void main(String[] args) {
        // This condition is always false because RESOURCE_PATH is a final static constant with a non-null, non-empty value.
        if (RESOURCE_PATH == null || RESOURCE_PATH.isEmpty()) {
            LOGGER.log(Level.WARNING, "Resource path is invalid: {0}", RESOURCE_PATH);
            return;
        }

        URL fileURL = FilesReadStringExam.class.getClassLoader().getResource(RESOURCE_PATH);

        if (fileURL != null) {
            processFile(fileURL);
        } else {
            LOGGER.log(Level.WARNING, "Resource Not Found! ({0})", RESOURCE_PATH);
        }
    }

    private static void processFile(URL fileURL) {
        try {
            Path filePath = resolveFilePath(fileURL);

            String content = Files.readString(filePath);
            System.out.println(content);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "File reading failed: Ensure the file exists and is accessible. Details: {0}", e.getMessage());
        } catch (URISyntaxException e) {
            LOGGER.log(Level.SEVERE, "Invalid file path URI syntax. Please verify the resource path. Details: {0}", e.getMessage());
        }
    }

    private static Path resolveFilePath(URL fileURL) throws URISyntaxException {
        return Path.of(fileURL.toURI());
    }
}
