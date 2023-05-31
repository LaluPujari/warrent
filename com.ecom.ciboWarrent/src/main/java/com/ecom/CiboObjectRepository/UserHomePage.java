package com.ecom.CiboObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cibo_WarrentGenriclib.WebdriverUtility;
/**
 * 
 * @author User
 *
 */

public class UserHomePage {
	
	@FindBy(xpath="//a[.='Login']") private WebElement loginmodule;
	
	
	@FindBy(xpath="//a[.='Restaurants ']") private WebElement restaurantmodule;
	
	@FindBy(linkText="Logout") private WebElement logoutmodule;
	
	@FindBy(xpath="//a[.='My Orders']") private WebElement MyOrdersmodule;

	//intialization
       public UserHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
       
       //utilization
       
       public void clickLoginModule() {
    	   loginmodule.click();
   	}
       public void clickrestaurantmodule() {
    	   restaurantmodule.click();
   	}
       public void clicklogoutmodule() {
    	   logoutmodule.click();
         }
         /**
          * wait for title verification 
          * @param wLib
          * @param driver
          * @param Titlename
          */
       public void verifyTheTitle(WebdriverUtility wLib, WebDriver driver,String Titlename) {
       wLib.waitForTitle(driver, Titlename);
       }
       /**
        * click on my orders module
        */
       public void clickMyOrdersmodule() {
    	   MyOrdersmodule.click();
       }
}
