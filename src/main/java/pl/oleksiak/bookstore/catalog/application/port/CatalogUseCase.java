package pl.oleksiak.bookstore.catalog.application.port;

import lombok.Builder;
import lombok.Value;
import pl.oleksiak.bookstore.catalog.domain.Book;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    List<Book> findByTitle(String title);

    List<Book> findAll();

    Optional<Book> findOneByTitleAndAuthor(String title, String author);

    void addBook(CreateBookCommand command);

    void removeById(Long id);

    UpdateBookResponse updateBook(UpdateBookCommand command);

    @Value
    @Builder
    class CreateBookCommand {
        String title;
        String author;
        Integer year;
    }

    @Value
    @Builder
    class UpdateBookCommand {
        Long id;
        String title;
        String author;
        Integer year;
    }

    @Value
    @Builder
    class UpdateBookResponse {
        public static UpdateBookResponse SUCCESS = UpdateBookResponse.builder().success(true).errors(Collections.emptyList()).build();

        boolean success;
        List<String> errors;
    }
}
