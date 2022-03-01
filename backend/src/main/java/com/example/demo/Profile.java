package com.example.demo;

import java.util.Date;

public class Profile {

    private String name;

    private String profile_added;

    private String id;

    private String profile_type;

    public String getName() {
        return name;
    }

    public String getProfile_added() {
        return profile_added;
    }

    public String getId() {
        return id;
    }

    public String getProfile_type() {
        return profile_type;
    }

    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
                ", profile_added='" + profile_added + '\'' +
                ", id='" + id + '\'' +
                ", profile_type='" + profile_type + '\'' +
                '}';
    }
}
