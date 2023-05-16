package com.crud.javashastra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.javashastra.entity.Cpart;
import com.crud.javashastra.service.BookService;

@Controller
public class Comparts {
	@Autowired
	BookService service;

	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("com_list", service.findallcpt());
		return "all-books";
	}

	@GetMapping("/add")
	public String lunchAddBookPage(Model model) {
		model.addAttribute("book", new Cpart());
		return "add-book";
	}

	@PostMapping("/addbook")
	public String createBook(Cpart book) {
		service.addBook(book);
		return "redirect:/";

	}

	@GetMapping("/edit/{id}")
	public String lunchEditPage(Model model, @PathVariable("id") int id) {
		model.addAttribute("book", service.findBookById(id));
		return "edit-book";

	}

	@PostMapping("/updatebook")
	public String upadteBook(Cpart book) {
		service.updateBook(book);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/test")
	public String test() {
		Cpart st = new Cpart();
		st.setId(1);
		st.setBrand("Rajanikanta");
		st.setType("Java");
		st.setQuantity(299);
		st.setFeatures("Ptradhan");
		service.addBook(st);
		return "index";

	}

}
