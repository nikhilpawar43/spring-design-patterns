package com.linkedin.learning.springdesignpatterns.creational.controller;

import com.linkedin.learning.springdesignpatterns.creational.Builder.Contact;
import com.linkedin.learning.springdesignpatterns.creational.Builder.ContactBuilder;
import com.linkedin.learning.springdesignpatterns.creational.factory.Pet;
import com.linkedin.learning.springdesignpatterns.creational.factory.PetFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    
    @GetMapping("/presidents")
    public List<Contact> getPresidents() {
        
        List<Contact> contacts = new ArrayList<>();
        
        Contact contact = new Contact();
        contact.setFirstName("George");
        contact.setLastName("Washington");
        
        contacts.add(contact);
        
        contacts.add(new Contact("Barack", "Obama", null));
        
        contacts.add(new ContactBuilder().setFirstName("Joeseph").setLastName("Biden").build());
        
        return contacts;
    }
}
