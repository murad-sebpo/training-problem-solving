package io.murad.Data_Structures_and_Java_Collections.PART_2;

public class Student {

    private String studentName;
    private Integer rollNumber;

    public Student(String name,Integer roll){
        this.studentName = name;
        this.rollNumber = roll;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }
}
