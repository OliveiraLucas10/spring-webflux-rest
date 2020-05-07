package com.oliveiralucaspro.springwebfluxrest.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivestreams.Publisher;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.oliveiralucaspro.springwebfluxrest.domain.Category;
import com.oliveiralucaspro.springwebfluxrest.services.CategoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class CategoryControllerTest {

    WebTestClient webTestClient;

    @Mock
    CategoryService categoryService;

    CategoryController controller;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	controller = new CategoryController(categoryService);
	webTestClient = WebTestClient.bindToController(controller).build();
    }

    @Test
    void testGetAll() {
	BDDMockito.given(categoryService.getAll()).willReturn(Flux.just(Category.builder().description("Cat1").build(),
		Category.builder().description("Cat2").build()));

	webTestClient.get().uri(CategoryController.BASE_URL).exchange().expectBodyList(Category.class).hasSize(2);
    }

    @Test
    void testGetById() {
	BDDMockito.given(categoryService.getById(anyString()))
		.willReturn(Mono.just(Category.builder().description("Category").build()));

	webTestClient.get().uri(CategoryController.BASE_URL + "/1").exchange().expectBody(Category.class);
    }

    @Test
    void testCreate() {
	BDDMockito.given(categoryService.create(any(Publisher.class))).willReturn(Mono.empty());

	Mono<Category> catToSave = Mono.just(Category.builder().description("DESCtest").build());

	webTestClient.post().uri(CategoryController.BASE_URL).body(catToSave, Category.class).exchange().expectStatus()
		.isCreated();
    }

    @Test
    void testUpdate() {
	BDDMockito.given(categoryService.update(anyString(), any(Category.class)))
		.willReturn(Mono.just(Category.builder().build()));
	
	
	Mono<Category> catToSave = Mono.just(Category.builder().description("DESCtest").build());
	
	webTestClient.put()
	.uri(CategoryController.BASE_URL + "/1")
	.body(catToSave, Category.class)
	.exchange()
	.expectStatus()
	.isOk();
    }

}
