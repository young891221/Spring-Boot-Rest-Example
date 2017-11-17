package com.rest.restcontrollerexample.repository;


import com.rest.restcontrollerexample.domain.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitle(@Param("title") String title);

}
