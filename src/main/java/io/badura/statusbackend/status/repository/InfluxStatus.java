package io.badura.statusbackend.status.repository;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.time.Instant;

@Measurement(name = "availability")
public class InfluxStatus {

    @Column(name="time")
    private Instant checkDate;

    @Column(name="name")
    private String name;

    @Column(name="status")
    private String status;

    @Column(name="message")
    private String message;

    public Instant getCheckDate() {
        return checkDate;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
