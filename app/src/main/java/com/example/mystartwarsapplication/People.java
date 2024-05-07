//package com.example.mystartwarsapplication;
//
//public class People {
//    private String name;
//    private String height;
//    private String gender;
//    private String[] films;
//
//    public People(String name, String height, String gender, String[] films) {
//        this.name = name;
//        this.height = height;
//        this.gender = gender;
//        this.films = films;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getHeight() {
//        return height;
//    }
//
//    public void setHeight(String height) {
//        this.height = height;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String[] getFilms() {
//        return films;
//    }
//
//    public void setFilms(String[] films) {
//        this.films = films;
//    }
//}


package com.example.mystartwarsapplication;

import java.util.List;

public class People {
    private String name;
    private String height;
    private String gender;
    private List<String> films; // Change the data type to List<String>

    public People(String name, String height, String gender, List<String> films) { // Update constructor parameter type
        this.name = name;
        this.height = height;
        this.gender = gender;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getFilms() { // Update getter return type
        return films;
    }

    public void setFilms(List<String> films) { // Update setter parameter type
        this.films = films;
    }
}
