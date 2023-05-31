package com.ecom.TestNgpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider="data")
	public void getData(String src, String dist, int price, int rate, int intres) {
		
		System.out.println("from----"+src+"--to-----"+dist+" "+price+""+rate+""+intres);
		
	} 
	
	
	@DataProvider
	public Object[][] data() {
	//	[rows][colume]
		Object[][] arr=new Object[4][5];
		arr[0][0]="gulbarga";
		arr[0][1]="Banglore";
		arr[0][2]=1300;
		arr[0][3]=1304;
		arr[0][4]=1304;
		
		arr[1][0]="pune";
		arr[1][1]="gulbarga";
		arr[1][2]=1001;
	    arr[1][3]=13005;
	    arr[1][4]=1304;
		
	arr[2][0]="pune";
		arr[2][1]="Banglore";
		arr[2][2]=1800;
		arr[2][3]=1300;
		arr[2][4]=1300;
		
		arr[3][0]="pune";
		arr[3][1]="Banglore";
		arr[3][2]=1300;
		arr[3][3]=1300;
		arr[3][4]=1304;
		return arr; 
	}
	
	
	
	

}
