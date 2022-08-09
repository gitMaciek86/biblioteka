package pl.sztukakodu.bookaro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BookaroOnlineStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookaroOnlineStoreApplication.class, args);
	}

	private final CatalogService catalogService;

	public BookaroOnlineStoreApplication(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	//CommandLineRunner to interface funkcyjny, ktorego metoda run odpali sie zaraz po postawieniu apki (zainicjalizowaniu kontenera)
	// np do ladowania danych do apki
	@Override
	public void run(String... args) throws Exception {
		List<Book> bookList = catalogService.findByTitle("Pan Tadeusz");
		bookList.forEach(System.out::println);
	}
}
