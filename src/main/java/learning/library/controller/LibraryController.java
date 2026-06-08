package learning.library.controller;

import learning.library.domain.Author;
import learning.library.domain.Book;
import learning.library.domain.Review;
import learning.library.utils.AuthorSerializer;
import learning.library.utils.BookSerializer;
import learning.library.utils.ReviewSerializer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @GetMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor() {
        Author author = new Author(1L, "J.K.", "Rowling", "British");
        return new AuthorSerializer(author).toJson();
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBook() {
        Author author = new Author(1L, "J.K.", "Rowling", "British");
        Book book = new Book(1L, "Harry Potter", "Fantasy", 1997,
                "INT-001", LocalDate.of(1997, 6, 26), author);
        return new BookSerializer(book).toJson();
    }

    @GetMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getReviews() {
        Author author = new Author(1L, "J.K.", "Rowling", "British");
        Book book = new Book(1L, "Harry Potter", "Fantasy", 1997,
                "INT-001", LocalDate.of(1997, 6, 26), author);
        Review r1 = new Review(1L, "Alice", "Loved it!", 5, null, book);
        Review r2 = new Review(2L, "Bob", "Pretty good", 4, "Re-read this", book);
        List<Review> reviews = List.of(r1, r2);

        // lambda instead of for loop
        return reviews.stream()
                .map(review -> new ReviewSerializer(review)
                        .toJson()
                        .replace("\n", "\n\t"))
                .collect(Collectors.joining(",\n\t", "[\n\t", "\n]"));
    }

    @PostMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createAuthor(@RequestBody Author author) {
        System.out.println("Received author: " + author.getFirstName());
        return new AuthorSerializer(author).toJson();
    }

    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createBook(@RequestBody Book book) {
        System.out.println("Received book: " + book.getTitle());
        return new BookSerializer(book).toJson();
    }

    @PostMapping(value = "/review", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createReview(@RequestBody Review review) {
        System.out.println("Received review from: " + review.getReviewerName());
        return new ReviewSerializer(review).toJson();
    }
}