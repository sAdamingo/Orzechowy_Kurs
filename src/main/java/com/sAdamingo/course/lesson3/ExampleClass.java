package com.sAdamingo.course.lesson3;

public class ExampleClass {
    public static void main(String[] args) {
/*        String s = "abcdef";
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        System.out.println(result);*/

        print(reverseString(getString()));
    }


    public static String getString() {
        return "Ziobro ty kurwo jebana! Przestań mi rodzinę prześladować!";
    }

    public static String reverseString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
