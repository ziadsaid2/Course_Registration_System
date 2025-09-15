package com.mycompany.course_registration_system;

import javax.swing.*;

import java.awt.*;

// Main class with simple GUI
public class Course_Registration_System {

    public static void main(String[] args) {
        College college = new College();
        JFrame frame = new JFrame("Course System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new GridLayout(12, 1, 2, 2));

        // Menu options
        String[] options = {"Add Course", "Add Student", "Add Lecturer", "Reg. Student Course",
            "Reg. Lecturer Course", "Show Info", "Show Courses", "Show Students",
            "Show Lecturers", "Student Courses", "Lecturer Courses", "Quit"};

        // Create buttons
        JButton[] buttons = new JButton[12];
        for (int i = 0; i < 12; i++) {
            buttons[i] = new JButton(options[i]);
            frame.add(buttons[i]);
        }

        // Button actions
        buttons[0].addActionListener(e -> handleInput(frame, college, 0));
        buttons[1].addActionListener(e -> handleInput(frame, college, 1));
        buttons[2].addActionListener(e -> handleInput(frame, college, 2));
        buttons[3].addActionListener(e -> handleInput(frame, college, 3));
        buttons[4].addActionListener(e -> handleInput(frame, college, 4));
        buttons[5].addActionListener(e -> JOptionPane.showMessageDialog(frame, college.getCollegeInfo()));
        buttons[6].addActionListener(e -> JOptionPane.showMessageDialog(frame, college.getAllCourses()));
        buttons[7].addActionListener(e -> JOptionPane.showMessageDialog(frame, college.getAllStudents()));
        buttons[8].addActionListener(e -> JOptionPane.showMessageDialog(frame, college.getAllLecturers()));
        buttons[9].addActionListener(e -> handleInput(frame, college, 9));
        buttons[10].addActionListener(e -> handleInput(frame, college, 10));
        buttons[11].addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    // Handle input for buttons
    private static void handleInput(JFrame frame, College college, int option) {
        String input1 = JOptionPane.showInputDialog(frame, getInputPrompt(option, 1));
        if (input1 != null && !input1.isEmpty()) {
            if (option < 5) {
                String input2 = JOptionPane.showInputDialog(frame, getInputPrompt(option, 2));
                if (input2 != null && !input2.isEmpty()) {
                    switch (option) {
                        case 0:
                            college.addCourse(new Course(input1, input2));
                            break;
                        case 1:
                            college.addStudent(new Student(input1, input2));
                            break;
                        case 2:
                            college.addLecturer(new Lecturer(input1, input2));
                            break;
                        case 3:
                            college.registerCourseForStudent(input1, input2);
                            break;
                        case 4:
                            college.registerCourseForLecturer(input1, input2);
                            break;
                    }
                    JOptionPane.showMessageDialog(frame, getSuccessMessage(option));
                }
            } else {
                String result = option == 9 ? college.getStudentCourses(input1) : college.getLecturerCourses(input1);
                JOptionPane.showMessageDialog(frame, result);
            }
        }
    }

    // Get input prompt
    private static String getInputPrompt(int option, int inputNum) {
        if (option == 0) {
            return inputNum == 1 ? "Course code:" : "Course name:";
        }
        if (option == 1 || option == 3) {
            return inputNum == 1 ? "Student ID:" : (option == 1 ? "Student name:" : "Course code:");
        }
        if (option == 2 || option == 4) {
            return inputNum == 1 ? "Lecturer ID:" : (option == 2 ? "Lecturer name:" : "Course code:");
        }
        return option == 9 ? "Student ID:" : "Lecturer ID:";
    }

    // Get success message
    private static String getSuccessMessage(int option) {
        switch (option) {
            case 0:
                return "Course added.";
            case 1:
                return "Student added.";
            case 2:
                return "Lecturer added.";
            case 3:
                return "Course registered for student.";
            case 4:
                return "Course registered for lecturer.";
            default:
                return "Done.";
        }
    }
}
