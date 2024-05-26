package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;

    //Instruct Spring to provide a bean from its context and set it directly as
    //the value of the field, annotated with @Autowired. This way we establish
    //a relationship between the two bean
   //Autowiring a field is not recommended as we cant make the field final
//    @Autowired
//    private final Parrot parrot;

    private final Parrot parrot;


    public Person(String name,@Qualifier("parrot1") Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    //DI through setter. same problem as DI through field
//    @Autowired
//    public void setParrot(Parrot parrot) {
//        this.parrot = parrot;
//    }




    @Override
    public String toString() {
        return this.name + " owns " + this.parrot;
    }
}
