package com.speakingclock.speaking.clock.service;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class TimeToTextTest {

    public static final String MIDDAY = "it's Midday";
    public static final String MIDNIGHT = "It's Midnight";
    public static final String TIME = "It's Ten Thirty";

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testTimeToTextUsingCalendarMidday() throws NullPointerException {
        TimeToText timeToText = new TimeToText();
        String time = timeToText.timeToTextUsingCalendar(LocalDateTime.of(LocalDate.now(), LocalTime.NOON));
        Assert.hasText(MIDDAY, time);
    }

    @Test
    public void testTimeToTextUsingCalendarMiddnight() throws NullPointerException {
        TimeToText timeToText = new TimeToText();
        String time = timeToText.timeToTextUsingCalendar(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT));
        Assert.hasText(MIDNIGHT, time);
    }

    @Test
    public void testTimeToTextUsingCalendarNow() throws NullPointerException {
        TimeToText timeToText = new TimeToText();
        String time = timeToText.timeToTextUsingCalendar(LocalDateTime.of(LocalDate.now(), LocalTime.of(22,32)));
        Assert.notNull(TIME, time);
    }

    @Test
    public void testTimeToTextUsingCalendarTest() throws NullPointerException {
        TimeToText timeToText = new TimeToText();
        String time = timeToText.timeToTextUsingCalendar(LocalDateTime.of(LocalDate.now(), LocalTime.of(10,15)));
        Assert.notNull(TIME, time);
    }

    @Test
    public void testTimeToTextUsingCalendarNull() throws NullPointerException {
        exceptionRule.expect(NullPointerException.class);
        exceptionRule.expectMessage("Date not found");
        TimeToText timeToText = new TimeToText();
        timeToText.timeToTextUsingCalendar(null);
    }
}
