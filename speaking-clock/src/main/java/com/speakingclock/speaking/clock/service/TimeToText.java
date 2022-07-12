package com.speakingclock.speaking.clock.service;

import java.time.LocalDateTime;

public class TimeToText {

    //Array for tenth place elements
    String[] tenMultiple = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty"};
    //Array for first place
    String[] oneMultiple = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
            " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    public static final String MIDDAY = "it's Midday";
    public static final String MIDNIGHT = "It's Midnight";

    public String timeToTextUsingCalendar(LocalDateTime calendar) throws NullPointerException {
        try {
            if (calendar == null) {
                throw new NullPointerException("Date not found");
            }

            int hour = calendar.getHour();
            int minute = calendar.getMinute();
            String hourString;
            String minString;
            //edge cases
            if (hour == 12) {
                return MIDDAY;
            }
            if (hour == 0) {
                return MIDNIGHT;
            }

            //convert int time to text
            if (hour < 20) {
                hourString = oneMultiple[hour];
            } else {
                int hourtens = hour / 10;
                int hour1 = hour % 10;
                hourString = tenMultiple[hourtens] + oneMultiple[hour1];
            }

            if (minute < 20) {
                minString = oneMultiple[minute];
            } else {
                int tens = minute / 10;
                int ones = minute % 10;
                minString = tenMultiple[tens] + oneMultiple[ones];
            }
            return "it's " + hourString + " " + minString;
        } catch (NullPointerException e) {
            throw e;
        }
    }
}
