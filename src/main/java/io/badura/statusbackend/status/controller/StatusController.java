package io.badura.statusbackend.status.controller;

import io.badura.statusbackend.status.model.Status;
import io.badura.statusbackend.status.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping("/status")
    public Set<Status> getStatus(@RequestParam(value="scope") String scope) {
        Set<Status> statusSet = statusService.getStatus(scope);
        return statusSet;
    }
}
