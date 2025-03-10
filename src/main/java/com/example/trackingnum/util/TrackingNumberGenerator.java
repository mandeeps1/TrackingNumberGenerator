package com.example.trackingnum.util;


import java.security.SecureRandom;

public class TrackingNumberGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int TRACKING_NUMBER_LENGTH = 16;
    private final SecureRandom random = new SecureRandom();

    public String generate(String baseString) {
        StringBuilder trackingNumber = new StringBuilder(TRACKING_NUMBER_LENGTH);
        // Ensure randomness by appending the base string and generating random chars
        baseString = baseString + System.currentTimeMillis();
        for (int i = 0; i < TRACKING_NUMBER_LENGTH; i++) {
            trackingNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return trackingNumber.toString();
    }
}

