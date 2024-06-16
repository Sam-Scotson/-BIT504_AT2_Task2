package com.example.studentdata;
public class AssignmentMarks {
    String courseName;
    int assignment1;
    int assignment2;
    int assignment3;
    // Constructor creates assignmentmarks object with the course name and marks
    public AssignmentMarks(String courseName, int assignment1, int assignment2, int assignment3) {
        this.courseName = courseName;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
    }
    // Method to set the mark for an assignment
    public void setMark(int assignmentNumber, int mark) {
        if (assignmentNumber == 1) {
            this.assignment1 = mark;
        } else if (assignmentNumber == 2) {
            this.assignment2 = mark;
        } else if (assignmentNumber == 3) {
            this.assignment3 = mark;
        } else {
            System.out.println("Error! Please input 1, 2, or 3");
        }
    }
    // Method to get the mark for an assignment
    public int getMark(int assignmentNumber) {
        if (assignmentNumber == 1) {
            return this.assignment1;
        } else if (assignmentNumber == 2) {
            return this.assignment2;
        } else if (assignmentNumber == 3) {
            return this.assignment3;
        } else {
            System.out.println("Error! Please input 1, 2, or 3.");
            return -1;
        }
    }
    
    public int getAverageMark() {
        return (this.assignment1 + this.assignment2 + this.assignment3) / 3;
    }
    public String getGrade(int assignmentNumber) {
        int mark = getMark(assignmentNumber);
        return getGradeFromMark(mark);
    }
    public String getAverageGrade() {
        int averageMark = getAverageMark();
        return getGradeFromMark(averageMark);
    }
    // Converts the grades to marks
    private String getGradeFromMark(int mark) {
        if (mark >= 95) return "A+";
        if (mark >= 90) return "A";
        if (mark >= 85) return "A-";
        if (mark >= 80) return "B+";
        if (mark >= 75) return "B";
        if (mark >= 70) return "B-";
        if (mark >= 60) return "C+";
        if (mark >= 50) return "C";
        if (mark >= 41) return "C-";
        return "D";
    }
 // Method to get the grade for the 1st assignment
    public String getAssignment1Grade() {
        return getGradeFromMark(assignment1);
    }
 // Method to get the grade for the 2nd assignment
    public String getAssignment2Grade() {
        return getGradeFromMark(assignment2);
    }
 // Method to get the grade for the 3rd assignment
    public String getAssignment3Grade() {
        return getGradeFromMark(assignment3);
    }
 // Method to get the course name
    public String setCourseName(String name) {
        this.courseName = name;
        return this.courseName;
    }
    public String getCourseName() {
        return this.courseName;
    }
}