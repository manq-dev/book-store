package pl.oleksiak.bookstore.catalog.infrastructure;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.oleksiak.bookstore.catalog.domain.Book;
import pl.oleksiak.bookstore.catalog.domain.CatalogRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Primary
class MemoryCatalogRepository implements CatalogRepository {
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();

    public MemoryCatalogRepository() {
        storage.put(1L, new Book(1L, "Pan Tadeusz", "Adam Mickiewicz", 1990));
        storage.put(2L, new Book(2L, "Ogniem i Mieczem", "Henryk Sienkiewicz", 1990));
        storage.put(3L, new Book(3L, "Chłopi", "Władysław Reymont", 1990));
        storage.put(4L, new Book(4L, "Pan Wołodyjowski", "Henryk Sienkiewicz", 1990));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }

}
