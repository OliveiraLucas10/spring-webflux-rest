package com.oliveiralucaspro.springwebfluxrest.services;

import org.reactivestreams.Publisher;

import com.oliveiralucaspro.springwebfluxrest.domain.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {

    Flux<Category> getAll();
    
    Mono<Category> getById(String id);
    
    Mono<Void> create(Publisher<Category> category);
    
    Mono<Category> update(String id, Category category);
    
}
