package com.mohanraj.VirtualBookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mohanraj.VirtualBookStore.Entity.Book;
import com.mohanraj.VirtualBookStore.Entity.MyBookList;
import com.mohanraj.VirtualBookStore.Service.BookService;
import com.mohanraj.VirtualBookStore.Service.MyBookService;
							


@Controller
public class HomeController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService mybookservice;
	
	@GetMapping("/")
	public String Home()
	{
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView AvailableBooks() 
	{
		List<Book> lst = service.getAllbook();
		return new ModelAndView("availableBooks","book",lst);
	}
	
	@GetMapping("/my_books")
	public String MyBooks(Model model)
	{
		List<MyBookList> lst=mybookservice.getAllMyBooks();
		model.addAttribute("book",lst);
		return "myBooks";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		service.save(b);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMylist(@PathVariable("id") int id)
	{

		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mybookservice.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model)
	{
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "BookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBookt(@PathVariable("id") int id)
	{
		
		service.deletebyid(id);
		return "redirect:/available_books";
	}
}
