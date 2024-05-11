package com.mohanraj.VirtualBookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohanraj.VirtualBookStore.Entity.MyBookList;

@Repository
public interface MyBookRepo extends JpaRepository<MyBookList,Integer> {

}
