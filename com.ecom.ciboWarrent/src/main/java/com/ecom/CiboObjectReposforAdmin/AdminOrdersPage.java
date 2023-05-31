package com.ecom.CiboObjectReposforAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cibo_WarrentGenriclib.WebdriverUtility;

public class AdminOrdersPage {
	
	
	@FindBy(xpath="//table//td[.='Prawn Crackers']/..//a[2]") private WebElement editbtn;
	
	@FindBy(xpath="//button[.='Update Order Status']") private WebElement orderStatusbtn;
	
	@FindBy(xpath="//button[.='Update Order Status']") private WebElement updateorderStatusbtn;
	
	@FindBy(xpath="//select[@name='status']") private WebElement statusdropdown;
	
	@FindBy(name="remark") private WebElement remarkmessage;
	
	@FindBy(xpath="//input[@value='Submit']") private WebElement savebtn12;
	@FindBy(xpath="//input[@value='Close this window ']") private WebElement closeWindowbtn;
	
	//intialization
			public AdminOrdersPage(WebDriver driver) {
				
				PageFactory.initElements(driver, this);
			}
			public void clickOnEditbtn() {
				editbtn.click();
			}
			public void clickOnorderStatusbtn() {
				orderStatusbtn.click();
			}
			public void clickOnupdateorderStatusbtn() {
				updateorderStatusbtn.click();
			}
			public WebElement clickOnstatusdropdown(int index, WebdriverUtility wLib) {
				 wLib.selectElementInDropdown(statusdropdown, index);
				return statusdropdown;
			}
			public WebElement getStatusdropdown() {
				return statusdropdown;
			}
			public void getremarkmessage(String text) {
				remarkmessage.sendKeys(text);
			}
			public void clickOnSavebtn12() {
				savebtn12.click();
			}
			public void clickOncloseWindowbtn() {
				closeWindowbtn.click();
			}
			
		
		
	
	
	

}
