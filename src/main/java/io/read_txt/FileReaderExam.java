package io.read_txt;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaderExam {

    private static final Logger LOGGER = Logger.getLogger(FileReaderExam.class.getName());

    public static void main(String[] args) {

        /*
         * FileReader extends InputStreamReader.
         * InputStreamReader requires an InputStream when being created.
         * FileReader does nothing special; it simply converts a File into an InputStream
         * and uses it to create an InputStreamReader.
         * FileReader reads one character at a time and returns data as an int.
         */

        /*
         * getResource can return null.
         * Unlike the File class, which can create an object for a non-existent file,
         * getResource does not return a URL for a non-existent resource.
         */
        URL fileURL = FileReaderExam.class.getClassLoader().getResource("io/input.txt");

        if (fileURL != null) {
            try (FileReader reader = new FileReader(fileURL.getFile())) {

                int ch;
                StringBuilder content = new StringBuilder();

                // Read the file character by character
                while ((ch = reader.read()) != -1) {
                    content.append((char) ch);
                }

                System.out.println(content);

            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "An error occurred while writing the file", e);
            }

        } else {
            System.out.println("Resource Not Found!");
        }
    }
}
