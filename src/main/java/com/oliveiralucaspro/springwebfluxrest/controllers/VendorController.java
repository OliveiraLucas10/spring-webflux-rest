package com.oliveiralucaspro.springwebfluxrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiralucaspro.springwebfluxrest.domain.Vendor;
import com.oliveiralucaspro.springwebfluxrest.services.VendorService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(VendorController.BASE_URL)
@RequiredArgsConstructor
public class VendorController {

    static final String BASE_URL = "/api/v1/vendors";
    
    private final VendorService vendorService;
    
    @GetMapping
    public Flux<Vendor> getAll(){
	return vendorService.getAll();
    }
    
    @GetMapping("/{id}")
    public Mono<Vendor> getById(@PathVariable String id){
	return vendorService.getById(id);
	
    }
}
