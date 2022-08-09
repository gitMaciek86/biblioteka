package pl.sztukakodu.bookaro;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CatalogService {
    //concurent zeby bylo w srodowisku wspolbieznym
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    List<Book> findByTitle(String title){
        storage.values()
                .stream()
                .filter(book->book.title.startsWith())
    }
}
