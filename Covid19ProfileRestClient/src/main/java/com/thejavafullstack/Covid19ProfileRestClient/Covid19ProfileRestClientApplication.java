package com.thejavafullstack.Covid19ProfileRestClient;

import com.thejavafullstack.Covid19ProfileRestClient.client.Covid19ProfilerApiClient;
import com.thejavafullstack.Covid19ProfileRestClient.model.Covid19Profile;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

import java.util.List;

public class Covid19ProfileRestClientApplication {

	static final String API_URL = "http://localhost:8080/api/covid-19-profile";

	public static void main(String[] args) {

		System.out.println("Testing GetAllCountryProfiles ...");
		testGetAllCountryProfiles();

		System.out.println("Testing GetCountryProfile for SA ...");
		testGetCountryProfile("SA");

		System.out.println("Testing UpdateNumberOfCases for SA ...");
		testUpdateNumberOfCases(6000,"SA");

		System.out.println("Testing UpdateNumberOfRecoveries for SA ...");
		testUpdateNumberOfRecoveries(5000,"SA");

		System.out.println("Testing UpdateNumberOfDeaths for SA ...");
		testUpdateNumberOfDeaths(1000,"SA");

		System.out.println("Testing AddCountryProfile ...");
		Covid19Profile covid19Profile = new Covid19Profile();
		covid19Profile.setCountryName("Canada");
		covid19Profile.setNumberOfCases(20000);
		covid19Profile.setNumberOfDeaths(500);
		covid19Profile.setNumberOfRecoveries(19500);
		//testAddCountryProfile(covid19Profile);

		System.out.println("Testing RemoveCountryProfile for SA ...");
		testRemoveCountryProfile("SA");
	}

	private static void testGetAllCountryProfiles(){
		Covid19ProfilerApiClient covid19ProfilerApiClient = createCovid19ProfilerApiClient(Covid19ProfilerApiClient.class, API_URL);

		List<Covid19Profile> covid19Profiles = covid19ProfilerApiClient.getAllProfiles();
		if (covid19Profiles != null) {
			System.out.println("__________________________");
			for (Covid19Profile covid19Profile :covid19Profiles) {
				System.out.println(covid19Profile);
			}
			System.out.println("__________________________");
		}
	}

	private static void testGetCountryProfile(String countryName){
		Covid19ProfilerApiClient covid19ProfilerApiClient = createCovid19ProfilerApiClient(Covid19ProfilerApiClient.class, API_URL);

		Covid19Profile covid19Profile = covid19ProfilerApiClient.getCountryProfile(countryName);
		if (covid19Profile != null) {
			System.out.println("Covid19 Country Profile for "+countryName +" : ");
			System.out.println("__________________________");
			System.out.println(covid19Profile);
			System.out.println("__________________________");
		}
	}

	private static void testUpdateNumberOfCases(int numberOfCases , String countryName){
		Covid19ProfilerApiClient covid19ProfilerApiClient = createCovid19ProfilerApiClient(Covid19ProfilerApiClient.class, API_URL);
		Covid19Profile covid19Profile = covid19ProfilerApiClient.updateNumberOfCases(numberOfCases,countryName);
		if (covid19Profile != null) {
			System.out.println("Updated Covid19 Country Profile for "+countryName +" : ");
			System.out.println("__________________________");
			System.out.println(covid19Profile);
			System.out.println("__________________________");
		}
	}

	private static void testUpdateNumberOfRecoveries(int numberOfRecoveries , String countryName){
		Covid19ProfilerApiClient covid19ProfilerApiClient = createCovid19ProfilerApiClient(Covid19ProfilerApiClient.class, API_URL);
		Covid19Profile covid19Profile = covid19ProfilerApiClient.updateNumberOfRecoveries(numberOfRecoveries,countryName);
		if (covid19Profile != null) {
			System.out.println("Updated Covid19 Country Profile for "+countryName +" : ");
			System.out.println("__________________________");
			System.out.println(covid19Profile);
			System.out.println("__________________________");
		}
	}

	private static void testUpdateNumberOfDeaths(int numberOfDeaths , String countryName){
		Covid19ProfilerApiClient covid19ProfilerApiClient = createCovid19ProfilerApiClient(Covid19ProfilerApiClient.class, API_URL);
		Covid19Profile covid19Profile = covid19ProfilerApiClient.updateNumberOfDeaths(numberOfDeaths,countryName);
		if (covid19Profile != null) {
			System.out.println("Updated Covid19 Country Profile for "+countryName +" : ");
			System.out.println("__________________________");
			System.out.println(covid19Profile);
			System.out.println("__________________________");
		}
	}

	private static void testAddCountryProfile(Covid19Profile covid19Profile){
		Covid19ProfilerApiClient covid19ProfilerApiClient = createCovid19ProfilerApiClient(Covid19ProfilerApiClient.class, API_URL);
		Covid19Profile newCovid19Profile = covid19ProfilerApiClient.addCountryProfile(covid19Profile);
		if (newCovid19Profile != null) {
			System.out.println("New Covid19 Country Profile :");
			System.out.println("__________________________");
			System.out.println(newCovid19Profile);
			System.out.println("__________________________");
		}
	}


	private static void testRemoveCountryProfile(String  countryName){
		Covid19ProfilerApiClient covid19ProfilerApiClient = createCovid19ProfilerApiClient(Covid19ProfilerApiClient.class, API_URL);
		covid19ProfilerApiClient.removeCountryProfile(countryName);
	}

	private static <T> T createCovid19ProfilerApiClient(Class<T> type, String uri) {
		return Feign.builder()
				.client(new OkHttpClient())
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger(type))
				.logLevel(Logger.Level.FULL)
				.target(type, uri);
	}
}