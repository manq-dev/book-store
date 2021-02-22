package pl.oleksiak.bookstore.catalog.application;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.oleksiak.bookstore.catalog.application.port.CatalogUseCase;
import pl.oleksiak.bookstore.catalog.domain.Book;
import pl.oleksiak.bookstore.catalog.domain.CatalogRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class CatalogService implements CatalogUseCase {

    private final CatalogRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findOneByTitleAndAuthor(String title, String author) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .filter(book -> book.getAuthor().startsWith(author))
                .findFirst();
    }

    @Override
    public void addBook(CreateBookCommand command) {
        final Book build = Book.builder().title(command.getTitle()).author(command.getAuthor()).year(command.getYear()).build();
        repository.save(build);
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public UpdateBookResponse updateBook(UpdateBookCommand command) {
        return repository.findById(command.getId())
            .map(book -> {
                book.setAuthor(command.getAuthor());
                book.setTitle(command.getTitle());
                book.setYear(command.getYear());
                repository.remove(command.getId());
                repository.save(book);
                return UpdateBookResponse.SUCCESS;
        })
        .orElseGet(() -> UpdateBookResponse.builder().success(false).errors(Collections.singletonList("Book not found with id: " + command.getId())).build());
    }
}