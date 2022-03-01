package com.example.demo;

public class BrandData {

    private String brandName;

    private Long totalProfiles;

    private Long totalFans;

    private Long TotalEngagement;

    public void addProfileFans(Long fans) {
        this.totalFans += fans;
    }

    public void addProfileEngagement(Long engagement) {
        this.TotalEngagement += engagement;
    }

    public String getBrandName() { return brandName; }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getTotalProfiles() {
        return totalProfiles;
    }

    public void setTotalProfiles(Long totalProfiles) {
        this.totalProfiles = totalProfiles;
    }

    public Long getTotalFans() {
        return totalFans;
    }

    public void setTotalFans(Long totalFans) {
        this.totalFans = totalFans;
    }

    public Long getTotalEngagement() {
        return TotalEngagement;
    }

    public void setTotalEngagement(Long totalEngagement) {
        TotalEngagement = totalEngagement;
    }

    @Override
    public String toString() {
        return "BrandData{" +
                "brandName='" + brandName + '\'' +
                ", totalProfiles=" + totalProfiles +
                ", totalFans=" + totalFans +
                ", TotalEngagement=" + TotalEngagement +
                '}';
    }
}
