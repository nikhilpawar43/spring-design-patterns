package com.linkedin.learning.springdesignpatterns.decorator;

import com.linkedin.learning.springdesignpatterns.Structural.decorator.Pepperoni;
import com.linkedin.learning.springdesignpatterns.Structural.decorator.Pizza;
import com.linkedin.learning.springdesignpatterns.Structural.decorator.ThickCrustPizza;
import org.junit.jupiter.api.Test;

public class DecoratorTest {

    @Test
    public void testDecorator() {

        Pizza pizza = new ThickCrustPizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

        Pizza pepperoni = new Pepperoni(pizza);
        System.out.println(pepperoni.getDescription());
        System.out.println(pepperoni.getCost());

        Pizza doublePepperoni = new Pepperoni(pepperoni);
        System.out.println(doublePepperoni.getDescription());
        System.out.println(doublePepperoni.getCost());
    }
}
