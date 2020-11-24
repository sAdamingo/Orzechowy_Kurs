package com.sAdamingo.course.Task18;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        DataBaseOperator<FakeUser> baza = null;
        try {
            baza = new DataBaseOperator<>("C:\\Users\\adam.stelmach\\Documents\\prywatne\\java\\Kurs Orzecha\\src\\main\\java\\com\\sAdamingo\\course\\Task18\\testowy.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(baza.getByJsonContainsWord("Giovani"));
        System.out.println(baza.findObjectId(new FakeUser("Kennith", "2dcbdd9b-76de-4657-aae3-b7441ddd800e", 664440126)));
        System.out.println(baza.findById(69));
    }
}
