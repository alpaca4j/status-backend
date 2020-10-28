package io.badura.statusbackend.status.repository;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;

import java.util.List;


public class InfluxStatusRepository {
    InfluxDB influxDB;

    public InfluxStatusRepository(String databaseURL, String userName, String password) {
        this.influxDB = InfluxDBFactory.connect(databaseURL, userName, password);
    }

    public InfluxStatusRepository(String databaseURL) {
        this.influxDB = InfluxDBFactory.connect(databaseURL);
    }

    public List<InfluxStatus> getStatus(String scope) {
        Query getLastStatus =
                new Query("select last(\"status\") as status, " +
                        "message from \"status\".\"daily\".\"availability\" " +
                        "where \"scope\"='" + scope + "' " +
                        "group by \"name\"");
        QueryResult queryResult = influxDB.query(getLastStatus);
        InfluxDBResultMapper mapper = new InfluxDBResultMapper();
        return mapper.toPOJO(queryResult, InfluxStatus.class);
    }

    public List<InfluxTag> getTags(){
        Query getTags =
                new Query("SHOW TAG VALUES ON \"status\" FROM \"availability\" WITH KEY = \"scope\"");
        QueryResult queryResult = influxDB.query(getTags);
        InfluxDBResultMapper mapper = new InfluxDBResultMapper();
        return mapper.toPOJO(queryResult, InfluxTag.class);
    }
}
