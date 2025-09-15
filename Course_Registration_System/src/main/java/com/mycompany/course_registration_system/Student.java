// Student class, inherits from Person
package com.mycompany.course_registration_system;
public class Student extends Person {
    private Course[] courses;
    private int count;

    public Student(String id, String name) {
        super(id, name);
        courses = new Course[3]; // Small array
        count = 0;
    }

    // Override getInfo
    public String getInfo() {
        return "Student: " + name + " (ID: " + id + ")";
    }

    // Add course
    public void addCourse(Course course) {
        if (count < courses.length) {
            courses[count++] = course;
        }
    }

    // Get courses
    public String getCourses() {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += courses[i].getName() + "\n";
        }
        return result.isEmpty() ? "No courses" : result;
    }
}