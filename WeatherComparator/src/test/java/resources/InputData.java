package resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.testvagrant.Utils.Utils;

public class InputData extends Utils {
	
	//Method to pass input to the test methods
	@DataProvider(name="testData")	
	public static Iterator<Object[]> dataInput() throws IOException{
		ExtractDataFromExcel excel = new ExtractDataFromExcel();
		ArrayList<Object[]> data ;
		data = excel.extractCityList("getTemperature");
		return data.iterator();
	}
	

}
