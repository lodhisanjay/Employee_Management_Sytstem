package com.RegCURD.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Emp_System")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String profile_pic;
    private String address;
    private String dob;
    private String email;
    private String phno;
    private int salary;
}
