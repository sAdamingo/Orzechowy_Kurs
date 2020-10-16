package com.sAdamingo.course.lesson4;
import java.util.ArrayList;
import java.util.List;
public class Arrays {
    public static void main(String[] args) {
        // ....................[x][x][x][x][x]...........................
        // 1. tablica - nieprzerwany ciąg adresów w pamięci, który jest zarezerwowany
        // na pewną ilość obiektów, które tam trzymamy. W Javie mogą w tablicy być typy proste
        // 2. wektor (lista) - jest to po prostu lista elementów, która niekoniecznie jest obok siebie
        // w pamięci (chociaż często wektory bazują na tablicach, więc tak naprawdę są)
        // Nie trzeba znać jej rozmiaru podczas inicjalizacji. Może przechowywać w Javie tylko obiekty
        // Dlatego na razie używamy tylko Listy Stringów.
        String[] myArrayOfStrings = new String[10];
        // Zwykła pętla for do przypisywania wartości albo odczytywania
        for (int i = 0; i < myArrayOfStrings.length; i++) {
            myArrayOfStrings[i] = getMyString(i);
        }
        // Tzw. pętla for-each
        for (String stringInArray : myArrayOfStrings) {
            System.out.println(stringInArray);
        }
        char[] chars = new char[32];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('a' + i);
        }
        for (char c : chars) {
            System.out.println(c);
        }
        // deklaracja listy - więcej o tym, co oznaczają poszczególne rzeczy, będzie potem
        List<String> myList = getMyList();
        for (int i = 0; i < myList.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(myList.get(i));
            }
        }
        for (String s : myList) {
            System.out.println(s);
        }
        boolean areOfSameLength = areSameLength(myArrayOfStrings, myList);
        System.out.println("is my list the same size as my array? " + areOfSameLength);
    }
    // Metoda sprawdza czy tablica i lista są tej samej długości
    private static boolean areSameLength(String[] array, List<String> list) {
        return array.length == list.size();
    }
    private static List<String> getMyList() {
        List<String> myList = new ArrayList<>();
        myList.add("pierwszy element");
        myList.add("kolejny element");
        myList.add("jeszcze jeden");
        myList.add("i jeszcze jeden");
        return myList;
    }
    private static String getMyString(int i) {
        return "This is element number " + i;
    }
}
