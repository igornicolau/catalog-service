package com.bookshop.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.catalogservice.config.CatalogProperties;

@RestController
public class HomeController {

	private final CatalogProperties properties;

	public HomeController(CatalogProperties properties) {
		this.properties = properties;
	}

	@GetMapping("/")
	public String getGreeting() {
		return this.properties.getGreeting();
	}

}
