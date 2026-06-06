package learning.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    private Long id;
    private String title;
    private String genre;

    @JsonProperty("published_year")
    private int publishedYear;

    @JsonIgnore
    private String internalCode;

    private Author author;

    public Book() {}   // Jackson needs this to deserialize incoming JSON

    public Book(Long id, String title, String genre, int publishedYear, String internalCode, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publishedYear = publishedYear;
        this.internalCode = internalCode;
        this.author = author;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getPublishedYear() { return publishedYear; }
    public String getInternalCode() { return internalCode; }
    public Author getAuthor() { return author; }
}