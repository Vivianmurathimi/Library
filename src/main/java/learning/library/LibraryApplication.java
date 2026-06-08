package learning.library;

import learning.library.utils.JsonFileWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        JsonFileWriter.writeToFiles();
        SpringApplication.run(LibraryApplication.class, args);
    }
}