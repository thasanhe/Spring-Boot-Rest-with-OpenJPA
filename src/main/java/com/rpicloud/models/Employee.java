package com.rpicloud.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tharindu on 3/15/17.
 */
@Entity
public class Employee implements Serializable{
    private static final long serialVersionUID = 4929091802296699092L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 2000)
    private String name;

    @Column(length = 2)
    private String empType;

    @Column(length = 2000)
    private String address;

    public Employee(String name, String empType, String address) {
        this.name = name;
        this.address = address;
        this.empType = empType;

    }


    //for JPA
    public Employee() {}

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmpType() {
        return empType;
    }
}
