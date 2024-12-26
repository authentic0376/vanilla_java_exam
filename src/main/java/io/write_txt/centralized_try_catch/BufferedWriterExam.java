package io.write_txt.centralized_try_catch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;


public class BufferedWriterExam {

    public static void main(String[] args) {

        Path filePath = Paths.get("output/io/hello.txt");
        String content = "Hello, BufferedWriter!";
        FileUtils.writeToFile(filePath, () -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                writer.write(content);
            }
        });

    }
}
