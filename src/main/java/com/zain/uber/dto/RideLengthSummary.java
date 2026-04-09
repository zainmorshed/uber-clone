package com.zain.uber.dto;

public class RideLengthSummary {
    private double totalDistance;
    private double totalDuration;
    
    public RideLengthSummary(double totalDistance, double totalDuration) {
        this.totalDistance = totalDistance;
        this.totalDuration = totalDuration;
    }

    public RideLengthSummary(){}
    
    public double getTotalDistance() {
        return totalDistance;
    }
    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }
    public double getTotalDuration() {
        return totalDuration;
    }
    public void setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
    }

    
}
