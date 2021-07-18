/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import DTO.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.MyToys;

/**
 *
 * @author Y545
 */
public class StudentList {

    List<Student> list = new ArrayList<>();
    Student s;

    public void addStudent() {
        int pos;
        String id, name, address, gender;
        do {
            id = MyToys.getAString("Input Student id: ", "Student id is required");
            pos = findStudent(id);
            s = searchStudent(id);
            if (pos >= 0) {
                System.out.println("Student id already exist!! Please input again!");
            }
        } while (pos != -1);
        name = MyToys.getAString("Input Student name: ", "Student name is required!!");
        address = MyToys.getAString("Input Student adress: ", "Student address is required!!");
        gender = MyToys.getMaleOrFemale("Input Student gender(male or female):", "Please input male or female!");

        list.add(new Student(id, name, address, gender, null, null));
        System.out.println("=>>> Add Student successfully!! <<<=");
    }

    public void updateStudent() {
        int pos;
        String id;
        if (list.isEmpty()) {
            System.out.println("Student List is empty!!");
            return;
        }
        do {
            id = MyToys.getAString("Input Student ID to update: ", "Student id is required!");
            pos = findStudent(id);
            s = searchStudent(id);
            if (pos == -1) {
                System.out.println("Student id not exist!! Please input again!");
            }
        } while (pos == -1);

        s.setName(MyToys.getAString("Input new Student name: ", "Student name is required!!"));
        s.setAddress(MyToys.getAString("Input new Student adress: ", "Student address is required!!"));
        s.setGender(MyToys.getMaleOrFemale("Input new Student gender(male or female): ", "Please input male or female!"));
        System.out.println("=>>> Update Student successfully <<<=");
        s.showStudentInfo();
    }

    public void removeStudent() {
        if (list.isEmpty()) {
            System.out.println("=>>>> No Student has been added yet!"
                    + "  Please input Student first!! <<<<=");
            return;
        }
        String id = MyToys.getAString("Input Student ID need to remove: ", "Student id is required!");
        s = searchStudent(id);
        if (s != null) {
            list.remove(s);
            System.out.println("=>>>> Remove success <<<<=");
        } else {
            System.out.println("=>>>> Remove fail! Student ID is not exist! <<<<=");
        }
    }

    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("=>>>> No Student has been added yet!"
                    + "  Please input Student first!! <<<<=");
            return;
        } else {
            for (Student s : list) {
                s.showStudentInfo();
            }
        }
    }

    public int findStudent(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Student searchStudent(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return list.get(i);
            }
        }
        return null;
    }
    
    public void sortStudentList() {
        Collections.sort(list);
    }
    
    public void checkCampusOfStudent(String code) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getCampus().getCode().equalsIgnoreCase(code))
                list.get(i).setCampus(null);
        }
    }
    
   
    
    
    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }
}
