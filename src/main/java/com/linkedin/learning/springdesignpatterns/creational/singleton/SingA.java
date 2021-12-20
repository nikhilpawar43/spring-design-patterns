package com.linkedin.learning.springdesignpatterns.creational.singleton;

import java.util.Objects;

public class SingA {
    
    private static SingA instance;

    private SingA() {
        
    }
    
    public static SingA getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (SingA.class) {
                if (Objects.isNull(instance)) {
                    instance = new SingA();
                }
            }
        }
        
        return instance;
    }
}
