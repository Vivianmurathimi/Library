package learning.library.utils;

import learning.library.domain.Review;

public class ReviewSerializer implements JsonSerializable {

    private final Review review;

    public ReviewSerializer(Review review) {
        this.review = review;
    }

    @Override
    public String toJson() {

        // Reuse BookSerializer for the nested book object
        String bookJson = new BookSerializer(review.getBook())
                .toJson()
                .replace("\n", "\n\t");

        // Build the JSON — but extraNotes might be null
        // so we handle it carefully — this is what @JsonInclude(NON_NULL) did
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("\t\"id\": ").append(review.getId()).append(",\n");
        json.append("\t\"reviewer_name\": \"").append(review.getReviewerName()).append("\",\n");
        json.append("\t\"comment\": \"").append(review.getComment()).append("\",\n");
        json.append("\t\"rating\": ").append(review.getRating()).append(",\n");

        // Only include extraNotes if it is NOT null
        // This is exactly what @JsonInclude(NON_NULL) did automatically
        if (review.getExtraNotes() != null) {
            json.append("\t\"extra_notes\": \"").append(review.getExtraNotes()).append("\",\n");
        }

        json.append("\t\"book\": ").append(bookJson).append("\n");
        json.append("}");

        return json.toString();
    }
}