package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractDataFromExcel {

	//Method to read test data from excel -- this method is passed to the Data Provider method "dataInput"
	public ArrayList<Object[]> extractCityList(String APIName) throws IOException {
		ArrayList<Object[]> Dataset = new ArrayList<Object[]>();
		
		FileInputStream fis = new FileInputStream("./test-data\\CityData.xlsx");
		
		XSSFWorkbook Workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = 	Workbook.getSheet(APIName);
		for(int R=1;R<=sheet.getLastRowNum();R++) {
			
			String City = sheet.getRow(R).getCell(1).getStringCellValue();
				Dataset.add(new Object[] {City});				
		}
		return Dataset;
	}
}
