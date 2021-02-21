package pl.oleksiak.bookstore.catalog.application;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.oleksiak.bookstore.catalog.application.port.CatalogUseCase;
import pl.oleksiak.bookstore.catalog.domain.Book;
import pl.oleksiak.bookstore.catalog.domain.CatalogRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class CatalogService implements CatalogUseCase {

    private final CatalogRepository repository;

    @Override
    public List<Book> findByTitle(String title) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findOneByTitleAndAuthor(String title, String author) {
        return Optional.empty();
    }

    @Override
    public void addBook(CreateCommandBook command) {
        final Book build = Book.builder().title(command.getTitle()).author(command.getAuthor()).year(command.getYear()).build();
        repository.save(build);
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void updateBook() {

    }
}