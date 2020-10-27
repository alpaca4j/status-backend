package io.badura.statusbackend.status.model;

import java.util.Date;
import java.util.UUID;


public class Status {
    private UUID id;
    private String name;
    private String status;
    private String message;

    public String getMessage() {
        return message;
    }

    public Date getScraped() {
        return scraped;
    }

    private Date scraped;

    public Status(UUID id, String name, String status, String message, Date scraped) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.message = message;
        this.scraped = scraped;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
