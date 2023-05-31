package com.ecom.CiboObjectReposforAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author User
 *
 */

public class AdminRestaurantPage {
	
	//declaration
	@FindBy(xpath="//a[text()='Add Category']") private WebElement AddCategoryFeature;
	@FindBy(linkText="Add Restaurant") private WebElement AddRestaurantFeature;
	
	
			
	//intialization
		public AdminRestaurantPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);

		}
	
		public void clickOnAddCategoryFeature() {
			AddCategoryFeature.click();

		}
		public void clickOnAddRestaurantFeature() {
			AddRestaurantFeature.click();

		}
		
		
		
		
	
	
	
	

}
