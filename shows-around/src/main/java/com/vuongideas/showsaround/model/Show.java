package com.vuongideas.showsaround.model;

import java.util.Date;

public class Show {
    private String title;
    private Date date;
    private String location;
    private double admission;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public double getAdmission() {
        return admission;
    }
    public void setAdmission(double admission) {
        this.admission = admission;
    }
}
