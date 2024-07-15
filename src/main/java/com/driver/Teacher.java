package com.driver;

public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public Teacher() {

    }
    public Teacher(String name,int numberOfStudents,int age){
        this.age=age;
        this.name=name;
        this.numberOfStudents=numberOfStudents;

    }
    public String getName() {
        return name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getAge() {
        return age;
    }
}