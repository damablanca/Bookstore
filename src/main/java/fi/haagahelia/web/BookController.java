package fi.haagahelia.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class BookController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String hello(Model model) {
		return "";
	}

}
