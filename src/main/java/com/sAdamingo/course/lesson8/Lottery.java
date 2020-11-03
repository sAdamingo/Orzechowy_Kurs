package com.sAdamingo.course.lesson8;

import java.util.*;

public class Lottery {
    private static final int MAX_NUMBER = 49;
    private Map<Set<Integer>, List<String>> players = new HashMap<>();

    public Lottery(int numberOfPlayers) {
        List<String> playersWithSameType = new ArrayList<>();
        Set<Integer> playerTypes = generateRandomNumbers();
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players.containsKey(playerTypes)) {
                players.get(playerTypes).add(UUID.randomUUID().toString());
            } else {
                playersWithSameType.add(UUID.randomUUID().toString());
                players.put(generateRandomNumbers(), playersWithSameType);
            }
        }
    }

    private static Set<Integer> generateRandomNumbers() {
        Set<Integer> randomSet = new HashSet<>();
        Random rnd = new Random();
        while (randomSet.size() < 4) {
            randomSet.add(1 + rnd.nextInt(MAX_NUMBER));
        }
        return randomSet;
    }

    public List<String> getWinnerId() {
        Set<Integer> winningNumber = generateRandomNumbers();
        if (players.containsKey(winningNumber)) {
            return players.get(winningNumber);
        }
        return null;
    }

    public static void main(String[] args) {
        Lottery Lotto = new Lottery(200000);
        System.out.println(Lotto.getWinnerId());
    }
}
