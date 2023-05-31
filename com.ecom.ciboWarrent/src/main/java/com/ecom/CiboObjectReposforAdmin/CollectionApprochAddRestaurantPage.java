package com.ecom.CiboObjectReposforAdmin;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cibo_WarrentGenriclib.JavaUtility;

public class CollectionApprochAddRestaurantPage {
	
	
	@FindBy(name="res_name") private WebElement RestaurantNametextfield;
	@FindBy(name="email") private WebElement emailtextfield;
	@FindBy(name="phone") private WebElement phoneNumbertextfield;
	@FindBy(name="url") private WebElement urltextfield;
	
	//intialization
	public CollectionApprochAddRestaurantPage(WebDriver driver) {	
	PageFactory.initElements(driver, this);

	}
	
	//bussiness librery
	
	public void addRestaurant(HashMap<String, String> fileds,WebDriver driver,JavaUtility j ) {
		for ( Entry<String, String> set : fileds.entrySet()) {
			
			if(set.getValue().equalsIgnoreCase("indian1")) {
			
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+""+j.getRandomNumber());
			}else
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			
		}
	}
	
	

}
