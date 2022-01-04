package com.linkedin.learning.springdesignpatterns.operational.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresidentRepository extends CrudRepository<President, Long> {
    
    President findByEmailAddress(String emailAddress);
}
