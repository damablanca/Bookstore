package fi.haagahelia.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.domain.Book;
import fi.haagahelia.domain.BookRepository;


import org.springframework.ui.Model;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
		public String showBooklist(Model model) {
			model.addAttribute("book", repository.findAll());
			return "booklist";
	} 
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id")Long id, Model model) {
			repository.delete(id);
			return "redirect:../booklist";
	}
}
