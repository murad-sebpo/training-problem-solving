package io.murad.Data_Structures_and_Java_Collections.PART_2;

import java.util.Hashtable;
import java.util.Map;

public class HashTableImpl {

    public static void main(String[] args) {

        Student student1 = new Student("John",1);
        Student student2 = new Student("David",2);
        Student student3 = new Student("Chris",3);
        Student student4 = new Student("Bill",4);
        Student student5 = new Student("Jeff",5);

        Hashtable<Integer,String> students = new Hashtable<>();

        students.put(student1.getRollNumber(),student1.getStudentName());
        students.put(student2.getRollNumber(),student2.getStudentName());
        students.put(student3.getRollNumber(),student3.getStudentName());
        students.put(student4.getRollNumber(),student4.getStudentName());
        students.put(student5.getRollNumber(),student5.getStudentName());

        for (Map.Entry<Integer,String> student : students.entrySet()){
            System.out.println("Roll Number: " + student.getKey() + " , " + "Student Name: " + student.getValue());
        }
    }
}
