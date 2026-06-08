package learning.library.utils;

import learning.library.domain.Author;

public class ManualJsonConverter {

    public static String authorToJson(Author author) {

        // We are building a JSON string manually character by character
        // StringBuilder is used to build strings efficiently in Java
        StringBuilder json = new StringBuilder();

        // Every JSON object starts with an opening curly brace
        json.append("{\n");

        // Each field follows this pattern:
        // "fieldName": value,
        // We add \n for new line and \t for tab (indentation)

        // id is a number so no quotes around the value
        json.append("\t\"id\": ");
        json.append(author.getId());
        json.append(",\n");

        // Strings need quotes around the value
        // Notice we use "first_name" not "firstName"
        // This is exactly what @JsonProperty("first_name") does automatically
        json.append("\t\"first_name\": ");
        json.append("\"").append(author.getFirstName()).append("\"");
        json.append(",\n");

        json.append("\t\"last_name\": ");
        json.append("\"").append(author.getLastName()).append("\"");
        json.append(",\n");

        // Last field has no comma at the end
        json.append("\t\"nationality\": ");
        json.append("\"").append(author.getNationality()).append("\"");
        json.append("\n");

        // Every JSON object ends with closing curly brace
        json.append("}");

        return json.toString();
    }
}
