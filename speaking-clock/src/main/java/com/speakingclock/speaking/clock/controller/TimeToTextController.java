package com.speakingclock.speaking.clock.controller;

import com.speakingclock.speaking.clock.service.TimeToText;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/time")
public class TimeToTextController {

    @GetMapping("/text")
    public String getTimeText() {
        TimeToText timeToText = new TimeToText();
        return timeToText.timeToTextUsingCalendar(LocalDateTime.now());
    }

}
