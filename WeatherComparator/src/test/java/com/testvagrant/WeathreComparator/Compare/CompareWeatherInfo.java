package com.testvagrant.WeathreComparator.Compare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.testvagrant.Utils.Utils;
import com.testvagrant.WeatherComparator.API.ExtractTemperatureFromAPITest;
import com.testvagrant.WeatherComparator.UI.ExtractTemperatureFromUITest;

import resources.InputData;

public class CompareWeatherInfo extends Utils {

	static ExtractTemperatureFromAPITest api = new ExtractTemperatureFromAPITest();
	static ExtractTemperatureFromUITest ui = new ExtractTemperatureFromUITest();
		
	static float tempUsingAPI;
	static float tempUsingUI;
			
	//Method to compare the temperature fetched from the UI and the API tests
	@Test(priority=1,dataProviderClass= InputData.class, dataProvider = "testData")
	public static void displayOutput(String City) throws IOException, InterruptedException {		
		tempUsingUI = ui.getWeatherThroughUI(City);
		tempUsingAPI = api.getWeatherThroughAPI(City);
		CompareWeatherLogic CWL = new CompareWeatherLogic();
		FileReader fis = new FileReader("./Variance.txt");
		BufferedReader bufferedReader = new BufferedReader(fis);
		
		int TemperatureVariance = 0;
		try {
		TemperatureVariance = Integer.parseInt(bufferedReader.readLine());

		bufferedReader.close();

		}catch(Exception e) {
			System.out.println("Only whole numbers are accepted for the variance field");
		}
		
		System.out.println(CWL.variance(tempUsingAPI, tempUsingUI)<=TemperatureVariance ? "Variance is under the mentioned range" : "variance is not under the mentioned range");
		
		
	}
	
	

}
