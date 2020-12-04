package com.sAdamingo.course.Task24;

import java.sql.Timestamp;

public class Operation {
    public long timestamp;
    public double amount;
    public String name;

    public Operation(double amount, String name) {
        this.timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        this.amount = amount;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Timestamp: " + timestamp + "; Amount: " + amount + "; Operation name: " + name + ".";
    }
}

