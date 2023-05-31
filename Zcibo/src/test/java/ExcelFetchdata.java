import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFetchdata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		


		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	 Sheet sheet = wb.getSheet("Sheet1");
	 
	        //  int lastrow = sheet.getLastRowNum();
	/* for(int i=0; i<lastrow;i++)
	 {
	            Row row = sheet.getRow(i);
                 Cell cell = row.getCell(0);
		       String data = cell.getStringCellValue();
		      System.out.println(data);
		
	} */
    
	 Row rorw = sheet.getRow(14);
	 Cell cell = rorw.getCell(0);
	String data = cell.getStringCellValue();
	System.out.println(data);
}
}
