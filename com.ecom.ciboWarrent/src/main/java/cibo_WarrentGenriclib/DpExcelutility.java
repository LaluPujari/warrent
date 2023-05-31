package cibo_WarrentGenriclib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DpExcelutility {
	
	
public  Object[][] readDatafromExcel(String sheetName) throws IOException {
		
		FileInputStream  fis=new FileInputStream("./src/test/resources/restaurantdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	
	       Sheet sh = wb.getSheet(sheetName);
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
             public HashMap<String, String> getMultipleData(String sheetName1) throws IOException { 
		
		FileInputStream  fi=new FileInputStream("./src/test/resources/restaurantdata.xlsx");
		Workbook wb1 = WorkbookFactory.create(fi);
	
	       Sheet sh1 = wb1.getSheet(sheetName1);
	              int count = sh1.getLastRowNum();
	              
	             HashMap<String, String> map = new HashMap<String, String>();
	             for(int i=0; i<=count; i++) {
	            	 
		String key = sh1.getRow(i).getCell(0).getStringCellValue();
		String value = sh1.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
	}
	return map;
	
	
	
	
	}
}
	
	



