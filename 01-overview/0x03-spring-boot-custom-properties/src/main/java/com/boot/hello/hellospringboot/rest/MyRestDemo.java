package com.boot.hello.hellospringboot.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestDemo {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach name is: " + coachName + " and team name is: " + teamName;
    }
    @GetMapping("/")
    public String sayHello() {
        return "Hello There.";
    }

    @GetMapping("/workout")
    public String workOut() {
        return "Am working out!";
    }
}
