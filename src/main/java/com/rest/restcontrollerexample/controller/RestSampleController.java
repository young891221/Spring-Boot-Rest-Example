package com.rest.restcontrollerexample.controller;

import com.rest.restcontrollerexample.domain.Book;
import com.rest.restcontrollerexample.repository.BookRepository;

import org.springframework.hateoas.Resources;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class RestSampleController {

    private final BookRepository bookRepository;

    public RestSampleController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "Hello Rest";
    }

    @GetMapping(path = "/api/v1/rest", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> rest() {
        return ResponseEntity
                .ok()
                .body("Rest API Test");
    }

    @GetMapping(path = "/api/v1/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getNormalJSON() {
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.noCache())
                .body(bookRepository.findAll());
    }

    @GetMapping(path = "/api/v2/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRestfulJSON() {
        List<Book> bookList = bookRepository.findAll();

        Resources<Book> resources = new Resources<>(bookList);
        resources.add(linkTo(methodOn(RestSampleController.class).getRestfulJSON()).withSelfRel());
        return ResponseEntity.ok(resources);
    }

}
