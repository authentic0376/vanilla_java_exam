package io.read_txt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FilesReadAllBytesExam {

    private static final Logger LOGGER = Logger.getLogger(FilesReadAllBytesExam.class.getName());
    private static final String RESOURCE_PATH = "io/input.txt";

    public static void main(String[] args) {
        URL fileURL = FilesReadAllBytesExam.class.getClassLoader().getResource(RESOURCE_PATH);

        if (fileURL != null) {
            processFile(fileURL);
        } else {
            LOGGER.log(Level.WARNING, "Resource Not Found! ({0})", RESOURCE_PATH);
        }
    }

    private static void processFile(URL fileURL) {
        try {
            Path filePath = Path.of(fileURL.toURI());
            long fileSize = Files.size(filePath);

            if (fileSize < 1024 * 1024) {
                System.out.printf("File size: %.2f KB\n", fileSize / 1024.0);
            } else {
                System.out.printf("File size: %.2f MB\n", fileSize / (1024.0 * 1024.0));
            }

            if (fileSize > 10 * 1024 * 1024) { // Example limit: 10 MB
                LOGGER.log(Level.WARNING, "File is too large to load into memory. Size: {0} MB", fileSize / (1024 * 1024));
                // If the file is too large, print only the first 10 lines with an indication of omitted lines.
                try (Stream<String> lines = Files.lines(filePath)) {
                    lines.limit(10).forEach(System.out::println);
                    System.out.println("... (output truncated) ...");
                }
            } else {
                // Use readAllBytes only for small files to avoid OutOfMemoryError.
                byte[] bytes = Files.readAllBytes(filePath);
                String content = new String(bytes);
                System.out.println(content);
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while reading the file", e);
        } catch (URISyntaxException e) {
            LOGGER.log(Level.SEVERE, "URISyntax Error occurred!!", e);
        }
    }
}