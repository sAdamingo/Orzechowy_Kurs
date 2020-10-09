package com.sAdamingo.course.lesson2.homework;

public class HalfAreEqual {
    public static void main(String[] args) {
        String s1 = "AxLwAqMdAgKota200";
        String s2 = "KxOwBqOdJg";
        String s1Even = "";
        String s1Odd = "";
        String s2Even = "";
        String s2Odd = "";
        boolean areEvenHalfsEqual = true;
        boolean areOddHalfsEqual = true;
        int shorterHalfLength;

        for (int i = 1; i <= s1.length(); i++) {
            if (i % 2 != 0) {
                s1Odd = s1Odd + s1.charAt(i - 1);
            } else {
                s1Even = s1Even + s1.charAt(i - 1);
            }
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (i % 2 != 0) {
                s2Odd = s2Odd + s2.charAt(i - 1);
            } else {
                s2Even = s2Even + s2.charAt(i - 1);
            }
        }

        System.out.println(s1Odd);
        System.out.println(s1Even);
        System.out.println(s2Odd);
        System.out.println(s2Even);

        if (s1Even.length() >= s2Even.length()) {
            shorterHalfLength = s2Even.length();
        } else {
            shorterHalfLength = s1Even.length();
        }
        for (int i = 0; (i < shorterHalfLength && areEvenHalfsEqual) == true; i++) {
            if (s1Even.charAt(i) == s2Even.charAt(i)) {
                areEvenHalfsEqual = true;
            } else {
                areEvenHalfsEqual = false;

            }
        }

        if (s1Odd.length() >= s2Odd.length()) {
            shorterHalfLength = s2Odd.length();
        } else {
            shorterHalfLength = s1Odd.length();
        }
        for (int i = 0; i < shorterHalfLength && areOddHalfsEqual == true; i++) {
            if (s1Odd.charAt(i) == s2Odd.charAt(i)) {
                areOddHalfsEqual = true;
            } else {
                areOddHalfsEqual = false;
            }
        }
        if (areEvenHalfsEqual || areOddHalfsEqual) {
            System.out.println("Half are equal!");
        }
    }

}

