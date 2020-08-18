package com.testvagrant.BasePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.testvagrant.Utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions actions;
	public static String browserName ;
	
	
	//Method to initialize the browser instance and setup
	public static void initialization() throws IOException {

		browserName = Utils.extractFromPropertiesFile("BROWSER");
		if(browserName.toLowerCase().equals("chrome")) {			

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browserName.toLowerCase().equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("enable-automation");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get(Utils.extractFromPropertiesFile("UI_URL"));
		
	}

	
}
