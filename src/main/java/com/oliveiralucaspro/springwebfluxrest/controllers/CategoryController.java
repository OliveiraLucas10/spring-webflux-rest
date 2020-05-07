package com.oliveiralucaspro.springwebfluxrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiralucaspro.springwebfluxrest.domain.Category;
import com.oliveiralucaspro.springwebfluxrest.services.CategoryService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(CategoryController.BASE_URL)
@RequiredArgsConstructor
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories";

    private final CategoryService categoryService;

    @GetMapping
    public Flux<Category> getAll() {
	return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Category> getById(@PathVariable String id) {
	return categoryService.getById(id);
    }

}
