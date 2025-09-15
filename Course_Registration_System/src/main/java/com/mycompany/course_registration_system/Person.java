package com.mycompany.course_registration_system;
// Abstract class for Student and Lecturer
public abstract class Person {
    protected String id;
    protected String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Abstract method to override
    public abstract String getInfo();

    public String getId() {
        return id;
    }
}