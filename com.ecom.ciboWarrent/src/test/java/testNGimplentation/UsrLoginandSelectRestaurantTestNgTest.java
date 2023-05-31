package testNGimplentation;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.CiboObjectRepository.UserAddtoCartandMenuPage;
import com.ecom.CiboObjectRepository.UserHomePage;
import com.ecom.CiboObjectRepository.UserOrderPage;
import com.ecom.CiboObjectRepository.UserRestaurantPage;

import cibo_WarrentGenriclib.BaseClass;

public class UsrLoginandSelectRestaurantTestNgTest extends BaseClass {
	
	@Test 
	public void sCript_44() throws EncryptedDocumentException, IOException  {
		UserHomePage userHomePage = new UserHomePage(driver); 
		//String TitleName = eLib.getExcelData("LoginAndselectResutaurantTest", 1, 0);
		SoftAssert asrt = new SoftAssert();
		// verify home page is displaying
	 	String TitleName = "Home";
		userHomePage.verifyTheTitle(wLib, driver, TitleName);
		String title = driver.getTitle();
		Reporter.log(title, true);
		asrt.assertTrue(title.contains(TitleName),"home is not displaying");
		Reporter.log("home page is displaying", true);
		//click on restaurant module
		userHomePage.clickrestaurantmodule();
		UserRestaurantPage userRestaurantPage = new UserRestaurantPage(driver);
		//click on particular restaurant 
		userRestaurantPage.clickOnSelectrestaurant();
		UserAddtoCartandMenuPage userAddtoCartandMenuPage = new UserAddtoCartandMenuPage(driver);
		//select dish on click on add to cart button
		userAddtoCartandMenuPage.clickOnAddtoCartbtn();
		//click on checkout button
		userAddtoCartandMenuPage.clickOnCheckOutbtn();
		UserOrderPage userOrderPage = new UserOrderPage(driver);
		//click on orderNow button
		userOrderPage.clickOnOrderNowbtn();
		//get data from excel sheet
		String titlen = eLib.getExcelData("LoginAndselectResutaurantTest", 2, 0);
		//accept the alert popup
		userOrderPage.alretPopup(wLib, driver, titlen);
	//	driver.switchTo().alert().accept();
		//userOrderPage.alretPopup(wLib, driver, titlen);
		userOrderPage.alretIsPresent(wLib, driver);
		//verify dish is ordered or not
		List<WebElement> dishnames = userOrderPage.getDishNAMEs(driver);
		boolean b=false;	
		//get dishname name data from excel sheet
		String DishName = eLib.getExcelData("LoginAndselectResutaurantTest", 3, 0);
	for(int i=0;i<dishnames.size();i++)
	{
	String dishname = dishnames.get(i).getText();
	
	asrt.assertTrue(dishname.contains(DishName)," dish is not ordered");
	Reporter.log(" dish is orderd", true);
	b= true;
	break;
	}
	asrt.assertNotEquals(b,"dish is ordered");
	asrt.assertAll();
	Reporter.log("UsrLoginandSelectRestaurantTestNgTest:  is passed ", true );
	
	}
}
