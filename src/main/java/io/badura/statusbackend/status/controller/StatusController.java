package io.badura.statusbackend.status.controller;

import io.badura.statusbackend.status.repository.InfluxStatus;
import io.badura.statusbackend.status.repository.InfluxTag;
import io.badura.statusbackend.status.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class StatusController {

    @Autowired
    StatusService statusService;


    @GetMapping("/statusInflux")
    public List<InfluxStatus> getInfluxStatus(@RequestParam(value="scope") String scope) {
        List<InfluxStatus> statusSet = statusService.getInfluxStatus(scope);
        return statusSet;
    }

    @GetMapping("/tagInflux")
    public List<InfluxTag> getInfluxTag() {
        List<InfluxTag> influxTags = statusService.getInfluxTags();
        return influxTags;
    }
}
