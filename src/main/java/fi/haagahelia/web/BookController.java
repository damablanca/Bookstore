package fi.haagahelia.web;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.domain.Book;
import fi.haagahelia.domain.BookRepository;
import fi.haagahelia.domain.CategoryRepository;

import org.springframework.ui.Model;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired 
	private CategoryRepository crepository;
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
		return repository.findOne(bookId);
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
		public String showBooklist(Model model) {
			model.addAttribute("book", repository.findAll());
			return "booklist";
	} 
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
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
