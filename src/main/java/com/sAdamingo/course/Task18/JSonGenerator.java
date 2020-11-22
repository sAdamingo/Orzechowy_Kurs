package com.sAdamingo.course.Task18;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSonGenerator {
    public String path = "C:\\Users\\adam.stelmach\\Documents\\prywatne\\java\\Kurs Orzecha\\src\\main\\java\\com\\sAdamingo\\course\\Task18\\testowy.json";

    public void main(String[] args) throws IOException {

        String usersJSON = generateRandomUsersJSONString(1000);
        System.out.println(usersJSON);
        writeToFile(usersJSON, path);
    }

    public void writeToFile(String usersJSON, String JSONString) throws IOException {
        FileWriter fr = new FileWriter(path);
        try {
            fr.write(JSONString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fr.flush();
        fr.close();
    }

    public static String generateRandomUsersJSONString(int numberOfUsers) {
        JSONArray users = new JSONArray();
        for (int i = 0; i < numberOfUsers; i++) {
            users.add(new FakeUser(Integer.toString(i + 1)).toJSONObject());
        }
        JSONObject userList = new JSONObject();
        userList.put("users", users);

        return userList.toString();
    }
}
