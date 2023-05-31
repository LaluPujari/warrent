package com.ecom.CiboObjectReposforAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfRestaurantPage {
	
	@FindBy(xpath="\"//tr/td[2]\"") private List<WebElement> addedRestaurantNames;
	
	
	//intialization
		public ListOfRestaurantPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);

		}
		

		 public List<WebElement>  addedRestaurantNames(WebDriver driver) {
			 List<WebElement> restolist = driver.findElements(By.xpath("//tr/td[2]"));
			return restolist;
			 
			 
		 }
		

}
