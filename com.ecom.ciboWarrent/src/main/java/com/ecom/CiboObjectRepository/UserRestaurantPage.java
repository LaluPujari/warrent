package com.ecom.CiboObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author User
 *
 */

public class UserRestaurantPage {
	
	@FindBy(xpath="//a[.='Eataly']") private WebElement selectrestaurant;
	
  @FindBy(xpath="//a[.='North Street Tavern']/ancestor::div[@class='col-xs-12 col-sm-7 col-md-7 col-lg-9']/descendant::div[6]/descendant::a[.='View Menu']")
   private WebElement ViewMenuBtn;
  
	//intialization
		public UserRestaurantPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		 public void clickOnSelectrestaurant() {
			 selectrestaurant.click();
	   	}
		 
		 public void clickOnViewMenuBtn() {
			 ViewMenuBtn.click();
	   	}
		 
	
	
	
	
	
	
	
	
	
	
	
	
	

}
