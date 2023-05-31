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

public class AdminLoginPage {
	
	//declaration
	@FindBy(name="username") private WebElement Adminusernametxtf;
	
	@FindBy(name="password") private WebElement Adminpasswordtextf;

	@FindBy(name="submit") private WebElement Adminloginbtn;
	
	//intialization
		public AdminLoginPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
	
	
		public void getAdminUsername(String AdminUSERNAME) {
			Adminusernametxtf.sendKeys(AdminUSERNAME);
		}
		
		public void getAdminpassword(String AdminPASSWORD) {
			Adminpasswordtextf.sendKeys(AdminPASSWORD);
		}

		public void clickOnAdminloginbtn() {
			Adminloginbtn.click();

		}
		
}
