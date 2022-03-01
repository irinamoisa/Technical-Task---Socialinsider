package com.example.demo;

import java.util.ArrayList;

public class ResponseBrand {

    private Long id;

    private String error;

    private ArrayList<Result> result;

    public Long getId() {
        return id;
    }

    public String getError() {
        return error;
    }

    public ArrayList<Result> getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", error='" + error + '\'' +
                ", result=" + result +
                '}';
    }
}
