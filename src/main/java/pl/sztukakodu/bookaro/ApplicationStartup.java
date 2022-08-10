package pl.sztukakodu.bookaro;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sztukakodu.bookaro.catalog.application.CatalogController;
import pl.sztukakodu.bookaro.catalog.domain.Book;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationStartup implements CommandLineRunner {
    private final CatalogController catalogController;

    //CommandLineRunner to interface funkcyjny, ktorego metoda run odpali sie zaraz po postawieniu apki (zainicjalizowaniu kontenera)
    // np do ladowania danych do apki
    @Override
    public void run(String... args) throws Exception {
        List<Book> bookList = catalogController.findByTitle("Pan");
        bookList.forEach(System.out::println);
    }
}
