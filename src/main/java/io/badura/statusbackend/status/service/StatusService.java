package io.badura.statusbackend.status.service;

import io.badura.statusbackend.status.model.Status;
import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class StatusService {

    public Set<Status> getStatus(String scope){
        Set<Status> statusSet = new HashSet<>();
        statusSet.add(new Status(UUID.randomUUID(),"Component1","down","Sample message", new Date(System.currentTimeMillis())));
        statusSet.add(new Status(UUID.randomUUID(),"Component2","up","Sample message", new Date(System.currentTimeMillis())));
        statusSet.add(new Status(UUID.randomUUID(),"Component66","up","Sample message", new Date(System.currentTimeMillis())));
        return statusSet;
    }
}
