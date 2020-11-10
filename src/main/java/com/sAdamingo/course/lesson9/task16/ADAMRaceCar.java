package com.sAdamingo.course.lesson9.task16;

import com.sAdamingo.course.lesson9.task16.brakes.MediumBrakes;
import com.sAdamingo.course.lesson9.task16.brakes.StrongBrakes;
import com.sAdamingo.course.lesson9.task16.brakes.WeakBrakes;
import com.sAdamingo.course.lesson9.task16.engine.HugeEngine;
import com.sAdamingo.course.lesson9.task16.engine.NormalEngine;
import com.sAdamingo.course.lesson9.task16.transmission.NormalTransmission;
import com.sAdamingo.course.lesson9.task16.transmission.ShortTransmission;
import com.sAdamingo.course.lesson9.task16.tyres.NormalTyres;
import com.sAdamingo.course.lesson9.task16.tyres.SportTyres;

import java.util.Comparator;
import java.util.List;

public class ADAMRaceCar extends RaceCar {
    @Override
    protected void prepareForRace(List<Integer> track) {
        if (track.size() < 6) {
            tyres = new SportTyres();
        } else {
            tyres = new NormalTyres();
        }
        int maxStraight = track.stream()
                .max(Comparator.comparingInt(Integer::intValue)).get();
        if (maxStraight < 500) {
            engine = new NormalEngine();
            transmission = new NormalTransmission();
        } else {
            engine = new HugeEngine();
            transmission = new ShortTransmission();
        }
        if (track.size() <= 10) {
            brakes = new StrongBrakes();
        } else if (track.size() <= 20) {
            brakes = new MediumBrakes();
        } else {
            brakes = new WeakBrakes();
        }
    }

    @Override
    protected String getName() {
        return "Ford Escort Stelmach Mod";
    }
}
