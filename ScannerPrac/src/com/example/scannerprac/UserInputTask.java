package com.example.scannerprac;
import java.util.Scanner;

public class UserInputTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter boolean value: ");
        boolean userBoolean = scanner.nextBoolean();
        
        System.out.println("Please enter your first name: ");
        String firstName = scanner.next();
        
        System.out.println("Please enter your last name: ");
        String lastName = scanner.next();
        
        System.out.println("Please enter an integer value: ");
        int userInt = scanner.nextInt();
        int userIntSquare = (int) Math.pow(userInt, 2);
        
        System.out.println("Please enter a long value: ");
        long userLong = scanner.nextLong();
        
        System.out.println("Please enter a float value: ");
        float userFloat = scanner.nextFloat();
        
        System.out.println("Please enter a double value: ");
        double userDouble = scanner.nextDouble();
        double userDoubleSquare = Math.pow(userDouble, 2);
        
        scanner.close();

        System.out.println("Boolean: " + userBoolean);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Integer: " + userInt);
        System.out.println("Square of Integer: " + userIntSquare);
        System.out.println("Long: " + userLong);
        System.out.println("Float: " + userFloat);
        System.out.println("Double: " + userDouble);
        System.out.println("Square of Double: " + userDoubleSquare);
    }
}
