package dDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AmezontoSheet2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream fis= new FileInputStream("./src/test/resources/amazontestdata.xlsx");
                 Workbook wb = WorkbookFactory.create(fis);
                Sheet sheet = wb.getSheet("amazondata");
                int lastrow = sheet.getLastRowNum();
                for(int i=0; i<lastrow; i++)
                {
                	Row row = sheet.getRow(i);
                	Cell cell = row.getCell(0);
                	 String data = cell.getStringCellValue();
                	 System.out.println(data);
               
                FileInputStream fis1= new FileInputStream("./src/test/resources/amazontestdata.xlsx");
                Workbook wb1 = WorkbookFactory.create(fis1);
               Sheet sheet1 = wb1.getSheet("data21");
           
            	  
            	  Row row1 = sheet1.createRow(i);
            	  Cell cell1 = row1.createCell(0);
            	  
            	 cell1.setCellValue(data);
                
              FileOutputStream fout = new FileOutputStream("./src/test/resources/amazontestdata.xlsx");
             wb1.write(fout);
             
                }
                wb.close();
	}

}
