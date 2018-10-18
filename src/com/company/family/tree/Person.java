package com.company.family.tree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDay;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }
}
