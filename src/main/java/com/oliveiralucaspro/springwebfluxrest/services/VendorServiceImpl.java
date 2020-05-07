package com.oliveiralucaspro.springwebfluxrest.services;

import org.springframework.stereotype.Service;

import com.oliveiralucaspro.springwebfluxrest.domain.Vendor;
import com.oliveiralucaspro.springwebfluxrest.repositories.VendorRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    @Override
    public Flux<Vendor> getAll() {
	return vendorRepository.findAll();
    }

    @Override
    public Mono<Vendor> getById(String id) {
	return vendorRepository.findById(id);
    }

}
