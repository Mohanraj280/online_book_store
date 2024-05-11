package com.mohanraj.VirtualBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohanraj.VirtualBookStore.Entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{

}
