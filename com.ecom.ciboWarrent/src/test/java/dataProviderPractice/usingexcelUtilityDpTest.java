package dataProviderPractice;

import java.io.IOException;

import cibo_WarrentGenriclib.DpExcelutility;

public class usingexcelUtilityDpTest {
	
	
	//public void 
	

	public void getData() throws IOException {
		
		DpExcelutility dpE = new DpExcelutility();
		dpE.readDatafromExcel("DataProvider");
		
	}
	
}
