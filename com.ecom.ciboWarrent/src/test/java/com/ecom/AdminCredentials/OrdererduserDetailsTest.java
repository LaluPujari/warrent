package com.ecom.AdminCredentials;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.ecom.CiboObjectReposforAdmin.AdminHomePage;
import com.ecom.CiboObjectReposforAdmin.AdminLoginPage;
import com.ecom.CiboObjectReposforAdmin.AdminOrdersPage;
import com.ecom.CiboObjectRepository.UserLoginPage;

import cibo_WarrentGenriclib.BaseClass;
import cibo_WarrentGenriclib.ExcelUtility;
import cibo_WarrentGenriclib.FileUtility;
import cibo_WarrentGenriclib.WebdriverUtility;
/**
 * 
 * @author User
 *
 */

public class OrdererduserDetailsTest extends BaseClass {
//testcase_61
	 public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;
		//generic libraries object creation
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		String AdminNURL = fLib.getPropertyKeyValue("adminurl");
		String AdminUSERNAME =fLib.getPropertyKeyValue("adminusername");
		String AdminPASSWORD = fLib.getPropertyKeyValue("adminpswd");
		String BROWSER = fLib.getPropertyKeyValue("browser");
	//lunch the browser 
		if(BROWSER.equalsIgnoreCase("Chrome"))
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
			driver= new ChromeDriver();
		}
					// implicit wait for the elements to display
		              wLib.waitTillPageGetsLoad(driver);
					// maximize the window
		            wLib.maximizeWindow(driver);
					// Enter the Admin URl
					driver.get(AdminNURL);
					// Enter the username in username textField
					AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
					adminLoginPage.getAdminUsername(AdminUSERNAME);
					// Enter the password in password textfield
					adminLoginPage.getAdminpassword(AdminPASSWORD);
					// click on login button
					adminLoginPage.clickOnAdminloginbtn(); 
	
	
					// verify whether adminPanel page is Displayed or not
					wLib.waitForTitle(driver, "Panel");
					String title = driver.getTitle();
					if (title.contains("Admin Panel")) {
						System.out.println("Admin Panel Page is Disaplayed");
					} else {
						System.out.println("Admin Panel Page is not Displayed");
					}
					// click on the orders module
					Thread.sleep(3000);
					AdminHomePage adminHomePage = new AdminHomePage(driver);
					adminHomePage.clickOnOrdersModule();
					//Verify My orders Page Should be Displayed
					wLib.waitForTitle(driver, "Orders");
					String orderTitle=driver.getTitle();
					if(orderTitle.contains("Orders")) {
						System.out.println("My orders Page is Displayed");
					}
					else
						System.out.println("My orders Page is not Displayed");
					
					//click edit icon
					AdminOrdersPage adminOrdersPage = new AdminOrdersPage(driver);
					adminOrdersPage.clickOnEditbtn();
					//Verify View oders Page Should be Displayed
					
					String viewOrderTitle=driver.getTitle();
					wLib.waitForTitle(driver, "Order");
					if(viewOrderTitle.contains("View Orders")) {
						System.out.println("View orders Page is Displayed");
					}
					else
						System.out.println("View orders Page is not Displayed");
					// click on update orderstatus btn
					Thread.sleep(2000);
					adminOrdersPage.clickOnorderStatusbtn();
	                	//switch user login window
	                	wLib.switchWindow(driver, "Login");
	                	String Username = fLib.getPropertyKeyValue("Uusername");
	                	String Uuserpassword = fLib.getPropertyKeyValue("Uuserpswd");
	                	UserLoginPage userLoginPage = new	UserLoginPage(driver);
	                	userLoginPage.getUsername(Username);
	                	userLoginPage.getPassword(Uuserpassword);
	                	userLoginPage.clickLoginbtn();
	                	driver.close();
	              
	                	wLib.switchWindow(driver, "View Order");
	                    /* in this admin page asking user credential this is defect in the application */
	                   //click on update order status btn
	                	adminOrdersPage.clickOnupdateorderStatusbtn();
	                  //close child window
	                  driver.close();	    		
	     	          // switch to new window
                     wLib.switchWindow(driver, "order update");
		             Set<String> windows = driver.getWindowHandles();
		             for(String wid: windows)
		              {
		        	   driver.switchTo().window(wid);
		        	   String stitle = driver.getTitle();
		        	   if(stitle.contains("order update"))
		        	   {
		        		   break;
		        	   }
		               } 
		               //select status dropdown
		             adminOrdersPage.clickOnstatusdropdown(2, wLib);
		                    //On the way //Delivered
		             
		               //write the message
		             adminOrdersPage.getremarkmessage(" ok");
		              //click on submit button
		              driver.findElement(By.xpath("//input[@value='Submit']")).click();
		             //accept the popup
		             wLib.switchToAlertPopupAndAccept(driver, "Order Update");
	                 // click on close window btn
	              	driver.findElement(By.xpath("//input[@value='Close this window ']")).click();
	             	System.out.println("-------child window closed---------");
		
	              	//adminHomePage.clickOnDashboardModule();
	              	
		            //switch back to main window
                  	Set<String> set = driver.getWindowHandles();
	                     Iterator<String> id = set.iterator();
		            while(id.hasNext())
		           {
			         String wids = id.next();
			         driver.switchTo().window(wids);
			         String title1 = driver.getTitle();
			         System.out.println( title1);
			
			         if(title1.contains("View Order"))
		         	{
			        	break;
			      } 
		     }        
     }
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

