package com.sAdamingo.course.Task18;

import com.github.javafaker.Faker;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.json.simple.JSONObject;

import java.util.Random;
import java.util.UUID;

public class FakeUser {
    private String id;
    private String name;
    private String password;
    private Long phoneNumber;


    public FakeUser(String id) {
        this.id = id;
        Faker names = new Faker();
        this.name = names.name().firstName();
        this.password = UUID.randomUUID().toString();
        Random rnd = new Random();
        this.phoneNumber = new RandomDataGenerator().nextLong(600000000, 699999999);
    }

    public FakeUser(JSONObject fakeUser) {
        this.id = (String) fakeUser.get("id");
        this.name = (String) fakeUser.get("userName");
        this.password = (String) fakeUser.get("password");
        this.phoneNumber = (Long) fakeUser.get("phone number");
    }

    public String getName() {
        return name;
    }

    public String printUserData() {
        return "id: " + id + "\n" + "name: " + name + "\n" + "password: " + password + "\n" + "phone number: " + phoneNumber;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();

        sb.append("{");

        sb.append(JSONObject.escape("id"));
        sb.append(":");
        sb.append("\"" + JSONObject.escape(id) + "\"");

        sb.append(JSONObject.escape("userName"));
        sb.append(":");
        sb.append("\"" + JSONObject.escape(name) + "\"");

        sb.append(",");

        sb.append(JSONObject.escape("password"));
        sb.append(":");
        sb.append("\"" + JSONObject.escape(password) + "\"");

        sb.append(",");

        sb.append(JSONObject.escape("phone number"));
        sb.append(":");
        sb.append(phoneNumber);

        sb.append("}");

        return sb.toString();
    }

    public JSONObject toJSONObject() {
        JSONObject user = new JSONObject();
        user.put("id", id);
        user.put("userName", name);
        user.put("password", password);
        user.put("phone number", phoneNumber);
        return user;
    }

    public static void main(String[] args) {

        System.out.println(new FakeUser("1").toJSONString());
    }

    public String getId() {
        return id;
    }
}