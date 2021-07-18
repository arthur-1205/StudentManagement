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
public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private String address;
    private String gender;
    Campus campus;
    Course course;
    private String nameCampus;
    private String nameCourse;

    public Student(String id, String name, String address, String gender, Campus campus, Course course) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.campus = campus;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    
    public String getNameCampus(){
        if(this.campus == null)
            nameCampus = null;
        else 
            nameCampus = String.valueOf(this.campus.getName());
        return nameCampus;
    }
    
      public String getNameCourse(){
        if(this.course == null)
            nameCourse = null;
        else 
            nameCourse = String.valueOf(this.course.getName());
        return nameCourse;
    }
    
    
    public void showStudentInfo() {
        System.out.printf("|STUDENT   |ID: %6s|NAME: %15s|ADDRESS: %15s|GENDER: %7s|CAMPUS NAME: %10s|COURSE: %10s|\n",
          id.toUpperCase(), name.toUpperCase(), address.toUpperCase(), gender.toUpperCase(), getNameCampus(), getNameCourse());
    }

    @Override
    public int compareTo(Student o) {
        if(id.compareToIgnoreCase(o.getId()) == 1) return 1;
        else if(id.compareToIgnoreCase(o.getId()) == -1) return -1;
        return 0;
    }
    
            
}
