package fi.haagahelia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.domain.Book;
import fi.haagahelia.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("Save some test data");
			
			repository.save(new Book("Sinuhe", "Mika Waltari",1945,"WM3445",20.60));
			repository.save(new Book("Olemisen sietamaton keveys", "Milan Kundera",1985,"KM3573",10));
			repository.save(new Book("Dorian Grayn Muotokuva", "Oscar Wilde",1890, "WO2899",15));
			
			log.info("Fetch book information");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			} 
		};
	} 

}
