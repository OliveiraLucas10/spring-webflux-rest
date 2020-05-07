package com.oliveiralucaspro.springwebfluxrest.controllers;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.oliveiralucaspro.springwebfluxrest.domain.Vendor;
import com.oliveiralucaspro.springwebfluxrest.services.VendorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class VendorControllerTest {

    WebTestClient webTestClient;

    @Mock
    VendorService vendorService;

    VendorController controller;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	controller = new VendorController(vendorService);

	webTestClient = WebTestClient.bindToController(controller).build();
    }

    @Test
    void testGetAll() {
	BDDMockito.given(vendorService.getAll())
		.willReturn(Flux.just(Vendor.builder().firstName("FirstName1").lastName("LastName1").build(),
			Vendor.builder().firstName("FirstName2").lastName("LastName2").build(),
			Vendor.builder().firstName("FirstName3").lastName("LastName3").build()));

	webTestClient.get().uri(VendorController.BASE_URL).exchange().expectBodyList(Vendor.class).hasSize(3);

    }

    @Test
    void testGetById() {
	BDDMockito.given(vendorService.getById(anyString()))
		.willReturn(Mono.just(Vendor.builder().firstName("MyName").build()));

	webTestClient.get().uri(VendorController.BASE_URL + "/1").exchange().expectBody(Vendor.class);

    }

}
