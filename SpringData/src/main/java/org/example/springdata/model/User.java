package org.example.springdata.model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

//best practice to specify the table name
@Entity(name="users")
@Table(name="users")
public class User {

    //tell spring that this is the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //specify if field name and table column are not same
    @Column(name="id", nullable = false)
    private long id;

    private String name;
    private int age;

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
