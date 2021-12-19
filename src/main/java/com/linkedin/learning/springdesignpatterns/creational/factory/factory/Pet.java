package com.linkedin.learning.springdesignpatterns.creational.factory.factory;

public interface Pet {
    
    void setName(String name);
    String getName();
    String getType();
    void feed();
    boolean isHungry();
}
