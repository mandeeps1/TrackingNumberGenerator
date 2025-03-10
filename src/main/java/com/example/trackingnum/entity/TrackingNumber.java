package com.example.trackingnum.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TrackingNumber {

    @Id
    private String trackingNumber;

    // Constructors, Getters, Setters
    public TrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}

