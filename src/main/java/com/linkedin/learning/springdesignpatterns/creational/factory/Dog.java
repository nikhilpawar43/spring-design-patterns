package com.linkedin.learning.springdesignpatterns.creational.factory;

public class Dog implements Pet {
    
    private String name;
    private boolean isHungry;
    private static final String TYPE = "Dog";
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public void feed() {
        isHungry = false;
    }

    @Override
    public boolean isHungry() {
        return isHungry;
    }
}
