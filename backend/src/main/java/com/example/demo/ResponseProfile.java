package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseProfile {
    private Long id;

    private String error;

    private HashMap<String, HashMap<String, HashMap<String, String>>> resp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HashMap<String, HashMap<String, HashMap<String, String>>> getResp() {
        return resp;
    }

    public void setResp(HashMap<String, HashMap<String, HashMap<String, String>>> resp) {
        this.resp = resp;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", error='" + error + '\'' +
                ", result=" + resp +
                '}';
    }
}
