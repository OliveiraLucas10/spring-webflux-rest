package com.oliveiralucaspro.springwebfluxrest.services;

import com.oliveiralucaspro.springwebfluxrest.domain.Vendor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VendorService {

    Flux<Vendor> getAll();
    
    Mono<Vendor> getById(String id);
}
