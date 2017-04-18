package fi.haagahelia;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.domain.Category;
import fi.haagahelia.domain.CategoryRepository;

/*Making tests for CategoryRepository for search, create and delete methods*/

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repository;
	
	//search category
	@Test
	public void searchCategory() throws Exception {
		List<Category> categories = repository.findByName("Historical novel");
		assertThat(categories).hasSize(1);
	}
	
	//create category
	@Test
	public void createNewCategory() throws Exception {
		Category category = new Category("Drama");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	//delete category
	@Test
	public void deleteCategory() throws Exception {
		List<Category> categories = repository.findByName("Philosofical fiction");
		repository.delete(categories);
		assertThat(categories).hasSize(1);
	}
	

}
