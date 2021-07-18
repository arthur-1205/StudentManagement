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
public class Course implements Comparable<Course>{
    private String code;
    private String name;
    private long credits;

    public Course(String code, String name, long credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
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

    public long getCredits() {
        return credits;
    }

    public void setCredits(long credits) {
        this.credits = credits;
    }
    
    public void showCourceInformation() {
        System.out.printf("|COURSE   |CODE: %10s|NAME: %10s|CREDITS: %15d|\n",
                                        code.toUpperCase(), name.toUpperCase(), credits);
    }

    @Override
    public int compareTo(Course o) {
        if(code.compareToIgnoreCase(o.getCode()) == 1) return 1;
        else if(code.compareToIgnoreCase(o.getCode()) == -1) return -1;
        return 0;
    }
}
