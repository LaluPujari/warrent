package com.ecom.AdminCredentials;

import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.ecom.CiboObjectReposforAdmin.AddCategoryPage;
import com.ecom.CiboObjectReposforAdmin.AdminHomePage;
import com.ecom.CiboObjectReposforAdmin.AdminLoginPage;
import com.ecom.CiboObjectReposforAdmin.AdminRestaurantPage;

import cibo_WarrentGenriclib.BaseClass;
import cibo_WarrentGenriclib.ExcelUtility;
import cibo_WarrentGenriclib.FileUtility;
import cibo_WarrentGenriclib.JavaUtility;
import cibo_WarrentGenriclib.WebdriverUtility;
/**
 * 
 * @author User
 *
 */
public class DataFlowBetweenaddAndListCategoryTest  extends BaseClass {

	//tescase_18
	
      public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		WebDriver driver;
		
	       WebdriverUtility wLib = new WebdriverUtility();
		  JavaUtility jLib = new JavaUtility();
		   FileUtility fLib = new FileUtility();
	       ExcelUtility eLib = new	ExcelUtility();
	       int ranNum = jLib.getRandomNumber();
	       String categoryName = eLib.getExcelData("Sheet2", 1, 0);
	       
	     //propertiesfile
	       String AdminNURL = fLib.getPropertyKeyValue("adminurl");
			String AdminUSERNAME = fLib.getPropertyKeyValue("adminusername");
			String AdminPASSWORD =fLib.getPropertyKeyValue("adminpswd");
			String BROWSER = fLib.getPropertyKeyValue("browser");
	    
		// open Chrome Browser
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
		driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}else
		{
			driver= new ChromeDriver();
		}
		// implicit wait for the elements to display
		wLib.waitTillPageGetsLoad(driver);
		// maximize the window
		wLib.maximizeWindow(driver);
	
		// Enter the Admin URl
		driver.get(AdminNURL);
		// Enter the username in username textField
		AdminLoginPage AdminLoginPage = new AdminLoginPage(driver);
		AdminLoginPage.getAdminUsername(AdminUSERNAME);
		// Enter the password in password textfield
		AdminLoginPage.getAdminpassword(AdminPASSWORD);
		// click on login button
		AdminLoginPage.clickOnAdminloginbtn(); 
	
		// verify whether adminPanel page is Displayed or not
		wLib.waitForTitle(driver, "Panel");
		String title = driver.getTitle();
		if (title.contains("Admin Panel")) {
			System.out.println("Admin Panel Page is Disaplayed");
		} else {
			System.out.println("Admin Panel Page is not Displayed");
		}
		
		// click on the restaurant to see submodules
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		adminHomePage.clickOnRestaurantmodule();
		//driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
		
		// click on Add category
		AdminRestaurantPage adminRestaurantPage = new AdminRestaurantPage(driver);
		adminRestaurantPage.clickOnAddCategoryFeature();
		//driver.findElement(By.xpath("//a[text()='Add Category']")).click();
		
		
		// Verify Add category Page is Displayed or not
		String categorytitle = driver.getTitle();
		if (categorytitle.contains("Add Category")) {
			System.out.println("Add Restaurant Category Page is Displayed");
		} else
			System.out.println("Add Category page is not displayed");
		
		// Write the category name In the category text field
		AddCategoryPage addCategoryPage = new AddCategoryPage(driver);
		String categoryName1 = categoryName+""+ranNum;
		addCategoryPage.getCategoryName(categoryName+""+ranNum);
		// Click on Save button
		addCategoryPage.clickOnSavebtn();
		// Verify The added category is displayed inListed categories or not
		List<WebElement> listedCategoryNames = addCategoryPage.getlistOfCategorie(driver);
		boolean ck = false;
		for (int i=0;i<=listedCategoryNames.size();i++) 
		{
			String cnames = listedCategoryNames.get(i).getText();
			//insert category list into the excel sheet
			eLib.insartDataIntoExcel("sheet3", i, 0, cnames);
			if (cnames.contains(categoryName1)) {
				System.out.println(categoryName1 + " is displayed in Listed categories");
				ck = true;
				break;
			}
		}
		if (!ck) {
			System.out.println(categoryName1 + " is not in Listed Categories and Test Fails");
		}
		
	
		// logout from the Application
		adminHomePage.clickOnAdminlogoutImg();
		adminHomePage.clickOnAdminlogout();
		driver.close(); 
	}
	}