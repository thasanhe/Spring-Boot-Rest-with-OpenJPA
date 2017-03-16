package com.rpicloud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tharindu on 3/15/17.
 */
@Entity
public class Pie implements Serializable{
    private static final long serialVersionUID = 4929091802296699091L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private int age;

    public Pie(String name, String description, int age) {
        this.name = name;
        this.description = description;
        this.age = age;

    }


    //for JPA
    public Pie () {}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAge() {
        return age;
    }
}
