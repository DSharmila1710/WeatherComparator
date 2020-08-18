package com.testvagrant.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {	
	
	//Method to extract values from the properties file using the Key parameter
	public static String extractFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./env.properties");
		Properties prop = new Properties();
		prop.load(fis);	
		return prop.getProperty(key);
	}

	//Method to parse the Json Response to get the value using the Key parameter
	public static Float parseJsonTogetValue(Response response,String key) {
		JsonPath js= new JsonPath(response.asString());
		return js.get(key);
	}
	
}
