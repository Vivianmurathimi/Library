package learning.library.utils;

import learning.library.domain.Author;
import learning.library.domain.Book;
import learning.library.domain.Review;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFileWriter {

    public static void writeToFiles() {
        try {
            // create objects
            Author author = new Author(1L, "J.K.", "Rowling", "British");
            Book book = new Book(1L, "Harry Potter", "Fantasy", 1997,
                    "INT-001", LocalDate.of(1997, 6, 26), author);
            Review r1 = new Review(1L, "Alice", "Loved it!", 5, null, book);
            Review r2 = new Review(2L, "Bob", "Pretty good", 4, "Re-read this", book);
            List<Review> reviews = List.of(r1, r2);

            // serialize using our own serializers
            String authorJson = new AuthorSerializer(author).toJson();
            String bookJson = new BookSerializer(book).toJson();

            // lambda replaces the for loop — cleaner and shorter
            String reviewsJson = reviews.stream()
                    .map(review -> new ReviewSerializer(review)
                            .toJson()
                            .replace("\n", "\n\t"))
                    .collect(Collectors.joining(",\n\t", "[\n\t", "\n]"));

            // write to files
            try (FileWriter fw = new FileWriter("author.json")) {
                fw.write(authorJson);
                System.out.println("author.json written!");
            }
            try (FileWriter fw = new FileWriter("book.json")) {
                fw.write(bookJson);
                System.out.println("book.json written!");
            }
            try (FileWriter fw = new FileWriter("reviews.json")) {
                fw.write(reviewsJson);
                System.out.println("reviews.json written!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}