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

public class UserLoginPage {
	//declarartion
	@FindBy(name="username") private WebElement usernametxtf;
	
	@FindBy(name="password") private WebElement passwordtextf;

	@FindBy(name="submit") private WebElement loginbtn;
	
	//intialization
	public UserLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public void getUsername( String uUSERNAME) {
		
		usernametxtf.sendKeys(uUSERNAME);
	}
	
	public void getPassword(String uUSERPASSWORD) {
		passwordtextf.sendKeys(uUSERPASSWORD);
	}
	
	public void clickLoginbtn() {
		loginbtn.click();
	}
	
	
	
	

}
