package com.testvagrant.WeatherComparator.UI;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testvagrant.BasePage.BasePage;

import resources.InputData;

public class ExtractTemperatureFromUITest extends BasePage {

	static WeatherPage weatherPage;	
	static Float temperature;
	
	//Test Method which will execute if this class is executed individually
	@Test(priority=1,dataProviderClass= InputData.class, dataProvider = "testData")
	public void getTemperature(String City) throws IOException, InterruptedException{
		getWeatherThroughUI(City);
	}
		
	//Method to return the Temperature of the City fetched from UI test
	public Float getWeatherThroughUI(String City) throws IOException, InterruptedException { 
			initialization();	
			HomePage homepage= new HomePage(driver);		
			weatherPage= homepage.navigate();
			String temp = weatherPage.fetchTemperature(City).replaceAll("[^0-9]", "");
			temperature = Float.parseFloat(temp);
			System.out.println("Fetched from UI  Testing :\nThe temperate of the City \""+City +"\" is "+ temperature+" in Celsius");
			driver.close();
			return temperature;			
	}
	
}
