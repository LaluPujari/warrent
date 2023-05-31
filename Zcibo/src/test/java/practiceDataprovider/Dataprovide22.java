package practiceDataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//3*2 dataprovider assignment
public class Dataprovide22 {
  @Test(dataProvider = "data1")
	public void getdata(String from, String to) {
	  System.out.println( "--------**--------------------------**--------");
		System.out.println("from-|-|-|"+from+"-|-To|-|"+to);
		System.out.println( "--------**--------------------------**--------");
	}
	
	
	@DataProvider
	public Object[][] data1() {
		Object[][] obj = new Object[3][2];
		
		obj[0][0]="Qspider";
		obj[0][1]="testyantra";
		
		obj[1][0]="testyantra";
		obj[1][1]="client";
		
		obj[2][0]="banglore";
		obj[2][1]="all india";
		return obj;
		
		
		
	}
	
	
	
	
	
	
	
	
}
