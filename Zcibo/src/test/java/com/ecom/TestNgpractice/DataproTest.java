package com.ecom.TestNgpractice;

import org.testng.annotations.Test;

public class DataproTest {
	
	@Test(dataProviderClass=DataProviderTest.class,dataProvider="data")
		public void getdata(String src, String dist, int price1, int rate, int intres) {
		
		System.out.println("from----"+src+"--to--"+dist+"--&&&&&&&-"+price1+"*****"+rate+"========="+intres);
	}

}
