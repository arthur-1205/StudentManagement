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
public class Campus implements Comparable<Campus>{
    private String code;
    private String name;
    private String address;

    public Campus(String code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    
    public void showCampusInfo() {
        System.out.printf("|CAMPUS   |CODE: %7s|NAME: %15s|ADDRESS: %10s|\n",
                                 code.toUpperCase(), name.toUpperCase(), address.toUpperCase());
    }

    @Override
    public int compareTo(Campus o) {
        if(code.compareToIgnoreCase(o.getCode()) == 1) return 1;
        else if(code.compareToIgnoreCase(o.getCode()) == -1) return -1;
        return 0;
    }
}
