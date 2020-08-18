package com.testvagrant.WeatherComparator.UI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.testvagrant.BasePage.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);	
	}
	
	//Method to navigate to Weather Page from Home Page url
	public WeatherPage navigate() throws IOException {
		handleBreakingNewsAlert();
		WebElement more = driver.findElement(By.id("h_sub_menu"));
		more.click();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement weatherPageLink=driver.findElement(By.xpath("//a[contains(text(),\"WEATHER\")]"));
		weatherPageLink.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new WeatherPage(driver);
	}
	
	//Method to handle breaking news alert message in the web page
	public void handleBreakingNewsAlert() {
		if(driver.findElement(By.className("notnow")).isDisplayed()) {
			driver.findElement(By.className("notnow")).click();
		}
	}
}
