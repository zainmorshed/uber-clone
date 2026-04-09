package com.zain.uber.dto;

public class RouteSummary {

    private double startLat;
    private double startLng;
    private double endLat;
    private double endLng;

    public RouteSummary(double startLat, double startLng, double endLat, double endLng) {
    this.startLat = startLat;
    this.startLng = startLng;
    this.endLat = endLat;
    this.endLng = endLng;
    }

    public RouteSummary(){}

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    public double getStartLng() {
        return startLng;
    }

    public void setStartLng(double startLng) {
        this.startLng = startLng;
    }

    public double getEndLat() {
        return endLat;
    }

    public void setEndLat(double endLat) {
        this.endLat = endLat;
    }

    public double getEndLng() {
        return endLng;
    }

    public void setEndLang(double endLng) {
        this.endLng = endLng;
    }




    
}
