package pl.sztukakodu.bookaro.catalog.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sztukakodu.bookaro.catalog.application.port.CatalogUseCase;
import pl.sztukakodu.bookaro.catalog.domain.Book;
import pl.sztukakodu.bookaro.catalog.domain.CatalogRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class CatalogService implements CatalogUseCase {

    private final CatalogRepository repository;

/*    public CatalogService(@Qualifier("bestSellerCatalogRepository") CatalogRepository repository) {
        this.repository = repository;
    }*/

    @Override
    public List<Book> findByTitle(String title) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAll(){
        return null;
    }
    @Override
    public Optional<Book> findByTitleAndAuthor(String title, String Author){
        return Optional.empty();
    }

    @Override
    public void addBook(){

    }

    @Override
    public void removeById(Long id){

    }

    @Override
    public void updateBook(){

    }
}
