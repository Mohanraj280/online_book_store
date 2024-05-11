package com.mohanraj.VirtualBookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohanraj.VirtualBookStore.Entity.MyBookList;
import com.mohanraj.VirtualBookStore.Repository.MyBookRepo;

@Service
public class MyBookService {
	
	@Autowired
	private MyBookRepo mybook;
	


	public void saveMyBooks(MyBookList mb) {
		// TODO Auto-generated method stub
		mybook.save(mb);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deletebyId(int id)
	{
		mybook.deleteById(id);
	}
}
