package com.sAdamingo.course.lesson6.objects.kitchen;

public class Spoon {

    private boolean used = false;

    public void eat() {
        used = true;
    }

    public boolean isUsed() {
        return used;
    }
}
