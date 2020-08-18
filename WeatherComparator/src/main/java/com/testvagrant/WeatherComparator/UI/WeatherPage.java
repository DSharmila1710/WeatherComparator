package com.testvagrant.WeatherComparator.UI;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testvagrant.BasePage.BasePage;

public class WeatherPage extends BasePage {

	public WeatherPage(WebDriver driver) throws IOException {
	}

	public String validateWeatherPage() {
		return driver.getTitle();
	}

	@FindBy(id="searchBox")
	WebElement CitySearchBox;
	
	WebElement CityCheckBox;
	WebElement CityDetailsBox;
	
	
	//Method to validate if the city is present in the MAP
	public boolean validateCityPresence(String City) {
		boolean isPresent=true;
		driver.navigate().refresh();
		try {
		CityCheckBox = driver.findElement(By.xpath("//label[@for=\""+City+"\"]//input"));
		}catch(Exception e) {
			isPresent=false;
			System.out.println("City \""+City+"\" not found in NDTV MAP. ");
		}		
		return isPresent;
	}
	
	//Method to validate if the city details grid is present in the MAP
	public boolean validateCityDetails(String City) {
		boolean isPresent=false;
		if(driver.findElement(By.className("leaflet-popup-content-wrapper")).isDisplayed()) {
			 isPresent=true;
		}
		return isPresent;
	}
	
	//method to return the Temperature of the City passed as input Parameter
	public String fetchTemperature(String City) throws InterruptedException {
		validateCityPresence(City);
		Thread.sleep(3000);
		WebElement cityTemperature;	
		
		if( CityCheckBox.getAttribute("checked")==null) {
			CityCheckBox.click();				
			cityTemperature = driver.findElement(By.xpath("//div[@title=\""+City+"\"]/div[@class=\"temperatureContainer\"]/span[@class=\"tempRedText\"]"));

		}else {
			cityTemperature = driver.findElement(By.xpath("//div[@title=\""+City+"\"]//div//span[@class=\"tempRedText\"]"));			
		}		
		cityTemperature.click();
		validateCityDetails(City);
		return cityTemperature.getText();
		}
	
}
