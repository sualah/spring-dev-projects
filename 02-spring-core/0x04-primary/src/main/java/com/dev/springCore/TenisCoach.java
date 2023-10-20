package com.dev.springCore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TenisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your backend volley.";
    }
}
