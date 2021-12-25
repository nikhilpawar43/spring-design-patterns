package com.linkedin.learning.springdesignpatterns.Structural.decorator;

import java.math.BigDecimal;

public abstract class Pizza {

    protected String description;

    public Pizza() {

    }

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal getCost();
}
