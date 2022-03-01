package com.example.demo;

import java.util.ArrayList;

public class Result {

    private ArrayList<Profile> profiles;

    private String brandname;

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public String getBrandname() {
        return brandname;
    }

    @Override
    public String toString() {
        return "" +
                "profiles=" + profiles +
                ", brandname='" + brandname + '\'' +
                '}';
    }
}
