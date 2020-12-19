package com.thejavafullstack.Covid19ProfileRestClient.client;

import com.thejavafullstack.Covid19ProfileRestClient.model.Covid19Profile;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface Covid19ProfilerApiClient {

    @RequestLine("GET")
    List<Covid19Profile> getAllProfiles();

    @RequestLine("GET /{country-name}")
    Covid19Profile getCountryProfile(@Param("country-name") String countryName);

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    Covid19Profile addCountryProfile(@Param("Covid19CountryProfile") Covid19Profile covid19Profile);

    @RequestLine("PUT /number-of-cases/{number-of-cases}/{country-name}")
    @Headers("Content-Type: application/json")
    Covid19Profile updateNumberOfCases(@Param("number-of-cases") int numberOfCases , @Param("country-name") String countryName);

    @RequestLine("PUT /number-of-recoveries/{number-of-recoveries}/{country-name}")
    @Headers("Content-Type: application/json")
    Covid19Profile updateNumberOfRecoveries(@Param("number-of-recoveries") int numberOfRecoveries , @Param("country-name") String countryName);

    @RequestLine("PUT /number-of-deaths/{number-of-deaths}/{country-name}")
    @Headers("Content-Type: application/json")
    Covid19Profile updateNumberOfDeaths(@Param("number-of-deaths") int numberOfDeaths , @Param("country-name") String countryName);

    @RequestLine("DELETE /{country-name}")
    @Headers("Content-Type: application/json")
    void removeCountryProfile( @Param("country-name") String countryName);
}