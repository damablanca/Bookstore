package fi.haagahelia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.domain.Book;
import fi.haagahelia.domain.BookRepository;
import fi.haagahelia.domain.Category;
import fi.haagahelia.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Save some test data");
			
			crepository.save(new Category("Historical novel"));
			crepository.save(new Category("Philosofical fiction"));
			crepository.save(new Category("Horror novel"));
			
			repository.save(new Book("Sinuhe the Egyptian", "Mika Waltari",1945,"WM3445",20.60, crepository.findByName("Historical novel").get(0)));
			repository.save(new Book("The unbearable lightness of being", "Milan Kundera",1985,"KM3573",10, crepository.findByName("Philosofical fiction").get(0)));
			repository.save(new Book("The Picture of Dorian Gray", "Oscar Wilde",1890, "WO2899",15, crepository.findByName("Horror novel").get(0)));
			repository.save(new Book("Perfume", "Patrick Suskind", 1985, "SP4879", 14.50, crepository.findByName("Horror novel").get(0)));
			
			log.info("Fetch book information");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			} 
		};
	} 

}
