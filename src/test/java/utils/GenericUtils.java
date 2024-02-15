package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	
	WebDriver driver;
	HashMap<String, String> excelData;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}

	public HashMap<String, String> getExcelData(String paymentData) throws IOException
	{
		
		FileInputStream fis=new FileInputStream("src/test/resources/TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet workSheet=workbook.getSheet("TestData");
		excelData=new HashMap<String, String>();

		Iterator<Row> rn=workSheet.iterator();
		while(rn.hasNext())
		{
			Row r=rn.next();
			if(r.getCell(0).getStringCellValue().equalsIgnoreCase(paymentData))
			{
				
				excelData.put("firstName", r.getCell(1).toString());
				excelData.put("lastName", r.getCell(2).toString());
				excelData.put("country", r.getCell(3).toString());
				excelData.put("address1", r.getCell(4).toString());
				excelData.put("address2", r.getCell(5).toString());
				excelData.put("state", r.getCell(6).toString());
				excelData.put("pincode", r.getCell(7).toString());
				excelData.put("phone", r.getCell(8).toString());
				excelData.put("email", r.getCell(9).toString());
				excelData.put("city", r.getCell(10).toString());
				
			}
		}
		
		workbook.close();
		
		
		
		return excelData;
	}
	
	
}
