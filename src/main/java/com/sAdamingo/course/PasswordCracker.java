package com.sAdamingo.course;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class PasswordCracker {
    public static long START_TIME;
    public static char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789@#&!()^=+/:.;,".toCharArray();
    static public int MAX_CHAR_NUMBER = 8;

    public int[][] threadDivider() {
        int cores = Runtime.getRuntime().availableProcessors();
        long totalOperationsNumber = 0;
        for (int i = 1; i <= MAX_CHAR_NUMBER; i++) {
            totalOperationsNumber += Math.pow(ALPHABET.length, i);
        }
        long averageOperationsPerThread = totalOperationsNumber / cores;
        int[][] subsets = new int[cores][2];
        long totalOperationsNumberr = 0;
        int currentCore = 1;
        for (int i = 1; i < MAX_CHAR_NUMBER; i++) {
            totalOperationsNumberr += Math.pow(ALPHABET.length, i);

            if (totalOperationsNumberr > averageOperationsPerThread || i > MAX_CHAR_NUMBER - cores) {
                if (currentCore == 1) {
                    subsets[currentCore - 1][0] = 1;
                    subsets[currentCore - 1][1] = i;
                    currentCore++;
                    totalOperationsNumberr -= averageOperationsPerThread;
                } else if (currentCore == cores) {
                    subsets[currentCore - 1][0] = subsets[currentCore - 2][1] + 1;
                    subsets[currentCore - 1][1] = MAX_CHAR_NUMBER;
                } else {
                    subsets[currentCore - 1][0] = subsets[currentCore - 2][1] + 1;
                    subsets[currentCore - 1][1] = i;
                    currentCore++;
                    totalOperationsNumberr -= averageOperationsPerThread;
                }
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        START_TIME = System.currentTimeMillis();
        int cores = Runtime.getRuntime().availableProcessors();
        int[][] subsets = new PasswordCracker().threadDivider();
        AtomicBoolean aB = new AtomicBoolean(false);
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < cores; i++) {
            executorService.submit(new Cracker(subsets[i][0], subsets[i][1], "s!;@n", aB, ALPHABET));
        }
        executorService.shutdownNow();
    }
}