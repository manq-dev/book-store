package pl.oleksiak.bookstore.catalog.infrastructure;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.oleksiak.bookstore.catalog.domain.Book;
import pl.oleksiak.bookstore.catalog.domain.CatalogRepository;

import java.util.List;

@Repository
class BestsellerCatalogRepository implements CatalogRepository {

    @Override
    public List<Book> findAll() {
        return null;
    }
}
