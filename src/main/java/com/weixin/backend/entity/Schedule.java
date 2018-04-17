package com.weixin.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.crypto.Data;

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private int id;

    private Data date;

    private int movieId;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
