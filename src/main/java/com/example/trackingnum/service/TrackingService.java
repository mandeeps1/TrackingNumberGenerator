package com.example.trackingnum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trackingnum.entity.TrackingNumber;
import com.example.trackingnum.repository.TrackingNumberRepository;
import com.example.trackingnum.util.TrackingNumberGenerator;

@Service
public class TrackingService {

    @Autowired
    private TrackingNumberRepository repository;

    private final TrackingNumberGenerator generator = new TrackingNumberGenerator();

    public String generateTrackingNumber(String originCountry, String destinationCountry, double weight,
                                          String createdAt, String customerId, String customerName, String customerSlug) {
        String baseString = originCountry + destinationCountry + weight + createdAt + customerId + customerSlug;
        String trackingNumber;

        do {
            trackingNumber = generator.generate(baseString);
        } while (repository.existsByTrackingNumber(trackingNumber));

        // Store the generated tracking number to ensure uniqueness.
        repository.save(new TrackingNumber(trackingNumber));

        return trackingNumber;
    }
}

