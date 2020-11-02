package com.sAdamingo.course.lesson8;

import java.util.*;

public class Lottery {
    private static final int MAX_NUMBER = 49;

    private Map<String, Set<Integer>> players = new HashMap<>();

    public Lottery(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.put(UUID.randomUUID().toString(), generateRandomNumbers());
        }
    }

    private static Set<Integer> generateRandomNumbers() {
        Set<Integer> randomSet = new HashSet<>();
        Random rnd = new Random();
        while (randomSet.size() < 6) {
            randomSet.add(1 + rnd.nextInt(MAX_NUMBER));
        }
        return randomSet;
    }

    public Set<String> getWinnerId() {
        Set<Integer> winningNumber = generateRandomNumbers();
        Set<String> keys = new HashSet<>();
        for (Map.Entry<String, Set<Integer>> entry : players.entrySet()) {
            if (entry.getValue().equals(winningNumber)) {
                keys.add(entry.getKey());

            }
        }
        if (keys.size() != 0) {
            return keys;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Lottery Lotto = new Lottery(2000000);
        System.out.println(Lotto.getWinnerId());
    }
}
