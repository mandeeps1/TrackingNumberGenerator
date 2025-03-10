package com.example.trackingnum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trackingnum.entity.TrackingNumber;

public interface TrackingNumberRepository extends JpaRepository<TrackingNumber, String> {
    boolean existsByTrackingNumber(String trackingNumber);
}
