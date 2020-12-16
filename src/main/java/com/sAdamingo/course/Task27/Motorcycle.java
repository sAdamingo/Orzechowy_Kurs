/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sAdamingo.course.Task27;

/**
 * @author Orzech
 */
public class Motorcycle {

    private String id;
    private String make;
    private String model;
    private int bhp;

    private Motorcycle() {
        // empty
    }

    public Motorcycle(String id, String make, String model, int bhp) {
        this.make = make;
        this.model = model;
        this.bhp = bhp;
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getBhp() {
        return bhp;
    }

    public String getId() {
        return id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBhp(int bhp) {
        this.bhp = bhp;
    }
}
