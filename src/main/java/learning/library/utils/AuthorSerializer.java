package learning.library.utils;

import learning.library.domain.Author;

// AuthorSerializer knows how to convert an Author to JSON
public class AuthorSerializer implements JsonSerializable {

    private final Author author;

    // We pass the Author object in through the constructor
    public AuthorSerializer(Author author) {
        this.author = author;
    }

    @Override
    public String toJson() {
        return "{\n" +
                "\t\"id\": " + author.getId() + ",\n" +
                "\t\"first_name\": \"" + author.getFirstName() + "\",\n" +
                "\t\"last_name\": \"" + author.getLastName() + "\",\n" +
                "\t\"nationality\": \"" + author.getNationality() + "\"\n" +
                "}";
    }
}