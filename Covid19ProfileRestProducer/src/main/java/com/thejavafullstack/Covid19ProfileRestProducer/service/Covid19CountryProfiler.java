package com.thejavafullstack.Covid19ProfileRestProducer.service;

import com.thejavafullstack.Covid19ProfileRestProducer.model.Covid19CountryProfile;

import java.util.List;

public interface Covid19CountryProfiler {

    public List<Covid19CountryProfile> getAllCovid19CountryProfiles();

    public Covid19CountryProfile getCovid19CountryProfileByName(String countryName);

    public Covid19CountryProfile createCovid19CountryProfile(Covid19CountryProfile covid19CountryProfile);

    public void deleteCovid19CountryProfile(String countryName);

    public Covid19CountryProfile updateCovid19CountryProfile(Covid19CountryProfile covid19CountryProfile);

    public Covid19CountryProfile updateNumberOfCases(Integer numberOfCases, String countryName);

    public Covid19CountryProfile updateNumberOfDeaths(Integer numberOfDeaths, String countryName);

    public Covid19CountryProfile updateNumberOfRecoveries(Integer numberOfRecoveries, String countryName);
}