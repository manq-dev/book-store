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
        initData();
        finByTitle();
    }

    private void initData() {
        catalogService.addBook(CatalogUseCase.CreateCommandBook.builder().year(1990).title("Pan Tadeusz").author("Adam Mickiewicz").build());
        catalogService.addBook(CatalogUseCase.CreateCommandBook.builder().year(1990).title("Ogniem i Mieczem").author("Henryk Sienkiewicz").build());
        catalogService.addBook(CatalogUseCase.CreateCommandBook.builder().year(1990).title("Pan Wołodyjowski").author("Henryk Sienkiewicz").build());
        catalogService.addBook(CatalogUseCase.CreateCommandBook.builder().year(1990).title("Sezon Burz").author("Andrzej Sapkowski").build());

    }

    private void finByTitle() {
        List<Book> books = catalogService.findByTitle(title);
        books.stream().limit(limit).forEach(System.out::println);
    }
}
