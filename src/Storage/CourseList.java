package Storage;



import DTO.Campus;
import DTO.Course;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.MyToys;


public class CourseList {
    List<Course> list = new ArrayList<>();
    Course co;
    
    public void addCourse() {
        int pos;
        String code, name;
        long credits;
        do {
            code = MyToys.getAString("Input Course code: ", "Course code is required");
            pos = findCourse(code);
            co = searchCourse(code);
            if (pos >= 0) {
                System.out.println("Course code already exist!! Please input again!");
            }
        } while (pos != -1);
        name = MyToys.getAString("Input Course name: ", "Course name is required!!");
        credits = MyToys.getAnInteger("Input Course Credits: ", "Input a positive integer!", 0);
 
        list.add(new Course(code, name, credits) );
        System.out.println("=>>> Add Course successfully!! <<<=");
    }
    
    public void updateCourse() {
        int pos;
        String code;
        if (list.isEmpty()) {
            System.out.println("Course List is empty!!");
            return;
        }
        do {
            code = MyToys.getAString("Input Course code to update: ", "Course code is required!");
            pos = findCourse(code);
            co = searchCourse(code);
            if (pos == -1) {
                System.out.println("Course code not exist!! Please input again!");
            }
        } while (pos == -1);

        co.setName(MyToys.getAString("Input new Campus name: ", "Campus name is required!!"));
        co.setCredits(MyToys.getAnInteger("Input new Course credits: ", "Input a positive integer!", 0 ));
        System.out.println("=>>> Update Course successfully <<<=");
        co.showCourceInformation();
    }
    
    public boolean removeCourse(Course co) {
            return list.remove(co);
 
    }
            
    
    public int findCourse(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public Course searchCourse(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code)) {
                return list.get(i);
            }
        }
        return null;
    }
    
    public void sortCourseList() {
        Collections.sort(list);
    }
    
    public void showAll() {
         if (list.isEmpty()) {
            System.out.println("Course List is empty!! Nothing to show!!");
            return;
        }
         for (Course course : list) {
            course.showCourceInformation();
        }
    }
    
    
    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }
    
}
