package learning.library.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)   // if any field is null, skip it in the JSON output
public class Review {

    private Long id;

    @JsonProperty("reviewer_name")
    private String reviewerName;

    private String comment;
    private int rating;

    private String extraNotes;   // this might sometimes be null — @JsonInclude will skip it if so

    private Book book;           // Many-to-One: this review belongs to one book

    public Review() {}

    public Review(Long id, String reviewerName, String comment, int rating, String extraNotes, Book book) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.comment = comment;
        this.rating = rating;
        this.extraNotes = extraNotes;
        this.book = book;
    }

    public Long getId() { return id; }
    public String getReviewerName() { return reviewerName; }
    public String getComment() { return comment; }
    public int getRating() { return rating; }
    public String getExtraNotes() { return extraNotes; }
    public Book getBook() { return book; }
}