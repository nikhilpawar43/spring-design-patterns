package com.linkedin.learning.springdesignpatterns.adapter;

import com.linkedin.learning.springdesignpatterns.Structural.adapter.Apple;
import com.linkedin.learning.springdesignpatterns.Structural.adapter.AppleAdapter;
import com.linkedin.learning.springdesignpatterns.Structural.adapter.MoroOrange;
import com.linkedin.learning.springdesignpatterns.Structural.adapter.Orange;

import org.junit.jupiter.api.Test;

public class AdapterTest {
    
    @Test
    public void testAdapter() {
        Orange orange = new MoroOrange();
        Apple apple = new AppleAdapter(orange);
        System.out.println(apple.getVariety());
        apple.eat();
    }
}
