package dataProviderPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadTheDataExcelDpTest {
	@Test(dataProvider="readDatafromExcel")
	public void data(String src, String dist, String price) {
		System.out.println("--from--"+src+"--to--"+dist+" "+price);
	}
	
	@DataProvider
	public  Object[][] readDatafromExcel() throws IOException {
		
		FileInputStream  fis=new FileInputStream("./src/test/resources/restaurantdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	
	       Sheet sh = wb.getSheet("DataProvider");
	        
	    
	              int lastRow = sh.getLastRowNum()+1;
	              int lastCell=sh.getRow(0).getLastCellNum();
	             
	             Object[][] obj = new Object[lastRow][lastCell];
	             
	             for (int i = 0;i<lastRow; i++) {
	            	 
	            	 for(int j=0; j<lastCell; j++) {
	            		    
	            		 obj[i][j] =sh.getRow(i).getCell(j).getStringCellValue();
	            		 
	            	 }
					
				}
	return obj;
	}
}
