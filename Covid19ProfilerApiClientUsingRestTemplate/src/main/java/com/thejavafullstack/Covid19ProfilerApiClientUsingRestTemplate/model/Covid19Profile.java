package com.thejavafullstack.Covid19ProfilerApiClientUsingRestTemplate.model;

import java.io.Serializable;

public class Covid19Profile implements Serializable {
        private static final long serialVersionUID = 1L;

        private String countryName;
        private Integer numberOfCases;
        private Integer numberOfDeaths;
        private Integer numberOfRecoveries;

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

        public Covid19Profile() {

        }
        public Covid19Profile(String countryName, Integer numberOfCases, Integer numberOfDeaths, Integer numberOfRecoveries) {
                this.countryName = countryName;
                this.numberOfCases = numberOfCases;
                this.numberOfDeaths = numberOfDeaths;
                this.numberOfRecoveries = numberOfRecoveries;
        }

        @Override
        public String toString() {
                return "countryName='" + countryName + '\'' +
                        ", numberOfCases=" + numberOfCases +
                        ", numberOfDeaths=" + numberOfDeaths +
                        ", numberOfRecoveries=" + numberOfRecoveries;
        }
}