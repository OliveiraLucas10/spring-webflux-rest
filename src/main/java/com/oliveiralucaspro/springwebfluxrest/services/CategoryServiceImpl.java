package com.oliveiralucaspro.springwebfluxrest.services;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;

import com.oliveiralucaspro.springwebfluxrest.domain.Category;
import com.oliveiralucaspro.springwebfluxrest.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Flux<Category> getAll() {
	return categoryRepository.findAll();
    }

    @Override
    public Mono<Category> getById(String id) {
	return categoryRepository.findById(id);
    }

    @Override
    public Mono<Void> create(Publisher<Category> category) {
	return categoryRepository.saveAll(category).then();
    }

    @Override
    public Mono<Category> update(String id, Category category) {
	category.setId(id);
	return categoryRepository.save(category);
    }

}
