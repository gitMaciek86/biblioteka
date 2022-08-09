package pl.sztukakodu.bookaro;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CatalogService {
    //concurent zeby bylo w srodowisku wspolbieznym
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();

    public CatalogService() {
        storage.put(1L, new Book(1L, "Pan Tadeusz", "AM", 1834));
        storage.put(2L, new Book(2L, "Pan Tadeusz2", "AM2", 1835));
        storage.put(3L, new Book(3L, "Pan Tadeusz3", "AM3", 1836));
    }

    List<Book> findByTitle(String title) {
        return storage.values()
                .stream()
                .filter(book -> book.title.startsWith(title))
                .collect(Collectors.toList());
    }
}
