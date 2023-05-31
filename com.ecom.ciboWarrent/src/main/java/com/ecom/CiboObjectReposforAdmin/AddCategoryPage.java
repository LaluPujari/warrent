package com.ecom.CiboObjectReposforAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author User
 *
 */
// welcome to the project
public class AddCategoryPage {

	//declaration
		@FindBy(name="c_name") private WebElement CategoryNameTextFiled;
		@FindBy(name="submit") private WebElement SubmitBtn;
		
		//intialization
			public AddCategoryPage(WebDriver driver) {	
			PageFactory.initElements(driver, this);

	}
		
        public void getCategoryName(String categoryName) {
        	CategoryNameTextFiled.sendKeys(categoryName);
	}
        public void clickOnSavebtn() {
        	SubmitBtn.click();
        }
        public List<WebElement>  getlistOfCategorie(WebDriver driver) {
        	List<WebElement> listedCategoryNames = driver.findElements(By.xpath("//table//td[2]"));
        	return listedCategoryNames;
        	
        }
			
	
	
	
	
	
	
	
}
