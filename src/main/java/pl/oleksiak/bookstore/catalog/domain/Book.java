package pl.oleksiak.bookstore.catalog.domain;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Book {

    private Long id;
    private String title;
    private String author;
    private Integer year;
}
