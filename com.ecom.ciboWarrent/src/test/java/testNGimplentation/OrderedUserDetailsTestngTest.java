package testNGimplentation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.CiboObjectReposforAdmin.AdminHomePage;
import com.ecom.CiboObjectReposforAdmin.AdminOrdersPage;
import com.ecom.CiboObjectRepository.UserLoginPage;

import cibo_WarrentGenriclib.BaseClass;

public class OrderedUserDetailsTestngTest  extends BaseClass {
	
	@Test(groups="systemTest")
	public void script_61() throws InterruptedException, IOException {
	
		          SoftAssert asrt = new SoftAssert();
					// verify whether adminPanel page is Displayed or not
					wLib.waitForTitle(driver, "Panel");
					String title = driver.getTitle();
					
					asrt.assertTrue(title.contains("Admin Panel"),"Admin Panel Page is not Displayed" );
					Reporter.log("Admin Panel Page is Disaplayed", true);
					
					/*if (title.contains("Admin Panel")) {
						System.out.println("Admin Panel Page is Disaplayed");
					} else {
						System.out.println("Admin Panel Page is not Displayed");
					} */
					
					// click on the orders module
					Thread.sleep(3000);
					AdminHomePage adminHomePage = new AdminHomePage(driver);
					adminHomePage.clickOnOrdersModule();
					//Verify My orders Page Should be Displayed
					wLib.waitForTitle(driver, "Orders");
					String orderTitle=driver.getTitle();
					//hardAssert 
					Assert.assertTrue(orderTitle.contains("Orders"),"My orders Page is not Displayed");
					Reporter.log("My orders Page is Displayed", true);
					
				/*	if(orderTitle.contains("Orders")) {
						System.out.println("My orders Page is Displayed");
					}
					else
						System.out.println("My orders Page is not Displayed"); */
					
					//click edit icon
					AdminOrdersPage adminOrdersPage = new AdminOrdersPage(driver);
					adminOrdersPage.clickOnEditbtn();
					//Verify View oders Page Should be Displayed
					
					String viewOrderTitle=driver.getTitle();
					Reporter.log(viewOrderTitle, true);
					
					wLib.waitForTitle(driver, "View Order");
					//asrt.assertTrue(viewOrderTitle.contains("View Orders"),"View orders Page is not Displayed");
					//hard assert
					Assert.assertTrue(viewOrderTitle.contains("View Order"),"View orders Page is not Displayed");
					Reporter.log("View orders Page is Displayed", true);
					
				/*	if(viewOrderTitle.contains("View Orders")) {
						System.out.println("View orders Page is Displayed");
					}
					else
						System.out.println("View orders Page is not Displayed"); */
					
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
		        	   asrt.assertTrue(stitle.contains("order update")," break");
		        	   break; 
		        	   
		        	/*  if(stitle.contains("order update"))
		        	   {
		        		   break;
		        	   }  */
		               }  
		               //select status dropdown
		             adminOrdersPage.clickOnstatusdropdown(2, wLib);
		                    //On the way //Delivered
		             
		               //write the message
		             adminOrdersPage.getremarkmessage(" ok");
		              //click on submit button
		             adminOrdersPage.clickOnSavebtn12();
		             // driver.findElement(By.xpath("//input[@value='Submit']")).click();
		             //accept the popup
		             wLib.switchToAlertPopupAndAccept(driver, "Order Update");
	                 // click on close window btn
		            adminOrdersPage.clickOncloseWindowbtn();
	              //	driver.findElement(By.xpath("//input[@value='Close this window ']")).click();
	              	
	              	Reporter.log("-------child window closed--------- ", true);
	             	//System.out.println("-------child window closed---------");
	              	
	              	//asrt.assertAll();
		            Reporter.log("OrderedUserDetailsTestngTest-- testScript-- is passed", true);
		
	              	//adminHomePage.clickOnDashboardModule();
	              	
		            //switch back to main window
                  /*	Set<String> set = driver.getWindowHandles();
	                     Iterator<String> id = set.iterator();
		            while(id.hasNext())
		           {
			         String wids = id.next();
			         driver.switchTo().window(wids);
			         String title1 = driver.getTitle();
			         System.out.println( title1);
			         asrt.assertTrue(title1.contains("View Order")," break");
			         
			         break;
			      /*   if(title1.contains("View Order"))
		         	{
			        	break;
			      } 
		           } */
		            
		            
	}
}
