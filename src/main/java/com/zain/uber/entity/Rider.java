package com.zain.uber.entity;


import com.zain.uber.enums.RideType;
import com.zain.uber.enums.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    private String name;
    private PaymentType paymentType;
    private String destination;
    private String location;
    
    private double startLat;
    private double startLang;
    private double endLat;
    private double endLang;

    @Enumerated(EnumType.STRING)
    private RideType rideType;

    public Rider(Long id, String name, PaymentType paymentType, String destination, String location, RideType rideType,
        double startLat, double startLang, double endLat, double endLang
    ) {
        this.id = id;
        this.name = name;
        this.paymentType = paymentType;
        this.destination = destination;
        this.location = location;
        this.rideType = rideType;
        this.startLat = startLat;
        this.startLang = startLang;
        this.endLat = endLat;
        this.endLang = endLang;
    }

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    public double getStartLang() {
        return startLang;
    }

    public void setStartLang(double startLang) {
        this.startLang = startLang;
    }

    public double getEndLat() {
        return endLat;
    }

    public void setEndLat(double endLat) {
        this.endLat = endLat;
    }

    public double getEndLang() {
        return endLang;
    }

    public void setEndLang(double endLang) {
        this.endLang = endLang;
    }

    public Rider(){

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
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