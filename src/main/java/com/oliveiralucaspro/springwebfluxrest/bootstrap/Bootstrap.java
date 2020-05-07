package com.oliveiralucaspro.springwebfluxrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.oliveiralucaspro.springwebfluxrest.domain.Category;
import com.oliveiralucaspro.springwebfluxrest.domain.Vendor;
import com.oliveiralucaspro.springwebfluxrest.repositories.CategoryRepository;
import com.oliveiralucaspro.springwebfluxrest.repositories.VendorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    @Override
    public void run(String... args) throws Exception {
	loadCategory();
	loadVendor();
    }

    private void loadCategory() {
	if (categoryRepository.count().block() == 0) {
	    Category fruits = new Category();
	    fruits.setDescription("Fruits");

	    Category dried = new Category();
	    dried.setDescription("Dried");

	    Category fresh = new Category();
	    fresh.setDescription("Fresh");

	    Category exotic = new Category();
	    exotic.setDescription("Exotic");

	    Category nuts = new Category();
	    nuts.setDescription("Nuts");

	    categoryRepository.save(fruits).block();
	    categoryRepository.save(dried).block();
	    categoryRepository.save(fresh).block();
	    categoryRepository.save(exotic).block();
	    categoryRepository.save(nuts).block();
	}

	System.out.println("Category Loaded = " + categoryRepository.count().block());
    }

    private void loadVendor() {
	if (vendorRepository.count().block() == 0) {
	    Vendor pedro = new Vendor();
	    pedro.setFirstName("Pedro");
	    pedro.setLastName("Favela");

	    Vendor sergio = new Vendor();
	    sergio.setFirstName("Sergio");
	    sergio.setLastName("Mariola");

	    vendorRepository.save(pedro).block();
	    vendorRepository.save(sergio).block();
	}

	System.out.println("Vendor Loaded = " + vendorRepository.count().block());
    }

}
