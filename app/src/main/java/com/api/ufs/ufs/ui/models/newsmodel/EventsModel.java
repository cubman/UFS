package com.api.ufs.ufs.ui.models.newsmodel;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Анатолий on 29.08.2017.
 */

public class EventsModel {

    private Date event_dategmt;
    private String title_tag_line;
    private String arena;
    private String location;

    public Date getEvent_dategmt() {
        return event_dategmt;
    }

    public void setEvent_dategmt(Date event_dategmt) {
        this.event_dategmt = event_dategmt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle_tag_line() {
        return title_tag_line;
    }

    public void setTitle_tag_line(String title_tag_line) {
        this.title_tag_line = title_tag_line;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }
}
