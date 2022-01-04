package com.linkedin.learning.springdesignpatterns.Structural.decorator;

import java.math.BigDecimal;

public class ThickCrustPizza extends Pizza {

    public ThickCrustPizza() {
        super();
        this.description = "Thick crust pizza";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15.00);
    }
}
