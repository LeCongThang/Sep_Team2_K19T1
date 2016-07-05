/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Report {

    private String tagName;
   /// private Date startTime;
    private double times;

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

//    public Date getStartTime() {
//        return this.startTime;
//    }
//
//    public void setStartTime(Date startTime) {
//        this.startTime = startTime;
//    }

    public double getTimes() {
        return this.times;
    }

    public void setTimes(double times) {
        this.times = times;
    }
}
