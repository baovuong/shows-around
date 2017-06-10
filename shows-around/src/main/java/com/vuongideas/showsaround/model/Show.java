package com.vuongideas.showsaround.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Show {
    private String title;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="H:mm")
    private Date startTime;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="H:mm")
    private Date doorTime;
    
    private String location;
    
    private String admission;
    
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
    public String getAdmission() {
        return admission;
    }
    public void setAdmission(String admission) {
        this.admission = admission;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getDoorTime() {
        return doorTime;
    }
    public void setDoorTime(Date doorTime) {
        this.doorTime = doorTime;
    }
}
