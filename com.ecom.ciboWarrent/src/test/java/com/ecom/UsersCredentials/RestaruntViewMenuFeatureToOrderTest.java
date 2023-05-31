package com.ecom.UsersCredentials;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.ecom.CiboObjectRepository.UserAddtoCartandMenuPage;
import com.ecom.CiboObjectRepository.UserHomePage;
import com.ecom.CiboObjectRepository.UserLoginPage;
import com.ecom.CiboObjectRepository.UserOrderPage;
import com.ecom.CiboObjectRepository.UserRestaurantPage;

import cibo_WarrentGenriclib.BaseClass;
import cibo_WarrentGenriclib.ExcelUtility;
import cibo_WarrentGenriclib.FileUtility;
import cibo_WarrentGenriclib.WebdriverUtility;

public class RestaruntViewMenuFeatureToOrderTest   extends BaseClass {
	
	//testcase_49
  public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver;
	//JavaUtility jLib = new JavaUtility();
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebdriverUtility wLib = new WebdriverUtility();
	
	 //fecth data from proprties file
	String UURL = fLib.getPropertyKeyValue("Userurl");
	 String uUSERNAME = fLib.getPropertyKeyValue("Uusername");
	 String uUSERPASSWORD = fLib.getPropertyKeyValue("Uuserpswd");
	 String BROWSER =  fLib.getPropertyKeyValue("browser");
	 // diffrent browsers to launch
	 if(BROWSER.equalsIgnoreCase("chrome"))
	 {
		driver= new ChromeDriver();
	 }else if(BROWSER.equalsIgnoreCase("firefox"))
	 {
		 driver=new FirefoxDriver();
	 }else if(BROWSER.equalsIgnoreCase("edge"))
	 {
	 driver= new EdgeDriver();
	 }else
	 {
		 driver = new ChromeDriver();
	 }
	   //maximize the browser
	 wLib.maximizeWindow(driver);
	// enter the url
	 	driver.get(UURL);
	//implicitwait duration for 10sec
	 	wLib.waitTillPageGetsLoad(driver);
	 	
 	UserHomePage userHomePage = new UserHomePage(driver);
	 //click on login module
	 	userHomePage.clickLoginModule();
	UserLoginPage userLoginPage = new UserLoginPage(driver);
	//enter username
	userLoginPage.getUsername(uUSERNAME);
	// enter password
	userLoginPage.getPassword(uUSERPASSWORD);
	//click on login button
	userLoginPage.clickLoginbtn(); 
	
	//String TitleName = eLib.getExcelData("LoginAndselectResutaurantTest", 1, 0);
	 String TitleName12="Home";
	
	// verify home page is displaying
	Thread.sleep(3000);
	userHomePage.verifyTheTitle(wLib, driver, TitleName12);
	// wLib.waitForTitle(driver, TitleName);
	
	String title = driver.getTitle();
	System.out.println(title);
	if(title.contains(TitleName12))
	{
		System.out.println(" home page is displaying");
	}else
	{
		System.out.println("home is not displaying");
	} 
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
	if(dishname.contains("Yorkshire Lamb Patties"))
	{
		System.out.println(" dish is orderd");
		b= true;
		break;
	}
	}
	if(!b)
	{
		System.out.println(" dish is not oredred");
	}
	
	//logout the application
	userHomePage.clicklogoutmodule();
	
	wLib.takeScreenShot(driver, "cibo");
	
	driver.close(); 
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	


