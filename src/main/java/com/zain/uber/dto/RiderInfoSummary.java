package com.zain.uber.dto;

import com.zain.uber.enums.RideType;

public class RiderInfoSummary {

    private String name;
    private String destination;
    private String location;
    private RideType rideType;

    private double totalDistance;
    private double totalDuration;


    public RiderInfoSummary(String name, String destination, String location, RideType rideType, double totalDistance, double totalDuration) {
        this.name = name;
        this.destination = destination;
        this.location = location;
        this.rideType = rideType;
        this.totalDistance = totalDistance;
        this.totalDuration = totalDuration;
    }

    public RiderInfoSummary() {
    }   


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


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }

    public RideType getRideType() {
        return rideType;
    }


}
