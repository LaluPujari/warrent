package practiceDataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//2*2 dataprovider assignment 1st approch
public class DataProvider11 {
	@Test(dataProvider="data2")
	public void getdata2(String institute,String company) {
		System.out.println( "------------------------------------------");
		System.out.println("Course Completed in: "+institute+"  Training  in : "+company);
		System.out.println( "------------------------------------------");
	}
	
	
	@DataProvider
	public Object[][] data2() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties p = new Properties();
		p.load(fis);
		String instituteN = p.getProperty("institute");
		String companyN = p.getProperty("company");
		String clientN = p.getProperty("client");
		
		Object[][] obj = new Object[2][2];
		
		obj[0][0]=instituteN;
		obj[0][1]=companyN;
		
		obj[1][0]=companyN;
		obj[1][1]=clientN;
	
          return obj;
}
}
