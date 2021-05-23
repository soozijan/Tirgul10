package com.example.demo;

import java.io.Serializable;

public class Holiday implements Serializable {
    private int id;
    private String name;
    private int day;
    private int month;
    private int length;



    public Holiday() {
    }

    public Holiday(int id, String name, int day, int month, int length) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.length = length;
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
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", length=" + length +
                '}';
    }
}

