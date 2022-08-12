package pl.sztukakodu.bookaro.catalog.infrastrucure;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.sztukakodu.bookaro.catalog.domain.Book;
import pl.sztukakodu.bookaro.catalog.domain.CatalogRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository

class BestSellerCatalogRepository implements CatalogRepository {
    //concurent zeby bylo w srodowisku wspolbieznym
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();

    public BestSellerCatalogRepository() {
        storage.put(1L, new Book(1L, "P1", "AM1", 1834));
        storage.put(2L, new Book(2L, "P2", "AM2", 1844));
        storage.put(3L, new Book(3L, "P3", "AM3", 1854));
        storage.put(4L, new Book(4L, "P4", "AM4", 1864));

    }
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }
}
