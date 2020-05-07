package com.oliveiralucaspro.springwebfluxrest.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.oliveiralucaspro.springwebfluxrest.domain.Vendor;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {

}
