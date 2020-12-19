package com.thejavafullstack.Covid19ProfileRestProducer.controller;

import com.thejavafullstack.Covid19ProfileRestProducer.model.Covid19CountryProfile;
import com.thejavafullstack.Covid19ProfileRestProducer.service.Covid19CountryProfiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/covid-19-profile")
public class Covid19ProfilerApi {

    @Autowired
    Covid19CountryProfiler covid19CountryProfiler;


    /**
     * Get all the Covid19Profiles available in the underlying system
     * @return list of Covid19Profiles
     */
    @GetMapping
    public ResponseEntity<List<Covid19CountryProfile>> getAllCovid19Profiles() {
        List <Covid19CountryProfile> customers = covid19CountryProfiler.getAllCovid19CountryProfiles();
        return new ResponseEntity < >(customers, HttpStatus.OK);
    }

    /**
     * Create a Covid19Profile with the system.This end point accepts Covid19Profile information in
     * the json format.It will create and send back the data to the Covid19Profiler API.
     * @param Covid19CountryProfile
     * @return newly created Covid19Profile
     */
    @PostMapping(value = "")
    //@RequestMapping(path = "/" , method = RequestMethod.POST)
    public ResponseEntity <Covid19CountryProfile> createCovid19Profile(@RequestBody Covid19CountryProfile Covid19CountryProfile) {
        final Covid19CountryProfile covid19CountryProfile = covid19CountryProfiler.createCovid19CountryProfile(Covid19CountryProfile);
        return new ResponseEntity < >(covid19CountryProfile, HttpStatus.CREATED);
    }

    /**
     * Update a Covid19Profile with the system.This end point accepts Covid19Profile information in
     * the json format.It will update and send back the data to the Covid19Profiler API.
     * @param Covid19CountryProfile
     * @return newly updated Covid19Profile
     */
    @PutMapping (value = "")
    // @RequestMapping(path = "/" , method = RequestMethod.PUT)
    public ResponseEntity <Covid19CountryProfile> updateCovid19Profile(@RequestBody Covid19CountryProfile Covid19CountryProfile) {
        final Covid19CountryProfile covid19CountryProfile = covid19CountryProfiler.updateCovid19CountryProfile(Covid19CountryProfile);
        return new ResponseEntity < >(covid19CountryProfile, HttpStatus.CREATED);
    }

    /**
     * Update the number of cases under a Covid19Profile with the system.This end point accepts the number of cases and a name of the country in
     * the json format.It will update and send back the data to the Covid19Profiler API.
     * @param numberOfCases
     * @param countryName
     * @return newly updated Covid19Profile
     */
    @PutMapping (path = "/number-of-cases/{number-of-cases}/{country-name}")
    //@RequestMapping(path = "/number-of-cases" , method = RequestMethod.PUT)
    public ResponseEntity <Covid19CountryProfile> updateNumberOfCases(@PathVariable(value = "number-of-cases") Integer numberOfCases, @PathVariable(value = "country-name") String countryName) {
        final Covid19CountryProfile covid19CountryProfile = covid19CountryProfiler.updateNumberOfCases(numberOfCases,countryName);
        return new ResponseEntity < >(covid19CountryProfile, HttpStatus.CREATED);
    }

    /**
     * Update the number of deaths under a Covid19Profile with the system.This end point accepts the number of deaths and a name of the country in
     * the json format.It will update and send back the data to the Covid19Profiler API.
     * @param numberOfDeaths
     * @param countryName
     * @return newly updated Covid19Profile
     */
    @PutMapping (value = "/number-of-deaths/{number-of-deaths}/{country-name}")
    //@RequestMapping(path = "/number-of-deaths" , method = RequestMethod.PUT)
    public ResponseEntity <Covid19CountryProfile> updateNumberOfDeaths(@PathVariable(
           value = "number-of-deaths") Integer numberOfDeaths, @PathVariable(value = "country-name") String countryName) {
        final Covid19CountryProfile covid19CountryProfile = covid19CountryProfiler.updateNumberOfDeaths(numberOfDeaths,countryName);
        return new ResponseEntity < >(covid19CountryProfile, HttpStatus.CREATED);
    }

    /**
     * Update the number of recoveries under a Covid19Profile with the system.This end point accepts the number of recoveries and a name of the country in
     * the json format.It will update and send back the data to the Covid19Profiler API.
     * @param numberOfRecoveries
     * @param countryName
     * @return newly updated Covid19Profile
     */
    @PutMapping (value = "/number-of-recoveries/{number-of-recoveries}/{country-name}")
    //@RequestMapping(path = "/number-of-recoveries" , method = RequestMethod.PUT)
    public ResponseEntity <Covid19CountryProfile> updateNumberOfRecoveries(@PathVariable(value = "number-of-recoveries") Integer numberOfRecoveries, @PathVariable(value = "country-name") String countryName) {
        final Covid19CountryProfile covid19CountryProfile = covid19CountryProfiler.updateNumberOfRecoveries(numberOfRecoveries,countryName);
        return new ResponseEntity < >(covid19CountryProfile, HttpStatus.CREATED);
    }

    /**
     * Deletes the Covid19Profile from the system. Client will pass the ID for the Covid19Profile and this
     * endpoint will remove Covid19Profile from the system if found.
     * @param countryName
     * @return
     */
    @DeleteMapping(value = "/{country-name}")
    //@RequestMapping(path = "/{country-name}" , method = RequestMethod.DELETE)
    public ResponseEntity < String > deleteCovid19Profile(@PathVariable(value = "country-name") String countryName) {
        covid19CountryProfiler.deleteCovid19CountryProfile(countryName);
        return new ResponseEntity < >(HttpStatus.NO_CONTENT);
    }

    /**
     * Get the Covid19Profile detail based on the name of the country passed by the client API.
     * @param countryName
     * @return Covid19Profile detail
     */
    @GetMapping(value = "/{country-name}")
    //@RequestMapping(path = "/{country-name}" , method = RequestMethod.GET)
    public ResponseEntity <Covid19CountryProfile> getCovid19Profile(@PathVariable(value = "country-name") String countryName) {
        Covid19CountryProfile Covid19CountryProfile = covid19CountryProfiler.getCovid19CountryProfileByName(countryName);
        return new ResponseEntity < >(Covid19CountryProfile, HttpStatus.OK);
    }
}