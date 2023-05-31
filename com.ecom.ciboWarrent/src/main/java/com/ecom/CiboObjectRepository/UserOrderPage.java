package com.ecom.CiboObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cibo_WarrentGenriclib.WebdriverUtility;

public class UserOrderPage {
	
	@FindBy(xpath="//input[@value='Order Now']") private WebElement OrderNowbtn;
	
	
	@FindBy(xpath="//td[.=' Pink Spaghetti Gamberoni']") private List<WebElement> DishNAMEs;
	
	@FindBy(xpath="//td[.=' 2023-05-15 14:52:35']/following-sibling::td[1]") private WebElement deletOrderDish;
	
	
	//intialization
	public UserOrderPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	 public void clickOnOrderNowbtn() { 
		 OrderNowbtn.click();
   	}
	 
	 
	 public List<WebElement>  getDishNAMEs(WebDriver driver) 
	 {
		 
		 List<WebElement> dishnames = driver.findElements(By.xpath("//td[.=' Pink Spaghetti Gamberoni']"));
		return dishnames;
   	}
	 
	 public void alretPopup(WebdriverUtility wLib, WebDriver driver, String title) {
		 wLib.switchToAlertPopupAndAccept(driver,title);
		 
	 }
	 public void alretIsPresent(WebdriverUtility wLib, WebDriver driver) {
		 wLib.waitAlertIsPresent(driver);
	 
	 }
	 public void clickOndletOrderDish() { 
		 deletOrderDish.click();
   	}
	 
	 public  List<WebElement> listOfOrderedItems(WebDriver driver) {
		 
		 List<WebElement> items = driver.findElements(By.xpath("//td[5]"));
		return items;
	 }
	 
	 public  List<WebElement> OrderedDishnames(WebDriver driver) {
	 List<WebElement> Ordrdishnames = driver.findElements(By.xpath("//td[@data-column='Item']"));
	return Ordrdishnames;
	 }
	 
	
	
	

}
