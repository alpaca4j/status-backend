package io.badura.statusbackend.status.repository;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name="availability")
public class InfluxTag {

    @Column(name="value")
    private String scope;

    public String getScope() {
        return scope;
    }
}
