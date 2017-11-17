package com.rest.restcontrollerexample;

import com.rest.restcontrollerexample.domain.Book;
import com.rest.restcontrollerexample.domain.Store;
import com.rest.restcontrollerexample.domain.Writer;
import com.rest.restcontrollerexample.repository.BookRepository;
import com.rest.restcontrollerexample.repository.StoreRepository;
import com.rest.restcontrollerexample.repository.WriterRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class RestControllerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestControllerExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BookRepository bookRepository, WriterRepository writerRepository, StoreRepository storeRepository) throws Exception {
		return (args) -> {
			List<Book> allBooks = new ArrayList<>();

			Writer writer = writerRepository.save(Writer.builder()
					.name("havi")
					.age(30)
					.build());

			IntStream.rangeClosed(1, 10).forEach(index ->
					allBooks.add(bookRepository.save(Book.builder()
							.title("Spring Boot Book"+index)
							.publishedAt(LocalDateTime.now())
							.writer(writer).build()))
			);

			storeRepository.save(Store.builder()
					.name("Havi's Book Store")
					.location("Seoul")
					.bookList(allBooks)
					.build());
		};
	}
}
