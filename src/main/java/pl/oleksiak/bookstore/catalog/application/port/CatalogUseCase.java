package pl.oleksiak.bookstore.catalog.application.port;

import lombok.Builder;
import lombok.Value;
import pl.oleksiak.bookstore.catalog.domain.Book;

import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    List<Book> findByTitle(String title);

    List<Book> findAll();

    Optional<Book> findOneByTitleAndAuthor(String title, String author);

    void addBook(CreateCommandBook command);

    void removeById(Long id);

    void updateBook();

    @Value
    @Builder
    class CreateCommandBook {
        String title;
        String author;
        Integer year;
    }
}
