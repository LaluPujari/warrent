package com.ecom.UsersCredentials;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.ecom.CiboObjectRepository.UserHomePage;
import com.ecom.CiboObjectRepository.UserLoginPage;
import com.ecom.CiboObjectRepository.UserOrderPage;

import cibo_WarrentGenriclib.BaseClass;
import cibo_WarrentGenriclib.ExcelUtility;
import cibo_WarrentGenriclib.FileUtility;
import cibo_WarrentGenriclib.WebdriverUtility;
//testcase_48
public class MyorderDeleteTest  extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
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
				String Titlename ="Home";
				
				// verify home page is displaying
				// title =home
				//userHomePage.verifyTheTitle(wLib, driver, Titlename);
			 String title = driver.getTitle();
				//String title = driver.getCurrentUrl();
				
				System.out.println(title);
				
				if(title.contains(Titlename))
				{
					System.out.println(" home page is displaying");
					
				}else
				{
					System.out.println("home is not displaying");
					
				} 
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
				if(itemsname.contains("2023-05-15 14:52:35"))
				{
					System.out.println(" dish is not deleted");

					f= true;
					break;
				}
			}
			if(!f)
			{
				System.out.println(" dish is deleted");
			}
			
			//logout the application
			userHomePage.clicklogoutmodule();
			driver.close();  
	}

}
