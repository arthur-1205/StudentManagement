
package Storage;

import DTO.Campus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.MyToys;

public class CampusList {
    List<Campus> list = new ArrayList<>();
    
    Campus ca;
    
    public void addCampus() {
        int pos;
        String code, name, address;
        do {
            code = MyToys.getAString("Input Campus code: ", "Campus code is required");
            pos = findCampus(code);
            ca = searchCampus(code);
            if (pos >= 0) {
                System.out.println("Campus code already exist!! Please input again!");
            }
        } while (pos != -1);
        name = MyToys.getAString("Input Campus name: ", "Campus name is required!!");
        address = MyToys.getAString("Input Campus adress: ", "Campus address is required!!");
 
        list.add(new Campus(code, name, address));
        System.out.println("=>>> Add Campus successfully!! <<<=");
    }
    
    public void updateCampus(){
        int pos;
        String code;
        if (list.isEmpty()) {
            System.out.println("Campus List is empty!!");
            return;
        }
        do {
            code = MyToys.getAString("Input Campus code to update: ", "Campus code is required!");
            pos = findCampus(code);
            ca = searchCampus(code);
            if (pos == -1) {
                System.out.println("Campus code not exist!! Please input again!");
            }
        } while (pos == -1);

        ca.setName(MyToys.getAString("Input new Campus name: ", "Campus name is required!!"));
        ca.setAddress(MyToys.getAString("Input new Campus adress: ", "Campus address is required!!"));
        System.out.println("=>>> Update Campus successfully <<<=");
        ca.showCampusInfo();
    }
    
    public boolean removeCampus(Campus ca) {
            return list.remove(ca);
        
    }
    public int findCampus(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public Campus searchCampus(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code)) {
                return list.get(i);
            }
        }
        return null;
    }
    
    public void sortCampusList() {
        Collections.sort(list);
    }
    
    public void showAll() {
        if(list.isEmpty()){
            System.out.println("Campus List is empty! Nothing to show");
            return;
        }
        for (Campus campus : list) {
            campus.showCampusInfo();
        }
    }
    
    
    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }
}
