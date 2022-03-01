package com.example.demo;

public class ProfileData {

    private Long fans;

    private Long engagement;

    public ProfileData(Long fans, Long engagement) {
        this.fans = fans;
        this.engagement = engagement;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public Long getEngagement() {
        return engagement;
    }

    public void setEngagement(Long engagement) {
        this.engagement = engagement;
    }

    @Override
    public String toString() {
        return "ProfileData{" +
                "fans=" + fans +
                ", engagement=" + engagement +
                '}';
    }
}
