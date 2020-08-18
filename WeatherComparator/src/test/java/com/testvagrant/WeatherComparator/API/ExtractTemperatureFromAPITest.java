package com.testvagrant.WeatherComparator.API;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import java.io.IOException;

import org.testng.annotations.Test;
import com.testvagrant.Utils.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import resources.InputData;

public class ExtractTemperatureFromAPITest extends Utils{

	static float temperature;
	
	//Method to return the Temperature of the City fetched from API test
	public float getWeatherThroughAPI(String City) throws IOException  {
		
		RestAssured.baseURI=Utils.extractFromPropertiesFile("API_URL");
		Response response = null;
		try {
		response=
		given().
			param("q",City).
			param("appid",Utils.extractFromPropertiesFile("API_Key")).
		when().
			get(Utils.extractFromPropertiesFile("API_Resource")).
		then().
			assertThat().statusCode(200).
			and().
			body("name",equalTo(City)).
			
		extract().response();
		}catch(AssertionError error) {
			System.out.println("City \""+City+"\" not found in openweathermap API. ");
		}
		
		temperature = parseJsonTogetValue(response,"main.temp");
		temperature = (float) Math.round(temperature-273.15);
					
		System.out.println("Fetched from API Testing :\nThe temperate of the City \""+City +"\" is "+ temperature + " in Celsius");
		return temperature;
	}
	
	//Test Method which will execute if this class is executed individually
	@Test(priority=1,dataProviderClass= InputData.class, dataProvider = "testData")
	public void getTemperature(String City) throws IOException{
		getWeatherThroughAPI(City);
	}
}
