package com.example.demo;

import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class RequestProfile {

    ZonedDateTime start;

    ZonedDateTime end;

    TimeZone timezone;

    public ZonedDateTime getStart() {
        return start;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }
}
