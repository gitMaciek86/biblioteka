package pl.sztukakodu.bookaro.catalog.application.port;

import pl.sztukakodu.bookaro.catalog.domain.Book;

import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findAll();

    Optional<Book> findByTitleAndAuthor(String title, String Author);

    void addBook();

    void removeById(Long id);

    void updateBook();
}
