package com.example.mystartwarsapplication;

public class Starship {
    private String name;
    private String cost_in_credits;

    public Starship(String name, String cost_in_credits) {
        this.name = name;
        this.cost_in_credits = cost_in_credits;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }
}


