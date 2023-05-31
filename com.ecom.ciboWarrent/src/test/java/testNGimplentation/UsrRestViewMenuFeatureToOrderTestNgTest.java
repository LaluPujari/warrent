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
import cibo_WarrentGenriclib.ExcelUtility;
import cibo_WarrentGenriclib.WebdriverUtility;

public class UsrRestViewMenuFeatureToOrderTestNgTest  extends BaseClass {
	
	@Test
	public void sCript_49() throws EncryptedDocumentException, IOException, InterruptedException {

		 SoftAssert asrt = new SoftAssert();
		 
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
	//String TitleName = eLib.getExcelData("LoginAndselectResutaurantTest", 1, 0);
	 String TitleName12="Home";
	
	// verify home page is displaying
	Thread.sleep(3000);
	 UserHomePage userHomePage = new UserHomePage(driver);
	userHomePage.verifyTheTitle(wLib, driver, TitleName12);
	// wLib.waitForTitle(driver, TitleName);
	
	String title = driver.getTitle();
	System.out.println(title);
	
	asrt.assertTrue(title.contains(TitleName12), "home is not displaying");
	Reporter.log("home page is displaying");
	
	
	/*if(title.contains(TitleName12))
	{
		System.out.println("home page is displaying");
	}else
	{
		System.out.println("home is not displaying");
	}  */
	
	//click on restaurant module
	userHomePage.clickrestaurantmodule();
	
	       UserRestaurantPage userRestaurantPage = new UserRestaurantPage(driver);
		//click on particular restaurant view menu button
	    userRestaurantPage.clickOnViewMenuBtn();
	    UserAddtoCartandMenuPage userAddtoCartandMenuPage = new UserAddtoCartandMenuPage(driver);
		//click on particular dish add to cart button
	    userAddtoCartandMenuPage.clickOnViewMenuaddtoCartbtn();
	//driver.findElement(By.xpath("//a[.='Yorkshire Lamb Patties']/ancestor::div[@class='food-item']/descendant::input[@value='Add To Cart']")).click();
		//click on checkout button
	    userAddtoCartandMenuPage.clickOnCheckOutbtn();
		//click on orderNow button
	    UserOrderPage userOrderPage = new UserOrderPage(driver);
	    userOrderPage.clickOnOrderNowbtn();
		//accept the alert popup
	    userOrderPage.alretPopup(wLib, driver, "My Order");
		//explicitwait for alretpresent in between 
	    userOrderPage.alretIsPresent(wLib, driver);
		//accept the alert popup
		wLib.switchToAlertPopupAndAccept(driver, title);
		//verify dish is ordered or not
		List<WebElement> dishnames = userOrderPage.OrderedDishnames(driver);
		boolean b=false;
	for(int i=0;i<dishnames.size();i++)
	{
	String dishname = dishnames.get(i).getText();
	eLib.insartDataIntoExcel("sheet4", i, 0, dishname);
	asrt.assertTrue(dishname.contains("Yorkshire Lamb Patties")," dish is not oredred");
	Reporter.log("dish is orderd", true);

	Reporter.log("UsrRestViewMenuFeatureToOrderTestNgTest: is passed ");
	b= true;
	break;
	}
	}
	//asrt.assertAll();
}
