package com.ecom.CiboObjectReposforAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author User
 *
 */

public class AdminHomePage {

	//declaration
	@FindBy(xpath="//span[text()='Restaurant']") private WebElement Restaurantmodule;
	@FindBy(xpath="//img[@class='profile-pic']") private WebElement AdminlogoutImg;
	@FindBy(xpath="//span[.='Dashboard']") private WebElement DashboardModule;
	
	@FindBy(xpath="//span[text()='Orders']") private WebElement OrdersModule;
	@FindBy(xpath="//a[text()=' Logout']") private WebElement Adminlogout;
	
	
		
		//intialization
				public AdminHomePage(WebDriver driver) {
					
					PageFactory.initElements(driver, this);
				}
	
				public void clickOnRestaurantmodule() {
					Restaurantmodule.click();
				}
	
				public void clickOnAdminlogoutImg() {
					AdminlogoutImg.click();
				}
				
				public void clickOnAdminlogout() {
					Adminlogout.click();
				}
	         public void clickOnDashboardModule() {
	        	 DashboardModule.click();
	         }
	          public String restaurantCount(WebDriver driver) {
	        		String restaurantCount = driver.findElement(By.xpath("//div/h2[1]")).getText();
					return restaurantCount;
	        		
	          }
	          public void clickOnOrdersModule() {
	        	  OrdersModule.click();
	          }
	          
	
	
	
}
