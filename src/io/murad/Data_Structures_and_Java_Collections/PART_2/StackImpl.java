package io.murad.Data_Structures_and_Java_Collections.PART_2;

import java.util.Stack;

public class StackImpl {

    public static void main(String[] args) {
        Stack<String> courses = new Stack<>();

        courses.add("Physics");
        courses.add("Chemistry");
        courses.add("Biology");
        courses.add("Mathematics");
        courses.add("English");

        courses.forEach(course ->{
            System.out.println(course);
        });

        courses.pop();
        // Course After Pop
        courses.forEach(course->{
            System.out.println(course);
        });

        System.out.println("Top Element : " + courses.peek());


    }
}
