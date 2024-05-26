package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Parrot {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    //@PostConstruct, which instructs Spring to call that
    //method after the constructor finishes its execution
    @PostConstruct
    public void init(){
        this.name = "anon";
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }

}
