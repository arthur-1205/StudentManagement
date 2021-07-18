/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import DTO.Log;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Y545
 */
public class LogList {
    List<Log> list = new ArrayList<>();
    
    
    public boolean addLog(Log l){
        return list.add(l);
    }
    
    public boolean removeLog(Log l){
        return list.remove(l);
    }
    
    public boolean isEmpty(){
        if(list.isEmpty())
            return true;
        return false;
    }
    
    public void showAll() {
        for (Log log : list) {
            log.showAll();
        }
    }
     public void checkCourseOfStudent(String code) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getCourse().getCode().equalsIgnoreCase(code)){
                list.get(i).setCourse(null);
            }
        }
    }
    
    
}
