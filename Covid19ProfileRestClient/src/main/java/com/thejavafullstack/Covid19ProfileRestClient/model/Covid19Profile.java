package com.thejavafullstack.Covid19ProfileRestClient.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Builder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Covid19Profile implements Serializable {
        private static final long serialVersionUID = 1L;
        private String  countryName;
        private Integer numberOfCases;
        private Integer numberOfDeaths;
        private Integer numberOfRecoveries;

        @Override
        public String toString() {
                return "countryName='" + countryName + '\'' +
                        ", numberOfCases=" + numberOfCases +
                        ", numberOfDeaths=" + numberOfDeaths +
                        ", numberOfRecoveries=" + numberOfRecoveries;
        }
}