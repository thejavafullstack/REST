package com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate;

import com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate.model.Covid19Profile;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class TestPostRequests {

    static final String API_URL = "http://localhost:8080/api/covid-19-profile";

    public static void main(String[] args) {

        String countryName = "Malaysia";

        Covid19Profile newCountryProfile = new Covid19Profile();
        newCountryProfile.setCountryName(countryName);
        newCountryProfile.setNumberOfCases(2500);
        newCountryProfile.setNumberOfDeaths(500);
        newCountryProfile.setNumberOfRecoveries(2000);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request
        HttpEntity<Covid19Profile> requestBody = new HttpEntity<>(newCountryProfile, headers);

        // Send request with PUT method and get the updated object as response
        ResponseEntity<Covid19Profile> response =  restTemplate.exchange(API_URL, HttpMethod.POST, requestBody, Covid19Profile.class);

        Covid19Profile covid19Profile = response.getBody();

        if (covid19Profile != null) {
            System.out.println("*******************************************");
            System.out.println("(Client side) New Covid19Profile after Adding: ");
            System.out.println(covid19Profile.toString());
            System.out.println("*******************************************");
        }
    }
}