package com.sAdamingo.course.dupadupa;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Jakkolwiek {
    public static void main(String[] args) {

        List<String> lista = List.of("ab", "cs", "tibia");
        Set<Integer> collect = lista.stream()
                .map(s -> s + "dupa")
                .map(String::length)
                .filter(i -> i > 1)
                .collect(Collectors.toSet());
        collect.forEach(System.out::println);

/*        Set<Integer> set = new HashSet<>();
        for (String s : lista) {
            int length = s.length();
            if (length > 1) {
                set.add(length);
            }
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }*/
    }
}
