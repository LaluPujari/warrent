package dDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
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

public class WriteExcelsheetData {

	public static void main(String[] args) throws IOException {
		
		/*WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		       Properties p = new   Properties();
		       p.load(fis);
		       
		      String Url = p.getProperty("url");
		      driver.get(Url); */
		
		      // get data from amazon and write in excel sheet
		      FileInputStream fis1 = new FileInputStream("./src/test/resources/amazontestdata.xlsx");
		     Workbook wb = WorkbookFactory.create(fis1);
		     
		    // Sheet sheet = wb.createSheet("amazondata");
		     
		         Sheet sheet = wb.getSheet("amazondata");
		            
		      
		 /*     List<WebElement> pnames = driver.findElements(By.xpath("//h2[@class='a-color-base headline truncate-2line']"));
		       
		for(int i=0;i<pnames.size();i++)
		{
			   Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			String productnames = pnames.get(i).getText();
			
			cell.setCellValue(productnames);
		}   */
		         
		         
		         // read the data from excel
		        int lastrow = sheet.getLastRowNum();
		        boolean b=false;
		        for(int j=0; j<lastrow; j++)
		        {
		        	Row rows = sheet.getRow(j);
		        	Cell cells = rows.getCell(0);
		        	String Adata = cells.getStringCellValue();
		        	System.out.println(Adata);
		        	String pdata = "Up to 60% off | Tools & home improvement";
		        	
		        	if(Adata.equalsIgnoreCase( pdata))
		        	{
		        		
		        		System.out.println("******************************************");
		        		
		        		System.out.println(pdata+"  is presenting the list ");
		        		b=true;
		        		break;
		        	  }
		        }
		        if(!b) {
		        	System.out.println("not present");
		        }
		         
		 FileOutputStream fout = new FileOutputStream("./src/test/resources/amazontestdata.xlsx");
		
		wb.write(fout);
		wb.close();
		
		
		
		
		
		
	}

}
