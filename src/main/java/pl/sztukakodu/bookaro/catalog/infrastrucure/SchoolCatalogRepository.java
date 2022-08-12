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
@Primary
class SchoolCatalogRepository implements CatalogRepository {
    //concurent zeby bylo w srodowisku wspolbieznym
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();

    public SchoolCatalogRepository() {
        storage.put(1L, new Book(1L, "Pan Tadeusz", "Adam Mickiewicz", 1834));
        storage.put(2L, new Book(2L, "Ogniem i mieczem", "Henryk Sienkiewicz", 1884));
        storage.put(3L, new Book(3L, "Chłopi", "Władysław Reymont", 1904));
        storage.put(4L, new Book(4L, "Pan Wołodyjowski", "Henryk Sienkiewicz", 1899));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }
}
