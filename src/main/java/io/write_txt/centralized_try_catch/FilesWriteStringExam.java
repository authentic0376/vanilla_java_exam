package io.write_txt.centralized_try_catch;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesWriteStringExam {
    public static void main(String[] args) {
        Path filePath = Paths.get("output/io/hello.txt");
        String content = "Hello, Files.writeString!";
        FileUtils.writeToFile(filePath, () -> Files.writeString(filePath, content));
    }
}
