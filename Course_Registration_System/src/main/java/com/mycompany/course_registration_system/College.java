// College class to manage students, lecturers, courses
package com.mycompany.course_registration_system;

public class College {
    private Course[] courses;
    private Student[] students;
    private Lecturer[] lecturers;
    private int courseCount;
    private int studentCount;
    private int lecturerCount;

    public College() {
        courses = new Course[3]; // Small array
        students = new Student[3];
        lecturers = new Lecturer[3];
        courseCount = 0;
        studentCount = 0;
        lecturerCount = 0;
    }

    // Add course
    public void addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
        }
    }

    // Add student
    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        }
    }

    // Add lecturer
    public void addLecturer(Lecturer lecturer) {
        if (lecturerCount < lecturers.length) {
            lecturers[lecturerCount++] = lecturer;
        }
    }

    // Register course for student
    public void registerCourseForStudent(String id, String code) {
        Student student = findStudent(id);
        Course course = findCourse(code);
        if (student != null && course != null) {
            student.addCourse(course);
        }
    }

    // Register course for lecturer
    public void registerCourseForLecturer(String id, String code) {
        Lecturer lecturer = findLecturer(id);
        Course course = findCourse(code);
        if (lecturer != null && course != null) {
            lecturer.addCourse(course);
        }
    }

    // Find student
    private Student findStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    // Find lecturer
    private Lecturer findLecturer(String id) {
        for (int i = 0; i < lecturerCount; i++) {
            if (lecturers[i].getId().equals(id)) {
                return lecturers[i];
            }
        }
        return null;
    }

    // Find course
    private Course findCourse(String code) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCode().equals(code)) {
                return courses[i];
            }
        }
        return null;
    }

    // Get college info
    public String getCollegeInfo() {
        return "Students: " + studentCount + ", Lecturers: " + lecturerCount + ", Courses: " + courseCount;
    }

    // Get all courses
    public String getAllCourses() {
        String result = "";
        for (int i = 0; i < courseCount; i++) {
            result += courses[i].getCode() + ": " + courses[i].getName() + "\n";
        }
        return result.isEmpty() ? "No courses" : result;
    }

    // Get all students
    public String getAllStudents() {
        String result = "";
        for (int i = 0; i < studentCount; i++) {
            result += students[i].getInfo() + "\n";
        }
        return result.isEmpty() ? "No students" : result;
    }

    // Get all lecturers
    public String getAllLecturers() {
        String result = "";
        for (int i = 0; i < lecturerCount; i++) {
            result += lecturers[i].getInfo() + "\n";
        }
        return result.isEmpty() ? "No lecturers" : result;
    }

    // Get student courses
    public String getStudentCourses(String id) {
        Student student = findStudent(id);
        return student != null ? student.getCourses() : "Student not found";
    }

    // Get lecturer courses
    public String getLecturerCourses(String id) {
        Lecturer lecturer = findLecturer(id);
        return lecturer != null ? lecturer.getCourses() : "Lecturer not found";
    }
}