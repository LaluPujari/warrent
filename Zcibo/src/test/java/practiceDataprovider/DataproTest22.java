package practiceDataprovider;

import org.testng.annotations.Test;
//3*2 dataprovider assignment 2nd approch
public class DataproTest22 {
	
	@Test(dataProviderClass=Dataprovide22.class,dataProvider="data1")
	public void getdata(String from, String to) {
		
		System.out.println( "--------**---------------------------**-------");
		System.out.println("from*********"+from+"***To*********"+to);
		System.out.println( "--------**--------------------------**--------");
	}
	

}
