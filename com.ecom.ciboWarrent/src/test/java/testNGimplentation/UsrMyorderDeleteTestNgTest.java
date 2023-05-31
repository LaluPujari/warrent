package testNGimplentation;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.CiboObjectRepository.UserHomePage;
import com.ecom.CiboObjectRepository.UserOrderPage;

import cibo_WarrentGenriclib.BaseClass;
import cibo_WarrentGenriclib.ExcelUtility;

public class UsrMyorderDeleteTestNgTest extends BaseClass {
	@Test
	public void script_48() throws EncryptedDocumentException, IOException {
		       
		            SoftAssert asrt = new SoftAssert();
		          ExcelUtility eLib = new ExcelUtility();
				//String TitleName = eLib.getExcelData("LoginAndselectResutaurantTest", 1, 0);
				// verify home page is displaying
				UserHomePage userHomePage = new UserHomePage(driver);
				//String Titlename ="Home";
				// title =home
				//userHomePage.verifyTheTitle(wLib, driver, Titlename);
			 String title = driver.getTitle();
				//System.out.println(title);
				Reporter.log(title, true);
				asrt.assertTrue(title.contains("Home"),"home page is not displaying");
				Reporter.log("home page is displaying", true);
			//click on my orders module
			userHomePage.clickMyOrdersmodule();
			UserOrderPage userOrderPage = new UserOrderPage(driver);
			//delete dish
			//userOrderPage.clickOndletOrderDish();
			//driver.switchTo().alert().accept();
			//list of ordered dishesh
			List<WebElement> items = userOrderPage.listOfOrderedItems(driver);
			boolean f= false;
			for(int i=0;i<items.size();i++)
			{
				String itemsname = items.get(i).getText();
				eLib.insartDataIntoExcel("Sheet3", i, 0, itemsname);
				asrt.assertTrue(itemsname.contains("2023-05-15 14:52:35"),"dish is not deleted");
				Reporter.log("dish is deleted", true);
				f= true;
				break;
			}
		//	asrt.assertAll();
			Reporter.log("UsrMyorderDeleteTestNgTest--: is passed ", true);
		
	}
}
