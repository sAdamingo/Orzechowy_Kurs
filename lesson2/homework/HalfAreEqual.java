package com.sAdamingo.course.lesson2.homework;

public class HalfAreEqual {
    public static void main(String[] args) {
        String s1 = "AxLwAqMdAgKota200";
        String s2 = "KxOwBqOdJg";
        boolean areEqualOdd = true;
        boolean areEqualEven = true;
        for (int i = 1; i < (s1.length() < s2.length() ? s1.length() : s2.length()); i = i + 2) {
            if (s1.charAt(i - 1) != s2.charAt(i - 1) && areEqualOdd) {
                areEqualOdd = false;
            }
            if (s1.charAt(i) != s2.charAt(i) && areEqualEven) {
                areEqualEven = false;
            }
        }
        if (areEqualEven || areEqualOdd) {
            System.out.println("Half is equal!");
        }
    }
}
