package learning.library.utils;

import learning.library.domain.Book;

public class BookSerializer implements JsonSerializable {

    private final Book book;

    public BookSerializer(Book book) {
        this.book = book;
    }

    @Override
    public String toJson() {


        String date = String.format("%02d/%02d/%d",
                book.getPublishedDate().getDayOfMonth(),
                book.getPublishedDate().getMonthValue(),
                book.getPublishedDate().getYear());

        String authorJson = new AuthorSerializer(book.getAuthor())
                .toJson()
                .replace("\n", "\n\t"); // indent nested object

        return "{\n" +
                "\t\"id\": " + book.getId() + ",\n" +
                "\t\"title\": \"" + book.getTitle() + "\",\n" +
                "\t\"genre\": \"" + book.getGenre() + "\",\n" +
                "\t\"published_year\": " + book.getPublishedYear() + ",\n" +
                "\t\"published_date\": \"" + date + "\",\n" +
                "\t\"author\": " + authorJson + "\n" +
                "}";
    }
}