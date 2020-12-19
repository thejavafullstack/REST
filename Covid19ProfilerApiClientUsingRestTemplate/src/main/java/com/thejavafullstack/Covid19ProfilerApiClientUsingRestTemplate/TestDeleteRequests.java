package com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate;

import com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate.model.Covid19Profile;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class TestDeleteRequests {

    static final String API_URL = "http://localhost:8080/api/covid-19-profile";

    public static void main(String[] args) {

        String countryName = "Malaysia";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request
        HttpEntity requestBody = new HttpEntity(countryName, headers);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL)
                .path("/"+countryName);

        // Send request with DELETE method and get the deleted object as response
        ResponseEntity<Covid19Profile> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.DELETE, requestBody, Covid19Profile.class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        // Status Code: 204
        if (statusCode == HttpStatus.NO_CONTENT) {
            System.out.println("(Client side) Covid19Profile for " + countryName + " deleted successfully.");

        }else{
            System.err.println("(Client side) Oops ... There was some problem!!");
        }
    }
}