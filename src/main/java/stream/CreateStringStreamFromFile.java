package stream;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class CreateStringStreamFromFile {
    public static void main(String[] args) throws URISyntaxException, IOException {
        /*
         * Example of creating a stream from a txt file
         */

        URL url = Objects.requireNonNull(
                CreateStringStreamFromFile
                        .class
                        .getResource("/stream/string_stream_from_file.txt")
        );
        /*
         * Object.requireNonNull throws a NullPointerException if the file does not exist.
         * Without this, a null value would be passed along, potentially causing an Exception elsewhere,
         * making the issue harder to diagnose. Using requireNonNull makes it clear where the problem is.
         *
         * ".class" represents the class object, allowing runtime access to class information.
         * Depending on where the program is executed, the full path to the file in the resources directory
         * will vary in the file system.
         *
         * getResource takes a path relative to the classpath's resources directory
         * and converts it into a full URL.
         * From an object-oriented perspective, it finds the file in the resources folder.
         */

        URI uri = url.toURI();
        Path path = Paths.get(uri);

        System.out.println(url);
        System.out.println(url.toURI());
        /*
         * The type conversion is done because Paths.get takes URI instead of URL.
         * Printing both shows that they are essentially the same:
         * file:/C:/work/cc/vanilla_java_exam/out/production/resources/stream/string_stream_from_file.txt
         *
         * Paths.get works with filesystem directories, not the classpath.
         * You can provide a string representing a filesystem path relative to the project's root folder
         * or use a URI, as shown above.
         */

        // Using try-with-resources to safely close the Stream
        try (Stream<String> streamOfStringsFromFile = Files.lines(path)) {
            streamOfStringsFromFile.forEach(System.out::println);
            // Demonstrates that file input/output streams behave just like regular streams.
            // Files.lines(path, StandardCharsets.UTF_8) can be used to specify encoding.
        }

    }
}
