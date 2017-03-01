package fi.haagahelia.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.domain.Book;

import org.springframework.ui.Model;

@Controller
public class BookController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String hello(Model model) {
		return "";
	}
	
	/*@Bean
	public CommandLineRunner demo(Book book) {
		return (args) -> {
			//test code
		};
	}*/

}
