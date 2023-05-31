package dDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excelsheetdata {

	public static void main(String[] args) throws IOException {
		
		// FileInputStream fisp = new FileInputStream("./src/test/resources/testdata.xlsx");
	//	Properties p = new Properties();
	//	p.load(fisp);
		
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	 Sheet sheet = wb.getSheet("Sheet1");
		
		//String URL = p.getProperty("url");
		//String BROWSER = p.getProperty("browser");
	

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		for(int i=0;i<links.size();i++)
		{
			String linkName=links.get(i).getAttribute("href");
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			
			cell.setCellValue(linkName);
		}
		     FileOutputStream fout = new FileOutputStream("./src/test/resources/testdata.xlsx");
		wb.write(fout);
		wb.close();
	
	}
	
	
	

}
