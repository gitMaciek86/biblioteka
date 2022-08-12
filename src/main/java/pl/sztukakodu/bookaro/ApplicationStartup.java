package pl.sztukakodu.bookaro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sztukakodu.bookaro.catalog.application.port.CatalogUseCase;
import pl.sztukakodu.bookaro.catalog.domain.Book;

import java.util.List;

@Component
public class ApplicationStartup implements CommandLineRunner {
    private final CatalogUseCase catalogUseCase;
    private final String title;
    private final String author;
    private final Long limit;

    public ApplicationStartup(CatalogUseCase catalogUseCase,
                              @Value("${bookaro.catalog.query}") String title,
                              @Value("${bookaro.catalog.author}") String author,
                              //:1 default value
                              @Value("${bookaro.catalog.limit:1}") Long limit) {
        this.catalogUseCase = catalogUseCase;
        this.title = title;
        this.author = author;
        this.limit = limit;
    }

    //CommandLineRunner to interface funkcyjny, ktorego metoda run odpali sie zaraz po postawieniu apki (zainicjalizowaniu kontenera)
    // np do ladowania danych do apki
    @Override
    public void run(String... args) throws Exception {
        List<Book> bookList = catalogUseCase.findByTitle(title);
        bookList.stream().limit(limit).forEach(System.out::println);
        bookList = catalogUseCase.findByAuthor(author);
        bookList.stream().limit(limit).forEach(System.out::println);
    }
}
