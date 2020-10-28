package com.sAdamingo.course.lesson7;

import cz.kacirekj.connector.DataConnector;
import cz.kacirekj.connector.LoginConnector;
import cz.kacirekj.domain.GarminSession;
import cz.kacirekj.exception.HttpErrorGarminException;
import cz.kacirekj.exception.LoginGarminException;
import cz.kacirekj.exception.TooManyRequestsGarminException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class GarminDataGetter {


    public static void main(String[] args) throws IOException {
        // Login for GarminSession

        LoginConnector loginConnector = new LoginConnector();
        GarminSession garminSession = null;
        try {
            garminSession = loginConnector.login("ad.stelmach@gmail.com", "asdf");
        } catch (LoginGarminException e) {
            e.printStackTrace();
            return;
        } catch (TooManyRequestsGarminException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (HttpErrorGarminException e) {
            e.printStackTrace();
            return;
        }

// Fetch data from API

        DataConnector dataConnector = new DataConnector(garminSession);
        Map<String, Object> userSummary = dataConnector.getUserSummary(LocalDate.now().minusDays(1));
        Map<String, Object> heartRates = dataConnector.getHeartRates(LocalDate.now().minusDays(1));

        //System.out.println(userSummary);
        System.out.println(heartRates);
        //System.out.println(garminSession);

    }
}