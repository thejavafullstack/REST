package com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate;

import com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate.model.Covid19Profile;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestPutRequests {

    static final String API_URL = "http://localhost:8080/api/covid-19-profile";

    public static void main(String[] args) {

        String countryName = "SA";
        Covid19Profile covid19ProfileToBeUpdated = new Covid19Profile();
        covid19ProfileToBeUpdated.setCountryName("SA");
        covid19ProfileToBeUpdated.setNumberOfCases(2000);
        covid19ProfileToBeUpdated.setNumberOfDeaths(100);
        covid19ProfileToBeUpdated.setNumberOfRecoveries(1900);

        System.out.println("**************************");
        System.out.println("Testing UpdateCountryProfile ...");
        testUpdateCountryProfile(covid19ProfileToBeUpdated);
        System.out.println("**************************");

        System.out.println("**************************");
        System.out.println("Testing UpdateNumberOfCases ...");
        testUpdateNumberOfCases(30000,"India");
        System.out.println("**************************");

        System.out.println("**************************");
        System.out.println("Testing UpdateNumberOfDeaths ...");
        testUpdateNumberOfDeaths(1000, "India");
        System.out.println("**************************");

        System.out.println("**************************");
        System.out.println("Testing UpdateNumberOfRecoveries ...");
        testUpdateNumberOfRecoveries(9000,"India");
        System.out.println("**************************");


    }

    private static void testUpdateCountryProfile(Covid19Profile covid19ProfileToBeUpdated){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request
        HttpEntity<Covid19Profile> requestBody = new HttpEntity<>(covid19ProfileToBeUpdated, headers);

        // Send request with PUT method and get the updated object as response
        ResponseEntity<Covid19Profile> response =  restTemplate.exchange(API_URL, HttpMethod.PUT, requestBody, Covid19Profile.class);

        Covid19Profile updatedCovid19Profile = response.getBody();

        if (updatedCovid19Profile != null) {
            System.out.println("*******************************************");
            System.out.println("(Client side) Covid19Profile after update: ");
            System.out.println(updatedCovid19Profile);
            System.out.println("*******************************************");
        }

    }

    private static void testUpdateNumberOfCases(int numberOfCases, String countryName){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request
        HttpEntity request = new HttpEntity(headers);

        // Send request with PUT method and get the updated object as response
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL)
                .path("/number-of-cases/"+numberOfCases+"/"+countryName);

        // Send request with DELETE method and get the deleted object as response
        ResponseEntity<Covid19Profile> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.PUT, request, Covid19Profile.class);

        Covid19Profile updatedCovid19Profile = response.getBody();

        if (updatedCovid19Profile != null) {
            System.out.println("*******************************************");
            System.out.println("(Client side) Covid19Profile after update: ");
            System.out.println(updatedCovid19Profile);
            System.out.println("*******************************************");
        }

    }

    private static void testUpdateNumberOfDeaths(int numberOfDeaths, String countryName){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request
        HttpEntity request = new HttpEntity(headers);

        // Send request with PUT method and get the updated object as response
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL)
                .path("/number-of-deaths/"+numberOfDeaths+"/"+countryName);

        // Send request with DELETE method and get the deleted object as response
        ResponseEntity<Covid19Profile> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.PUT, request, Covid19Profile.class);

        Covid19Profile updatedCovid19Profile = response.getBody();

        if (updatedCovid19Profile != null) {
            System.out.println("*******************************************");
            System.out.println("(Client side) Covid19Profile after update: ");
            System.out.println(updatedCovid19Profile);
            System.out.println("*******************************************");
        }

    }

    private static void testUpdateNumberOfRecoveries(int numberOfRecoveries, String countryName){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request
        HttpEntity request = new HttpEntity(headers);

        // Send request with PUT method and get the updated object as response
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL)
                .path("/number-of-recoveries/"+numberOfRecoveries+"/"+countryName);

        // Send request with DELETE method and get the deleted object as response
        ResponseEntity<Covid19Profile> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.PUT, request, Covid19Profile.class);

        Covid19Profile updatedCovid19Profile = response.getBody();

        if (updatedCovid19Profile != null) {
            System.out.println("*******************************************");
            System.out.println("(Client side) Covid19Profile after update: ");
            System.out.println(updatedCovid19Profile);
            System.out.println("*******************************************");
        }

    }
}