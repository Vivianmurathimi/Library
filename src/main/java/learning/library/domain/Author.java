package learning.library.domain;

public class Author {

    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;

    public Author() {}

    public Author(Long id, String firstName, String lastName, String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getNationality() { return nationality; }
}