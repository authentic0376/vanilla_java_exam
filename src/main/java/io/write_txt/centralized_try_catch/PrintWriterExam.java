package io.write_txt.centralized_try_catch;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintWriterExam {

    public static void main(String[] args) {
        Path filePath = Paths.get("output/io/hello.txt");
        FileUtils.writeToFile(filePath, () -> {
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
                }
        );
    }
}
