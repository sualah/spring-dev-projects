package com.dev.springCore;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach{

    public TenisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backend volley.";
    }
}
