package com.bookshop.catalogservice.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bookshop.catalogservice.domain.BookNotFoundException;
import com.bookshop.catalogservice.domain.BookService;

@WebMvcTest(BookController.class)
public class BookControllerMvcTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@Test
	void whenGetBookNotExistingThenShouldReturn404() throws Exception {
		String isbn = "73737313940";
		BDDMockito.given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);
		mockMvc.perform(get("/books/" + isbn)).andExpect(status().isNotFound());
	}
}
