package com.sAdamingo.course.lesson3.homework;

public class Task75 {
    public static void main(String[] args) {
        String s1 = getFirstString();
        String s2 = getSecondString();
        printIfAreEqual(s1, s2);
    }

    private static void printIfAreEqual(String s1, String s2) {
        if (isHalfEven(s1, s2)) {
            System.out.println("Half are even!");
        }
    }

    private static boolean isHalfEven(String s1, String s2) {
        boolean areEqualOdd = true;
        boolean areEqualEven = true;

        for (int i = 1; i < (Math.min(s1.length(), s2.length())); i = i + 2) {
            boolean areEqualEven2 = isEqual(s1, s2, areEqualOdd, i - 1);
            areEqualOdd = areEqualEven2;
            boolean areEqualEven1 = isEqual(s1, s2, areEqualEven, i);
            areEqualEven = areEqualEven1;
        }
        return areEqualEven || areEqualOdd;

    }

    private static boolean isEqual(String s1, String s2, boolean areEqualEven, int i) {
        boolean areEqualEven1 = areEqualEven;
        if (s1.charAt(i) != s2.charAt(i) && areEqualEven1) {
            areEqualEven1 = false;
        }
        return areEqualEven1;
    }

    private static String getFirstString() {
        return "AxLwAqMdAgKota200";
    }

    private static String getSecondString() {
        return "KxOwBqOdJg";
    }

}
