package com.sAdamingo.course.Lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        createAndSortList();
        createAndSortArray();
    }

    private static void createAndSortArray() {
        int[] array = new int[]{32, 5, 4124, 4, 36, 5465, 24, 32, 432, 4, 32};
        Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + ", ");
        }
    }

    private static void createAndSortList() {
        List<String> myList = new ArrayList<>();
        myList.add("ala");
        myList.add("ma");
        myList.add("kota");
        Collections.sort(myList);
        for (String s : myList) {
            System.out.println(s);
        }
    }
}