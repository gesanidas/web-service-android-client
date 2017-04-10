package com.example.gesanidas.company;


import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable
{
    int id,phone;
    String name,email,password,title;
    List<Skill> skills;



    public Employee(int id,  String name, String email, String password, int phone,String title)
    {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.password = password;
        this.title = title;
    }

    public Employee(String name, String email, String password,int phone,  String title)
    {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.password = password;
        this.title = title;
    }

    public Employee(int id, String name, String email, String password, int phone, String title, List<Skill> skills) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.password = password;
        this.title = title;
        this.skills = skills;
    }


    public Employee( String name, String email, String password,int phone, String title, List<Skill> skills) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.password = password;
        this.title = title;
        this.skills = skills;
    }


    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
