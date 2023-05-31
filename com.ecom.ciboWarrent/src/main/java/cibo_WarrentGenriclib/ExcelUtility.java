package cibo_WarrentGenriclib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author User
 *
 */

public class ExcelUtility {
	/**
	 * this method is used for insert the data into Excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void insartDataIntoExcel(String sheetName, int rowNo, int cellNo, String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fileInputStream = new FileInputStream(IpathConstants.ExcelFilepath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream fileOutputSream = new FileOutputStream(IpathConstants.ExcelFilepath);
		workbook.write(fileOutputSream);
		workbook.close();
		
	}
	/**
	 * this method is used for get data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(IpathConstants.ExcelFilepath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
		
	}
	/**
	 * this method is used to get count of rowscreated in excel shett
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowNumber(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(IpathConstants.ExcelFilepath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
	}
	
	
	

}
