package fi.haagahelia;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.domain.Book;
import fi.haagahelia.domain.BookRepository;
import fi.haagahelia.domain.Category;

/*Making tests for search, create and delete methods for BookRepository*/

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	//search book
	@Test
	public void searchBookByTitle() throws Exception {
		List<Book> books = repository.findByTitle("Sinuhe the Egyptian");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Mika Waltari");
		
	}
	
	//create book
	@Test
	public void createNewBook() throws Exception {
		Book book = new Book ("Othello","William Shakespeare",1603,"SW29056",30.05,new Category("Drama"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	//delete book
	@Test
	public void deleteBook() throws Exception {
		List<Book> books = repository.findByTitle("Perfume");
		repository.delete(books);
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getIsbn()).isEqualTo("SP4879");
	}
	
}
