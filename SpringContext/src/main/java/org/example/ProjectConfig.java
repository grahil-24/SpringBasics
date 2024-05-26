package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//A Spring configuration class is characterized by the fact that it
// is annotated with the @Configuration annotation.
@Configuration
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {

    //You can declare as many instances of the same type as you wish by simply declaring
    //more methods annotated with the @Bean annotation
    @Bean
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    //When you have multiple beans of the same kind in the Spring context you can make
    //one of them primary. You mark the bean you want to be primary using the @Primary
    //annotation. A primary bean is the one Spring will choose if it has multiple options and
    //you don’t specify a name; the primary bean is simply Spring’s default choice.
    @Bean
    @Primary
    Parrot parrot(){
        var p = new Parrot();
        p.setName("rahil");
        return p;
    }

    @Bean
    @Primary
    //inject a specific bean of type Parrot with the help of qualifier annotation
    Person person(@Qualifier("parrot1") Parrot parrot){
        Person p = new Person("fdsf", parrot);
        p.setName("bruh");
        //Setting the reference of the parrot bean to the person’s
        // parrot attribute
        return p;
    }

    @Bean
    String hello() {
        return "hello!";
    }

    @Bean
    Integer num(){
        return 10;
    }

}
