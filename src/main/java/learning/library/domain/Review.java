package learning.library.domain;

public class Review {

    private Long id;
    private String reviewerName;
    private String comment;
    private int rating;
    private String extraNotes;
    private Book book;

    public Review() {}

    public Review(Long id, String reviewerName, String comment,
                  int rating, String extraNotes, Book book) {
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