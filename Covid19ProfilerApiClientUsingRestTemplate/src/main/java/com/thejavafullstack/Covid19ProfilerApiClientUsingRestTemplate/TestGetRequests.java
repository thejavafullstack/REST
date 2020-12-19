package com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate;

import com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate.model.Covid19Profile;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

public class TestGetRequests {

    static final String API_URL = "http://localhost:8080/api/covid-19-profile";

    public static void main(String[] args) {

        System.out.println("**************************");
        System.out.println("Testing GetAllCountryProfiles ...");
        testGetAllCountryProfiles();
        System.out.println("**************************");

        System.out.println("**************************");
        System.out.println("Testing GetCountryProfile for SA ...");
        testGetCountryProfile("SA");
        System.out.println("**************************");
    }

    private static void testGetAllCountryProfiles(){
        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HttpEntity<Covid19Profile[]>: To get result as Covid19Profile[].
        HttpEntity request = new HttpEntity (headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<Covid19Profile[]> response = restTemplate.exchange(API_URL, HttpMethod.GET, request, Covid19Profile[].class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        // Status Code: 200
        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            Covid19Profile[] covid19Profiles = response.getBody();

            if (covid19Profiles != null) {
                System.out.println("Covid19 Country Profiles: ");
                System.out.println("__________________________");
                int index =1;
                for (Covid19Profile profile : covid19Profiles) {
                    System.out.println(index +") "+ profile.toString());
                    index++;
                }
                System.out.println("__________________________");
            }
        }

    }

    private static void testGetCountryProfile(String countryName){
        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL)
                .path("/"+countryName);

        // Send request with GET method, and Headers.
        ResponseEntity<Covid19Profile> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, request, Covid19Profile.class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        // Status Code: 200
        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            Covid19Profile covid19Profile = response.getBody();

            if (covid19Profile != null) {
                System.out.println("Covid19 Country Profile for "+countryName +" : ");
                System.out.println("__________________________");
                System.out.println(covid19Profile);
                System.out.println("__________________________");
            }
        }
    }
}