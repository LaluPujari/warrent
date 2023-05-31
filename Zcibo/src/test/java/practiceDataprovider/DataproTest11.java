package practiceDataprovider;

import org.testng.annotations.Test;
//2*2 dataprovider assignment 2nd approch
public class DataproTest11 {
	
	@Test(dataProviderClass=DataProvider11.class,dataProvider="data2")
	public void getdata2(String institute,String company) {
		
		System.out.println( "------------------------------------------");
		System.out.println("Course Completed in: "+institute+"  Training  in : "+company);
		System.out.println( "------------------------------------------");
	}

}
