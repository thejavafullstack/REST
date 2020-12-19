package com.thejavafullstack.Covid19ProfileRestProducer.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Covid19ProfileDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String countryName;
    private Integer numberOfCases;
    private Integer numberOfDeaths;
    private Integer numberOfRecoveries;

    public Covid19ProfileDto(){

    }

    public Covid19ProfileDto(Long countryId, String countryName, Integer numberOfCases, Integer numberOfDeaths, Integer numberOfRecoveries) {
        this.countryName = countryName;
        this.numberOfCases = numberOfCases;
        this.numberOfDeaths = numberOfDeaths;
        this.numberOfRecoveries = numberOfRecoveries;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(Integer numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    public Integer getNumberOfDeaths() {
        return numberOfDeaths;
    }

    public void setNumberOfDeaths(Integer numberOfDeaths) {
        this.numberOfDeaths = numberOfDeaths;
    }

    public Integer getNumberOfRecoveries() {
        return numberOfRecoveries;
    }

    public void setNumberOfRecoveries(Integer numberOfRecoveries) {
        this.numberOfRecoveries = numberOfRecoveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Covid19ProfileDto)) return false;
        Covid19ProfileDto that = (Covid19ProfileDto) o;
        return Objects.equals(countryName, that.countryName) &&
                Objects.equals(numberOfCases, that.numberOfCases) &&
                Objects.equals(numberOfDeaths, that.numberOfDeaths) &&
                Objects.equals(numberOfRecoveries, that.numberOfRecoveries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, numberOfCases, numberOfDeaths, numberOfRecoveries);
    }

    @Override
    public String toString() {
        return "Covid19ProfileDto{" +
                "countryName='" + countryName + '\'' +
                ", numberOfCases=" + numberOfCases +
                ", numberOfDeaths=" + numberOfDeaths +
                ", numberOfRecoveries=" + numberOfRecoveries +
                '}';
    }
}