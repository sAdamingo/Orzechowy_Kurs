package com.sAdamingo.course.lesson3.homework;

public class Task75 {
    public static void main(String[] args) {
        String s1 = getFirstString();
        String s2 = getSecondString();
        boolean areEqualOdd = getTrueBoolean();
        boolean areEqualEven = getTrueBoolean();
        isHalfEven(s1, s2, areEqualOdd, areEqualEven);
    }

    private static void isHalfEven(String s1, String s2, boolean areEqualOdd, boolean areEqualEven) {
        for (int i = 1; i < (s1.length() < s2.length() ? s1.length() : s2.length()); i = i + 2) {
            boolean areEqualEven2 = areEqualOdd;
            if (s1.charAt(i - 1) != s2.charAt(i - 1) && areEqualEven2) {
                areEqualEven2 = false;
            }
            areEqualOdd = areEqualEven2;
            boolean areEqualEven1 = areEqualEven;
            if (s1.charAt(i) != s2.charAt(i) && areEqualEven1) {
                areEqualEven1 = false;
            }
            areEqualEven = areEqualEven1;
        }
        if (areEqualEven || areEqualOdd) {
            System.out.println("Half is equal!");
        }
    }

    private static String getFirstString() {
        return "AxLwAqMdAgKota200";
    }

    private static String getSecondString() {
        return "KxOwBqOdJg";
    }

    private static boolean getTrueBoolean() {
        return true;
    }

}
