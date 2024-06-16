package com.example.stringconcatenation;
public class StringConcatenation {

    public static void main(String[] args) {
        String s1 = "Java ", s2 = "Programming!";
        String s3 = s1.concat(s2);
        System.out.println(s3);
        System.out.println(s1 + s2);

        int lengthS3 = s3.length();
        System.out.println("String s3 is " + lengthS3 + " characters long.");
        System.out.println("Character at index 3 is " + s3.charAt(3));
        System.out.println("Character at index 6 is " + s3.charAt(6));
        System.out.println("Character at index 9 is " + s3.charAt(9));
        System.out.println("Character at index 15 is " + s3.charAt(15));
        System.out.println("String s3 in uppercase-> " + s3.toUpperCase());
        System.out.println("String s3 in lowercase-> " + s3.toLowerCase());
        System.out.println(s3);
    }
}

