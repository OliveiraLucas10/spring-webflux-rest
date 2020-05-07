package com.oliveiralucaspro.springwebfluxrest.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.oliveiralucaspro.springwebfluxrest.domain.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{

}
