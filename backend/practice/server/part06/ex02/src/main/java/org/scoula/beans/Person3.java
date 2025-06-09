package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person3 {
    private String name = "Ella";
    private final Parrot2 parrot;

    @Autowired
    public Person3(Parrot2 parrot) {
        this.parrot = parrot;
    }
}
