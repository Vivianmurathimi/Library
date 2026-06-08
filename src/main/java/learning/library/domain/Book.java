package learning.library.domain;

import java.time.LocalDate;

public class Book {

    private Long id;
    private String title;
    private String genre;
    private int publishedYear;
    private String internalCode;
    private LocalDate publishedDate;
    private Author author;

    public Book() {}

    public Book(Long id, String title, String genre, int publishedYear,
                String internalCode, LocalDate publishedDate, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publishedYear = publishedYear;
        this.internalCode = internalCode;
        this.publishedDate = publishedDate;
        this.author = author;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getPublishedYear() { return publishedYear; }
    public String getInternalCode() { return internalCode; }
    public LocalDate getPublishedDate() { return publishedDate; }
    public Author getAuthor() { return author; }
}