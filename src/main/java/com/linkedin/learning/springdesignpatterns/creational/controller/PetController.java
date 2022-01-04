package com.linkedin.learning.springdesignpatterns.creational.controller;

import com.linkedin.learning.springdesignpatterns.creational.Builder.Contact;
import com.linkedin.learning.springdesignpatterns.creational.Builder.ContactBuilder;
import com.linkedin.learning.springdesignpatterns.creational.factory.Pet;
import com.linkedin.learning.springdesignpatterns.creational.factory.PetFactory;
import com.linkedin.learning.springdesignpatterns.operational.repository.President;
import com.linkedin.learning.springdesignpatterns.operational.repository.PresidentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class PetController {
    
    private PetFactory petFactory;
    
    private PresidentRepository presidentRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public PetController(PetFactory petFactory, PresidentRepository presidentRepository) {
        this.petFactory = petFactory;
        this.presidentRepository = presidentRepository;
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
    
    @GetMapping("/presidents/{id}")
    public President getPresidentById(@PathVariable Long id) {
        return this.presidentRepository.findById(id).get();
    }
    
    @GetMapping("/presidentContacts/{id}")
    public Contact getPresidentContactById(@PathVariable Long id) {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("id", id);
        ResponseEntity<President> responseEntity = restTemplate.getForEntity("http://localhost:8082/presidents/{id}", President.class, requestParams);
        President retrievedPresident = responseEntity.getBody();

        return new ContactBuilder()
                    .setFirstName(retrievedPresident.getFirstName())
                    .setLastName(retrievedPresident.getLastName())
                    .setEmailAddress(retrievedPresident.getEmailAddress())
                    .build();
        
    }
}
