package fi.haagahelia.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.domain.Book;

import org.springframework.ui.Model;

@Controller
public class BookController {
	
	private ArrayList<Book> books = new ArrayList<Book>();
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
		public String hello(Model model) {
			return "";
		}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
		public String showBooklist(Model model) {
		
			Book bookOne = new Book("Sinuhe egyptilainen (The Egyptian)", "Mika Waltari",1945,"WM345",20.60);
			Book bookTwo = new Book("The Unbearable Lightness of Being", "Milan Kundera",1985,"KM357",10);
			
			books.add(bookOne);
			books.add(bookTwo);
			
			model.addAttribute("book", books);
			
			return "booklist";
	}
}
