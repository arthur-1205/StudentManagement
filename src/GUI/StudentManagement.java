/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Campus;
import DTO.Course;
import DTO.Log;
import DTO.Student;
import Storage.CampusList;
import Storage.CourseList;
import Storage.LogList;
import Storage.StudentList;
import java.util.ArrayList;
import java.util.List;
import util.MyToys;

/**
 *
 * @author Y545
 */
public class StudentManagement {

    public static void main(String[] args) {

        StudentList studentList = new StudentList();
        CampusList campusList = new CampusList();
        CourseList courseList = new CourseList();
        LogList logList = new LogList();
        
        Log l;
        Student s;
        Campus ca;
        Course co;
        String code;
        String sId, caCode, coCode;

        int choice = 0;
        do {
            System.out.println("\n=====Welcome to Student Management Menu=====");
            System.out.println("1. Manage Student List");
            System.out.println("2. Manage Campus List");
            System.out.println("3. Manage Course List");
            System.out.println("4. Set relation between Student and Campus");
            System.out.println("5. Record Course of Student");
            System.out.println("6 .Exit the program!!");
            choice = MyToys.getAnInteger("Input your choice: ", "Input a number between 1 and 6", 0, 6);
            switch (choice) {
                case 1:
                    int choice1 = 0;
                    do {
                        System.out.println("\n====Student List Menu=====");
                        System.out.println("1. Add Student");
                        System.out.println("2. Update Student");
                        System.out.println("3. Remove Student");
                        System.out.println("4. Display all Students");
                        System.out.println("5. Exit");
                        choice1 = MyToys.getAnInteger("Input your choice1: ", "Input a number between 1 and 5", 0, 5);
                        switch (choice1) {
                            case 1:
                                studentList.addStudent();
                                break;
                            case 2:
                                studentList.updateStudent();
                                break;
                            case 3:
                                studentList.removeStudent();
                                break;
                            case 4:
                                studentList.showAll();
                                break;
                        }
                    } while (choice1 != 5);
                    break;
                case 2:
                    int choice2 = 0;
                    do {
                        System.out.println("\n====Campus List Menu=====");
                        System.out.println("1. Add Campus");
                        System.out.println("2. Update Campus");
                        System.out.println("3. Remove Campus");
                        System.out.println("4. Display all Campuses");
                        System.out.println("5. Exit");
                        choice2 = MyToys.getAnInteger("Input your choice2: ", "Input a number between 1 and 5", 0, 5);
                        switch (choice2) {
                            case 1:
                                campusList.addCampus();
                                break;
                            case 2:
                                campusList.updateCampus();
                                break;
                            case 3:
                                if (campusList.isEmpty()) {
                                    System.out.println("Campus List is empty!!");
                                    return;
                                } else {
                                    code = MyToys.getAString("Inpout Campus code you want to remove: ", "Campus code is required!!");
                                    ca = campusList.searchCampus(code);
                                    if (ca != null) {
                                        campusList.removeCampus(ca);
                                        studentList.checkCampusOfStudent(code);
                                        System.out.println("Remove Campus succesfully!1");
                                    }
                                }
                                break;
                            case 4:
                                campusList.sortCampusList();
                                campusList.showAll();
                                break;
                        }
                    } while (choice2 != 5);
                    break;
                case 3:
                    int choice3 = 0;
                    do {
                        System.out.println("\n====Course List Menu=====");
                        System.out.println("1. Add Course");
                        System.out.println("2. Update Course");
                        System.out.println("3. Remove Course");
                        System.out.println("4. Display all Courses");
                        System.out.println("5. Exit");
                        choice3 = MyToys.getAnInteger("Input your choice3: ", "Input a number between 1 and 5", 0, 5);
                        switch (choice3) {
                            case 1:
                                courseList.addCourse();
                                break;
                            case 2:
                                courseList.updateCourse();
                                break;
                            case 3:
                                if (courseList.isEmpty()) {
                                    System.out.println("Course List is empty!!");
                                    return;
                                } else {
                                    code = MyToys.getAString("Inpout Course code you want to remove: ", "Course code is required!!");
                                    co = courseList.searchCourse(code);
                                    if (co != null) {
                                        courseList.removeCourse(co);
                                        logList.checkCourseOfStudent(code);
                                        System.out.println("Remove Course successfully!");
                                    }
                                }
                                break;

                            case 4:
                                courseList.sortCourseList();
                                courseList.showAll();
                                break;

                        }
                    } while (choice3 != 5);
                    break;
                case 4:
                    int choice4 = 0;
                    do {
                        System.out.println("\n====Relationship List Menu=====");
                        System.out.println("1. Set ralationship");
                        System.out.println("2. Update relationship");
                        System.out.println("3. Remove relationship");
                        System.out.println("4. Display all relationship");
                        System.out.println("5. Exit");
                        choice4 = MyToys.getAnInteger("Input your choice4: ", "Input a number between 1 and 5", 0, 5);
                        switch (choice4) {
                            case 1:
                                if (studentList.isEmpty()) {
                                    System.out.println("Student List is empty!! Set fail!");
                                    break;
                                } else if (campusList.isEmpty()) {
                                    System.out.println("Campus List is empty! Set fail");
                                    break;
                                } else {
                                    sId = MyToys.getAString("Input Student id to set relation: ", "Student id is required");
                                    s = studentList.searchStudent(sId);
                                    if (s == null) {
                                        System.out.println("Not found Student!!");
                                        break;
                                    }
                                    caCode = MyToys.getAString("Input Campus code to set relation: ", "Campus code is required");
                                    ca = campusList.searchCampus(caCode);
                                    if (ca == null) {
                                        System.out.println("Not found Campus!!");
                                        break;
                                    } else {
                                        s.setCampus(ca);
                                        System.out.println("Set relationship successfully");
                                    }
                                }
                                break;

                            case 2:
                                if (studentList.isEmpty()) {
                                    System.out.println("Student List is empty!! Set fail!");
                                    break;
                                } else if (campusList.isEmpty()) {
                                    System.out.println("Campus List is empty! Set fail");
                                    break;
                                } else {
                                    sId = MyToys.getAString("Input Student id to update relation: ", "Student id is required");
                                    s = studentList.searchStudent(sId);
                                    if (s == null) {
                                        System.out.println("Not found Student!!");
                                        break;
                                    } else if (s.getCampus() != null) {
                                        System.out.println("Student already have campus!!");
                                        break;
                                    }
                                    caCode = MyToys.getAString("Input Campus code to replace campus: ", "Campus code is required");
                                    ca = campusList.searchCampus(caCode);
                                    if (ca == null) {
                                        System.out.println("Not found Campus!!");
                                        break;
                                    } else {
                                        s.setCampus(ca);
                                        System.out.println("Update relationship successfully!!");
                                    }
                                }
                                break;
                            case 3:
                                 if (studentList.isEmpty()) {
                                    System.out.println("Student List is empty!! Set fail!");
                                    break;
                                } else if (campusList.isEmpty()) {
                                    System.out.println("Campus List is empty! Set fail");
                                    break;
                                } else {
                                    sId = MyToys.getAString("Input Student id to update relation: ", "Student id is required");
                                    s = studentList.searchStudent(sId);
                                    if (s == null) {
                                        System.out.println("Not found Student!!");
                                        break;
                                    }else{
                                        s.setCampus(null);
                                        System.out.println("Remove relationship successfully!");
                                    }
                                }
                                break;
                                
                            case 4:
                                studentList.sortStudentList();
                                studentList.showAll();
                                break;
                                
                        }
                    } while (choice4 != 5);
                    break;
                case 5:
                    int choice5 = 0;
                    do {
                        System.out.println("\n====Log List Menu=====");
                        System.out.println("1. Add log");
                        System.out.println("2. Update log");
                        System.out.println("3. Remove log");
                        System.out.println("4. Display all log");
                        System.out.println("5. Exit");
                        choice5 = MyToys.getAnInteger("Input your choice5: ", "Input a number between 1 and 5", 0, 5);
                        switch (choice5) {
                            case 1:
                                sId = MyToys.getAString("Input Student ID to record course: ", "Student Id is required!!");
                                s = studentList.searchStudent(sId);
                                if (s == null) {
                                    System.out.println("=>>>> Not found PetID! <<<<=");
                                    break;
                                }
                                coCode = MyToys.getAString("Input Course code: ", "Course code is required!!");
                                co = courseList.searchCourse(coCode);
                                if (co == null) {
                                    System.out.println("=>>>> Not found SeviceID!! <<<<=");
                                    break;
                                }
                                logList.addLog(new Log(s, co));
                                System.out.println("Record succesfully!");
                                break;
                            case 2:
                                if (logList.isEmpty()) {
                                    System.out.println(" =>>>>> No Log has been added yet!!"
                                            + "  Please input Log first!! <<<<<=");
                                    break;
                                }
                                sId = MyToys.getAString("Input Student ID need to update Log: ", "Invalid format!!");
                                s = studentList.searchStudent(sId);
                                if (s == null) {
                                    System.out.println("=>>>> Not found Student ID! <<<<=");
                                    break;
                                }
                                coCode = MyToys.getAString("Input Course Code need to update Log: ", "Invalid format!!");
                                co = courseList.searchCourse(coCode);
                                if (co == null) {
                                    System.out.println("=>>>> Not found Course Code!! <<<<=");
                                    break;
                                }
                                String newCourse = MyToys.getAString("Input new Course Code: ", "Invalid format!!");
                                Course nc = courseList.searchCourse(newCourse);
                                if (nc == null) {
                                    System.out.println("=>>>> Not found SeviceID!! <<<<=");
                                    break;
                                }
                                co = nc;
                                System.out.println("=>>>> Update Log successfully! <<<<=");
                                break;
                            case 3:
                                if (logList.isEmpty()) {
                                    System.out.println(" =>>>>> No Log has been added yet!!"
                                            + "  Please input Log first!! <<<<<=");
                                    break;
                                }
                                sId = MyToys.getAString("Input Student ID to remove ", "Student Id is required!!");
                                s = studentList.searchStudent(sId);
                                if (s == null) {
                                    System.out.println("=>>>> Not found PetID! <<<<=");
                                    break;
                                }
                                coCode = MyToys.getAString("Input Course code to remove: ", "Course code is required!!");
                                co = courseList.searchCourse(coCode);
                                if (co == null) {
                                    System.out.println("=>>>> Not found SeviceID!! <<<<=");
                                    break;
                                }
                                logList.removeLog(new Log(s, co));
                                System.out.println("Remove succesfully!");
                                break;
                            case 4:
                                if (logList.isEmpty()) {
                                    System.out.println(" =>>>>> No Log has been added yet!!"
                                            + "  Please input Log first!! <<<<<=");
                                    break;
                                }
                                System.out.println("Information of all logs: ");
                                logList.showAll();
                                break;
                        }
                    } while (choice5 != 5);
                    break;
                case 6:
                    System.out.println("Thanks for using!!");
                    break;
            }
        } while (choice != 6);
    }

}
