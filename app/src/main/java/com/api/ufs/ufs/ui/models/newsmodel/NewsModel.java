package com.api.ufs.ufs.ui.models.newsmodel;

import android.content.Intent;
import android.view.View;

import com.api.ufs.ufs.ui.utilResycler.NewsActivity;

import java.util.Date;

/**
 * Created by Анатолий on 28.08.2017.
 */

public class NewsModel {
    private long id;
    private String author;
    private String title;
    private String thumbnail;
    private Date published_start_date;

    public Date getPublished_start_date() {
        return published_start_date;
    }

    public void setPublished_start_date(Date published_start_date) {
        this.published_start_date = published_start_date;
    }


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
