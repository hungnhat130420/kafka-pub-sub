package com.kafka.producer.entity;

public class Commodity {
    private String name;
    private double price;
    private String measurement;
    private long timestamp;

    public Commodity(String name, double price, String measurement, long timestamp) {
        this.name = name;
        this.price = price;
        this.measurement = measurement;
        this.timestamp = timestamp;
    }

    public Commodity() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getMeasurement() {
        return measurement;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
