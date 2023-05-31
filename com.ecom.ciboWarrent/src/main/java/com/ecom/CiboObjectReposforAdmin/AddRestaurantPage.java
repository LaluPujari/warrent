package com.ecom.CiboObjectReposforAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cibo_WarrentGenriclib.WebdriverUtility;

public class AddRestaurantPage {
	
	
	//declaration
		@FindBy(name="res_name") private WebElement RestaurantNametextfield;
		@FindBy(name="email") private WebElement emailtextfield;
		@FindBy(name="phone") private WebElement phoneNumbertextfield;
		@FindBy(name="url") private WebElement urltextfield;
		
		@FindBy(name="o_hr") private WebElement openHourdropdown;
		@FindBy(name="c_hr") private WebElement CloseHourdropdown;
		@FindBy(name="o_days") private WebElement OpenDaysrdropdown;
		@FindBy(name="c_name") private WebElement CategoryNamedropdown;
		
		@FindBy(name="address") private WebElement restaurantAdress;
		@FindBy(name="submit") private WebElement clickonSavebtn;
		@FindBy(name="file") private WebElement fileuploadelink;
		
		@FindBy(xpath="//a[.='All Restaurants']") private WebElement allRestaurantsubmodule;
		
	
		//intialization
			public AddRestaurantPage(WebDriver driver) {	
			PageFactory.initElements(driver, this);

			}
		
			public void getRestaurantName(String restaurantName) {
				RestaurantNametextfield.sendKeys(restaurantName);

			}
			public void getemail(String email) {
				emailtextfield.sendKeys(email);

			}
			public void getPhoneNumber(String phoneNum) {
				phoneNumbertextfield.sendKeys(phoneNum);

			}
			public void geturl(String url) {
				urltextfield.sendKeys(url);

			}
           public WebElement getOpenHoursDropDown(WebDriver driver, WebdriverUtility wLib) {
        	   WebElement openHour = driver.findElement(By.name("o_hr"));
        	   wLib.selectElementInDropdown(openHour, 2);
			return openHour;
			}
           public WebElement getCloseHourdropdown(WebDriver driver, WebdriverUtility wLib) {
        	   WebElement closeHour = driver.findElement(By.name("c_hr"));
       		wLib.selectElementInDropdown(closeHour, 2);
			return closeHour;
           }
			
           public WebElement getOpenDaysrdropdown(WebDriver driver, WebdriverUtility wLib ) {

       		WebElement openDays = driver.findElement(By.name("o_days"));
       		wLib.selectElementInDropdown(openDays, 5);
			return openDays;
           }
           
           public WebElement getCategoryNameDropdown(WebDriver driver, WebdriverUtility wLib) {
        	   WebElement catgryName = driver.findElement(By.name("c_name"));
       		wLib.selectElementInDropdown("pureVeg", catgryName);
			return catgryName;
           }
           
           
           public void getAdress(WebDriver driver, String adress) 
           {
        	   restaurantAdress.sendKeys(adress);
           }
		
           public void clickOnsavebtn(WebDriver driver) 
           {
        	   clickonSavebtn.click();
        	   
           }
           public void uploadFile() {
   			fileuploadelink.sendKeys("F:\\\\TYSS\\\\New folder\\\\leichat_2023-05-04_10.49pm.png");
   		}

   		public WebElement getFileuploadelink() {
   			return fileuploadelink;
   		}
   		public WebElement getAllRestaurantsubmodule() {
			return allRestaurantsubmodule;
		}

		public void clickOnAllrestaurantsubModule() {
   			allRestaurantsubmodule.click();
   		}
		
			
				
		
			
			
			
			
	
	
	
	
	
	
	
	
	
	
	

}
