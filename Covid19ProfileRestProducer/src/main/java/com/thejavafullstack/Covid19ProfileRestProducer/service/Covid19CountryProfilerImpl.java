package com.thejavafullstack.Covid19ProfileRestProducer.service;

import com.thejavafullstack.Covid19ProfileRestProducer.dao.Covid19ProfileDto;
import com.thejavafullstack.Covid19ProfileRestProducer.dao.Covid19ProfilerRepo;
import com.thejavafullstack.Covid19ProfileRestProducer.model.Covid19CountryProfile;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Covid19CountryProfilerImpl implements Covid19CountryProfiler {

    @Autowired
    Covid19ProfilerRepo covid19ProfilerRepo;

    @Override
    public List<Covid19CountryProfile> getAllCovid19CountryProfiles() {
        List<Covid19ProfileDto> profiles = new ArrayList();
        covid19ProfilerRepo.findAll().forEach(profiles::add);

        List customerList = new ArrayList<>();
        for (Covid19ProfileDto profileDto : profiles) {
            Covid19CountryProfile profile = new Covid19CountryProfile();
            BeanUtils.copyProperties(profileDto, profile);
            customerList.add(profile);
        }

        return customerList;
    }

    @Override
    public Covid19CountryProfile getCovid19CountryProfileByName(String countryName) {
        Optional covid19Profile = covid19ProfilerRepo.findById(countryName);
        Covid19CountryProfile profile = new Covid19CountryProfile();
        BeanUtils.copyProperties(covid19Profile.get(), profile);
        return profile;
    }

    @Override
    public Covid19CountryProfile createCovid19CountryProfile(Covid19CountryProfile covid19CountryProfile) {
        Covid19ProfileDto covid19ProfileDto = new Covid19ProfileDto();
        BeanUtils.copyProperties(covid19CountryProfile, covid19ProfileDto);
        covid19ProfileDto = covid19ProfilerRepo.save(covid19ProfileDto);
        Covid19CountryProfile profile = new Covid19CountryProfile();
        BeanUtils.copyProperties(covid19ProfileDto, profile);
        return profile;
    }

    @Override
    public void deleteCovid19CountryProfile(String countryName) {
        covid19ProfilerRepo.deleteById(countryName);
    }

    @Override
    public Covid19CountryProfile updateCovid19CountryProfile(Covid19CountryProfile covid19CountryProfile){
        Covid19ProfileDto covid19ProfileDto = new Covid19ProfileDto();
        BeanUtils.copyProperties(covid19CountryProfile, covid19ProfileDto);
        covid19ProfileDto = covid19ProfilerRepo.save(covid19ProfileDto);
        Covid19CountryProfile profile = new Covid19CountryProfile();
        BeanUtils.copyProperties(covid19ProfileDto, profile);
        return profile;
    }

    @Override
    public Covid19CountryProfile updateNumberOfCases(Integer numberOfCases, String countryName){
        Covid19CountryProfile covid19CountryProfile = getCovid19CountryProfileByName(countryName);
        covid19CountryProfile.setNumberOfCases(numberOfCases);
        Covid19ProfileDto covid19ProfileDto = new Covid19ProfileDto();
        BeanUtils.copyProperties(covid19CountryProfile, covid19ProfileDto);
        covid19ProfileDto = covid19ProfilerRepo.save(covid19ProfileDto);
        Covid19CountryProfile profile = new Covid19CountryProfile();
        BeanUtils.copyProperties(covid19ProfileDto, profile);
        return profile;
    }

    @Override
    public Covid19CountryProfile updateNumberOfDeaths(Integer numberOfDeaths, String countryName){
        Covid19CountryProfile covid19CountryProfile = getCovid19CountryProfileByName(countryName);
        covid19CountryProfile.setNumberOfDeaths(numberOfDeaths);
        Covid19ProfileDto covid19ProfileDto = new Covid19ProfileDto();
        BeanUtils.copyProperties(covid19CountryProfile, covid19ProfileDto);
        covid19ProfileDto = covid19ProfilerRepo.save(covid19ProfileDto);
        Covid19CountryProfile profile = new Covid19CountryProfile();
        BeanUtils.copyProperties(covid19ProfileDto, profile);
        return profile;
    }

    @Override
    public Covid19CountryProfile updateNumberOfRecoveries(Integer numberOfRecoveries, String countryName){
        Covid19CountryProfile covid19CountryProfile = getCovid19CountryProfileByName(countryName);
        covid19CountryProfile.setNumberOfRecoveries(numberOfRecoveries);
        Covid19ProfileDto covid19ProfileDto = new Covid19ProfileDto();
        BeanUtils.copyProperties(covid19CountryProfile, covid19ProfileDto);
        covid19ProfileDto = covid19ProfilerRepo.save(covid19ProfileDto);
        Covid19CountryProfile profile = new Covid19CountryProfile();
        BeanUtils.copyProperties(covid19ProfileDto, profile);
        return profile;
    }
}