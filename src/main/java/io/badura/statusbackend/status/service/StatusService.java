package io.badura.statusbackend.status.service;


import io.badura.statusbackend.status.repository.InfluxStatus;
import io.badura.statusbackend.status.repository.InfluxStatusRepository;
import io.badura.statusbackend.status.repository.InfluxTag;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class StatusService {

    private InfluxStatusRepository influxStatusRepository;

    public StatusService() {
        this.influxStatusRepository = new InfluxStatusRepository("http://localhost:8086");
    }

    public List<InfluxStatus> getInfluxStatus(String scope){
        List<InfluxStatus> statusList = influxStatusRepository.getStatus(scope);
        return statusList;
    }

    public List<InfluxTag> getInfluxTags() {
       return influxStatusRepository.getTags();
    }

}
