/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Y545
 */
public class Log {
    Student student;
    Course course;
    String codeCourse;
    String nameCourse;

    public Log(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public String getCode(){
        if(this.course == null)
            codeCourse = null;
        else 
            codeCourse = String.valueOf(this.course.getCode());
        return codeCourse;
    }
    
    public String getName(){
        if(this.course == null)
            nameCourse = null;
        else 
            nameCourse = String.valueOf(this.course.getName());
        return nameCourse;
    }
    
    public void showAll() {
        System.out.printf("|STUDENT ID: %10s|STUDENT NAME: %15s|COURSE CODE: %10s|COURSE NAME: %15s|\n",
                                student.getId(), student.getName(), getCode(), getName());
    }
    
}
