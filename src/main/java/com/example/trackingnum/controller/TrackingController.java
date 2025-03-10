package com.example.trackingnum.controller;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trackingnum.response.TrackingResponse;
import com.example.trackingnum.service.TrackingService;

@RestController
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @GetMapping("/next-tracking-number")
    public TrackingResponse getNextTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam double weight,
            @RequestParam String created_at,
            @RequestParam String customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {

        String trackingNumber = trackingService.generateTrackingNumber(
                origin_country_id,
                destination_country_id,
                weight,
                created_at,
                customer_id,
                customer_name,
                customer_slug
        );

        return new TrackingResponse(trackingNumber, OffsetDateTime.now().toString());
    }
}
