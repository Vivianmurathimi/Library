package learning.library.controller;

import learning.library.domain.Author;
import learning.library.domain.Book;
import learning.library.domain.Review;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @GetMapping("/author")
    public Author getAuthor() {
        return new Author(1L, "J.K.", "Rowling", "British");
    }

    @GetMapping("/book")
    public Book getBook() {
        Author author = new Author(1L, "J.K.", "Rowling", "British");
        return new Book(1L, "Harry Potter", "Fantasy", 1997, "INT-001", author);
    }

    @GetMapping("/reviews")
    public List<Review> getReviews() {
        Author author = new Author(1L, "J.K.", "Rowling", "British");
        Book book = new Book(1L, "Harry Potter", "Fantasy", 1997, "INT-001", author);

        Review r1 = new Review(1L, "Alice", "Loved it!", 5, null, book);       // extraNotes is null — will be skipped
        Review r2 = new Review(2L, "Bob", "Pretty good", 4, "Re-read this", book);  // extraNotes has value — will show

        return List.of(r1, r2);
    }

    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author) {
        // @RequestBody tells Spring: take the incoming JSON and convert it to an Author object
        // for now we just return it back so we can see it worked
        System.out.println("Received author: " + author.getFirstName());
        return author;
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        System.out.println("Received book: " + book.getTitle());
        return book;
    }

    @PostMapping("/review")
    public Review createReview(@RequestBody Review review) {
        System.out.println("Received review from: " + review.getReviewerName());
        return review;
    }
}


