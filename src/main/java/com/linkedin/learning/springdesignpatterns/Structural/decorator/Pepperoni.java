package com.linkedin.learning.springdesignpatterns.Structural.decorator;

import java.math.BigDecimal;

public class Pepperoni extends Pizza {

    private Pizza pizza;

    public Pepperoni(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " pepperoni";
    }

    @Override
    public BigDecimal getCost() {
        return (new BigDecimal(1.5)).add(pizza.getCost());
    }
}
