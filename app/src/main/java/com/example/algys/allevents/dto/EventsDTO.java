package com.example.algys.allevents.dto;

import java.util.Date;

public class EventsDTO {

    private long id;
    private String title;
    private Date eventDate;

    public EventsDTO(String title) {
        this.title = title;
    }

    public EventsDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
