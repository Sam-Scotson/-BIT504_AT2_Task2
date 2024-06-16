package com.example.studentdata;
public class Student {
    public int id;
    public String firstName;
    public String lastName;
    public AssignmentMarks mathMarks;
    public AssignmentMarks englishMarks;
    // Constructor to create student object with passed ID, first name, etc
    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mathMarks = null;
        this.englishMarks = null;
    }
    // Method to get the full name of the student
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}