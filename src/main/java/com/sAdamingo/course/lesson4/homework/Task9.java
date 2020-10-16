package com.sAdamingo.course.lesson4.homework;

import java.util.ArrayList;
import java.util.List;

public class Task9 {
    public static void main(String[] args) {
        String[] stringArray = getStringArray(10);
        List<String> stringList = getStringList(4);
        boolean haveSameElements = haveSameElements(stringArray, stringList);
        printComparisonResults(haveSameElements);
    }

    private static void printComparisonResults(boolean haveSameElements) {
        System.out.println(haveSameElements ? "Have same elements!" : "Do not have same elements ;(");
    }

    private static boolean haveSameElements(String[] stringArray, List<String> stringList) {
        boolean haveSameElements = true;
        for (int i = 0; i < Math.min(stringArray.length, stringList.size()); i++) {
            if (!stringArray[i].equals(stringList.get(i))) {
                haveSameElements = false;
                break;
            }
        }
        return haveSameElements;
    }

    private static List<String> getStringList(int stringListSize) {
        List<String> stringList = new ArrayList<>();
        int counter = 0;
        while (counter < stringListSize) {
            stringList.add(counter + " plus " + (counter + 7)
                    + " equals " + (counter + counter + 7));
            counter++;
        }
        return stringList;
    }

    private static String[] getStringArray(int stringArraySize) {
        String[] stringArray = new String[stringArraySize];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = i + " plus " + (i + 7)
                    + " equals " + (i + i + 7);
        }
        return stringArray;
    }
}
