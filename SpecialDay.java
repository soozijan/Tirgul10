package com.example.demo;

import java.io.Serializable;

public class SpecialDay implements Serializable {
    private int id;
    private String name;
    private int day;
    private int month;

    public SpecialDay() {
    }

    public SpecialDay(int id, String name, int day, int month) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;

    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "SpecialDay{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                '}';
    }
}
