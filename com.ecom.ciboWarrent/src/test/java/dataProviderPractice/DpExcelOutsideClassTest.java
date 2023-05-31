package dataProviderPractice;

import org.testng.annotations.Test;

public class DpExcelOutsideClassTest {
	@Test(dataProviderClass=ReadTheDataExcelDpTest.class,dataProvider="readDatafromExcel")
	public void data(String src, String dist, String price) {
		System.out.println("--from--"+src+"--to--"+dist+" "+price);
	}
	
	

}
