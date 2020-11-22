package com.sAdamingo.course.Task18;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JSonReader {
    private String path = "C:\\Users\\adam.stelmach\\Documents\\prywatne\\java\\Kurs Orzecha\\src\\main\\java\\com\\sAdamingo\\course\\Task18\\testowy.json";

    public List<FakeUser> readJSONFileFullOfFakeUsers() {

        List<FakeUser> fakes = new ArrayList<>();
        try {
            fakes = getListOfFakeUsersFromJSON(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fakes;
    }

    public static List<FakeUser> getListOfFakeUsersFromJSON(String path) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject wholeJSON = (JSONObject) obj;
        JSONArray users = (JSONArray) wholeJSON.get("users");
        List<FakeUser> fakeUsers = new ArrayList<>();
        return fakeUsers = (List<FakeUser>) users.stream().map(userJson -> new FakeUser((JSONObject) userJson)).collect(Collectors.toList());
    }

    public void addFakeUserToFile(String newUserId) throws IOException, ParseException {
        //Should've implemented case if new id already existed in file
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject wholeJSON = (JSONObject) obj;
        JSONArray users = (JSONArray) wholeJSON.get("users");
        List<FakeUser> fakeUsers = new ArrayList<>();
        fakeUsers.add(new FakeUser(newUserId));
        JSONObject userList = new JSONObject();
        userList.put("users", users);
        FileWriter fr = new FileWriter(path);
        try {
            fr.write(userList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fr.flush();
        fr.close();
    }

    public void deleteFakeUserFromFile(String UserId) throws IOException, ParseException {
        //Should've implemented case if new id already existed in file
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject wholeJSON = (JSONObject) obj;
        JSONArray users = (JSONArray) wholeJSON.get("users");
        List<FakeUser> fakeUsers = new ArrayList<>();
        fakeUsers.stream().filter(s -> s.getId().equals(UserId)).collect(Collectors.toList());
        JSONObject userList = new JSONObject();
        userList.put("users", users);
        FileWriter fr = new FileWriter(path);
        try {
            fr.write(userList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fr.flush();
        fr.close();
    }

    private static void parseUsersObject(JSONObject users) {
        String userId = (String) users.get("id");
        System.out.println(userId);

        String userName = (String) users.get("userName");
        System.out.println(userName);

        String password = (String) users.get("password");
        System.out.println(password);

        Long phoneNumber = (Long) users.get("Phone number");
        System.out.println(phoneNumber);
    }
}