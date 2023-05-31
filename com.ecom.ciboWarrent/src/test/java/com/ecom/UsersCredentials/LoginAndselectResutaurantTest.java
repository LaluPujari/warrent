package com.ecom.UsersCredentials;
/**
 * 
 */

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
		public class LoginAndselectResutaurantTest   extends BaseClass  {

		//testcase_44
			 public static void main(String[] args) throws IOException, InterruptedException {
				
				WebDriver driver;
			//	JavaUtility jLib = new JavaUtility();
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
				// verify home page is displaying
				
			 	String TitleName = "Home";
				userHomePage.verifyTheTitle(wLib, driver, TitleName);
				String title = driver.getTitle();
				System.out.println(title);
				if(title.contains(TitleName))
				{
					System.out.println(" home page is displaying");
				}else
				{
					System.out.println("home is not displaying");
				} 
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
			if(dishname.contains(DishName))
			{
				System.out.println(" dish is orderd");
				b= true;
				break;
			}
			}
			if(!b)
			{
				System.out.println(" dish is not ordered");
				
			} 
			
			// wLib.switchToAlertPopupAndAccept(driver, "alert");
			
			//logout the application
			userHomePage.clicklogoutmodule();
			//close the application
			driver.close(); 
			
			
			}

		
		
		
		
	}


