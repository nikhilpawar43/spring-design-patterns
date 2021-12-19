package com.linkedin.learning.springdesignpatterns.creational.factory.controller;

import com.linkedin.learning.springdesignpatterns.creational.factory.factory.Pet;
import com.linkedin.learning.springdesignpatterns.creational.factory.factory.PetFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PetController {
    
    private PetFactory petFactory;

    @Autowired
    public PetController(PetFactory petFactory) {
        this.petFactory = petFactory;
    }

    @GetMapping
    public String getDefault() {
        return "{\"message\": \"Hello World\"}";
    }
    
    @PostMapping("/adoptPet/{type}/{name}")
    public Pet adoptPet(@PathVariable("type") String type, @PathVariable("name") String name) {
        Pet pet = petFactory.createPet(type);
        pet.setName(name);
        pet.feed();
        return pet;
    }
}
