package io.write_txt.centralized_try_catch;

import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterExam {

    public static void main(String[] args) {

        Path filePath = Paths.get("output/io/hello.txt");
        String content = "Hello, FileWriter!";
        FileUtils.writeToFile(filePath, () -> {
            try (FileWriter writer = new FileWriter(filePath.toFile())) {
                writer.write(content);
            }
        });
    }
}
