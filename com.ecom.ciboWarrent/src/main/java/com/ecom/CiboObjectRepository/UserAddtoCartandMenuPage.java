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

public class UserAddtoCartandMenuPage {
	
	
	@FindBy(xpath="//a[.='Pink Spaghetti Gamberoni']/../../../../../div[2]/input[@value='Add To Cart']") private WebElement addtoCartbtn;
	
	@FindBy(xpath="//a[.='Checkout']") private WebElement checkOutbtn;
	
	@FindBy(xpath="//a[.='Yorkshire Lamb Patties']/ancestor::div[@class='food-item']/descendant::input[@value='Add To Cart']") private WebElement ViewMenuaddtoCartbtn;
	
	
	//intialization
			public UserAddtoCartandMenuPage(WebDriver driver) {
				
				PageFactory.initElements(driver, this);
			}
			//utilization
			 public void clickOnAddtoCartbtn() {
				 addtoCartbtn.click();
		   	}
	
			 public void clickOnCheckOutbtn() {
				 checkOutbtn.click();
		   	}
	
			 public void clickOnViewMenuaddtoCartbtn() {
				 ViewMenuaddtoCartbtn.click();
		   	}
	
	

}
