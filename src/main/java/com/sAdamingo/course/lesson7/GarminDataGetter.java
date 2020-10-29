package com.sAdamingo.course.lesson7;

import cz.kacirekj.connector.DataConnector;
import cz.kacirekj.connector.LoginConnector;
import cz.kacirekj.domain.GarminSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class GarminDataGetter {

    public static void main(String[] args) {
        Scanner skn = new Scanner(System.in);
        System.out.println("Please enter your e-mail: ");
        String email = skn.nextLine();
        System.out.println("Enter password: ");
        String password = skn.nextLine();
        LoginConnector loginConnector = new LoginConnector();
        GarminSession garminSession = null;

        try {
            garminSession = loginConnector.login(email, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        DataConnector dataConnector = new DataConnector(garminSession);
        Map<String, Object> heartRates = null;

        try {
            heartRates = dataConnector.getHeartRates(LocalDate.now().minusDays(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(heartRates);
    }
}