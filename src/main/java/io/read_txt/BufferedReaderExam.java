package io.read_txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BufferedReaderExam {

    private static final Logger LOGGER = Logger.getLogger(BufferedReaderExam.class.getName());

    public static void main(String[] args) {

        /*
         * InputStreamReader and FileReader read one character at a time.
         * BufferedReader also reads one character at a time but with a key difference:
         * BufferedReader reads multiple characters at once and stores them in a buffer.
         * When read() is called, it retrieves one character from the buffer rather than accessing the file directly.
         * This reduces the number of file accesses, making it more efficient.
         *
         * The buffer in BufferedReader is simply a character array held as a field:
         * - private char[] cb
         *
         * Small text files showed inconsistent speed differences,
         * but when tested with larger files, BufferedReader consistently outperformed FileReader.
         */

        URL fileURL = BufferedReaderExam.class.getClassLoader().getResource("io/input.txt");

        if (fileURL != null) {
            try {
                long startTime, endTime;

                // Using BufferedReader
                startTime = System.nanoTime();
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileURL.getFile()))) {
                    readFileContent(bufferedReader); // Read content without printing
                }
                endTime = System.nanoTime();
                System.out.println("BufferedReader time: " + String.format("%,d", (endTime - startTime)) + " ns");

                // Using FileReader only
                startTime = System.nanoTime();
                try (FileReader fileReader = new FileReader(fileURL.getFile())) {
                    readFileContent(fileReader); // Read content without printing
                }
                endTime = System.nanoTime();
                System.out.println("FileReader time: " + String.format("%,d", (endTime - startTime)) + " ns");

            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "An error occurred while reading the file", e);
            }

        } else {
            System.out.println("Resource Not Found!");
        }
    }

    private static void readFileContent(Reader reader) throws IOException {
        int ch;
        StringBuilder content = new StringBuilder();

        while ((ch = reader.read()) != -1) {
            content.append((char) ch);
        }
    }
}
