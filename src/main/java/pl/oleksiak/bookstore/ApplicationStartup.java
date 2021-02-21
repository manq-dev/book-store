package pl.oleksiak.bookstore;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.oleksiak.bookstore.catalog.application.port.CatalogUseCase;
import pl.oleksiak.bookstore.catalog.domain.Book;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationStartup implements CommandLineRunner {

    private final CatalogUseCase catalogService;
    @Value("${bookaro.catalog.query}") String title;
    @Value("${bookaro.catalog.limit:1}") Long limit;

    @Override
    public void run(String... args) {
        List<Book> books = catalogService.findByTitle(title);
        books.stream().limit(limit).forEach(System.out::println);
    }
}
