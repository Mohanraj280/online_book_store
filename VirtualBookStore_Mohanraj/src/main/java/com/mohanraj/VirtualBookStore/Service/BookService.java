package com.mohanraj.VirtualBookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohanraj.VirtualBookStore.Entity.Book;
import com.mohanraj.VirtualBookStore.Repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo brepo;
	
	public void save(Book b)
	{
		brepo.save(b);
	}
	
	public List<Book> getAllbook()
	{
		return brepo.findAll();
	}
	
	public Book getBookById(int id)
	{
		return brepo.findById(id).get();
	}
	
	public void deletebyid(int id)
	{
		brepo.deleteById(id);
	}
}
