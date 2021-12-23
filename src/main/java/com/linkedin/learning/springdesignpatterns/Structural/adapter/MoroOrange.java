package com.linkedin.learning.springdesignpatterns.Structural.adapter;

public class MoroOrange implements Orange {
    
    @Override
    public String getVariety() {
        return "Moro blood orange";
    }

    @Override
    public void peel() {
        System.out.println("Moro getting peeled");
    }

    @Override
    public void juice() {
        System.out.println("Moro getting juiced");
    }

    @Override
    public void eat() {
        System.out.println("Moro getting enjoyed");
    }
}
