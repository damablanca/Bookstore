package fi.haagahelia;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.domain.User;
import fi.haagahelia.domain.UserRepository;

/*Making tests for UserRepository for search, create and delete methods*/

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;
	
	//search for a user
	@Test
	public void searchUser() throws Exception {
		User users = repository.findByUsername("Admin");
		assertThat(users.getRole()).isEqualTo("ADMIN");
	}
	
	//create new user
	@Test
	public void createNewUser() throws Exception {
		User user = new User("Isabel","$2a$04$besxf6YVX1/Tc0ANOd56huclk1jqWaaZTit88PVlx8LTVk6fZWJh2","USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
		assertThat(user.getPasswordHash()).isNotNull();
		assertThat(user.getRole()).isNotNull();
		assertThat(user.getUsername()).isNotNull();
	}
	
	//delete user
	@Test
	public void deleteUser() throws Exception {
		User users = repository.findByUsername("User");
		repository.delete(users);
		assertThat(users.getPasswordHash()).isEqualTo("$2a$06$UNA9n39XY/Zy6hk/bAOn1OJTABNnyMQJZvLJQV6LYeMnGu1xIom.C");
		assertThat(users.getRole()).isEqualTo("USER");
	}
	

}
