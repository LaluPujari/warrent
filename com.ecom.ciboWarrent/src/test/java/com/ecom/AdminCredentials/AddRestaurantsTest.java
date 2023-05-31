package com.ecom.AdminCredentials;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.ecom.CiboObjectReposforAdmin.AddRestaurantPage;
import com.ecom.CiboObjectReposforAdmin.AdminHomePage;
import com.ecom.CiboObjectReposforAdmin.AdminLoginPage;
import com.ecom.CiboObjectReposforAdmin.AdminRestaurantPage;
import com.ecom.CiboObjectReposforAdmin.ListOfRestaurantPage;

import cibo_WarrentGenriclib.BaseClass;
import cibo_WarrentGenriclib.ExcelUtility;
import cibo_WarrentGenriclib.FileUtility;
import cibo_WarrentGenriclib.JavaUtility;
import cibo_WarrentGenriclib.WebdriverUtility;
/**
 * 
 * @author User
 *    Add restaurant test caseses 
 */

public class AddRestaurantsTest extends BaseClass {

	 public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		WebDriver driver;
	       WebdriverUtility wLib = new WebdriverUtility();
		  JavaUtility jLib = new JavaUtility();
		   FileUtility fLib = new FileUtility();
	       ExcelUtility eLib = new	ExcelUtility();
	       int ranNum = jLib.getRandomNumber();
	     //  String categoryName = eLib.getExcelData("Sheet2", 1, 0);
	       
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
		//click on add restaurant
		AdminRestaurantPage adminRestaurantPage = new AdminRestaurantPage(driver);
		adminRestaurantPage.clickOnAddRestaurantFeature();
		wLib.waitForTitle(driver, "Add Restaurant");
		String addrestauranttitle = driver.getTitle();
		if(addrestauranttitle.contains("Add Restaurant")) {
			System.out.println("Add Restaurant page is displaying");
		}else
		{
			System.out.println(" Add Restaurant page is not dispalying");
		}
		// get datafrom excel sheet
		String restaurantName = eLib.getExcelData("Restaruntdata", 1, 0);
		String email = eLib.getExcelData("Restaruntdata", 2, 0);
		String phoneNum = eLib.getExcelData("Restaruntdata", 3, 0);
		String url = eLib.getExcelData("Restaruntdata", 4, 0);
		//eneter unique restaurant name in textfield
		AddRestaurantPage addRestaurantPage = new AddRestaurantPage(driver);
		String restoname1= restaurantName+""+ranNum;
		addRestaurantPage.getRestaurantName(restoname1);
		
		//enter email
		addRestaurantPage.getemail(email);
		//enter phone number
		addRestaurantPage.getPhoneNumber(phoneNum);
		//enter url
		addRestaurantPage.geturl(url);
		//select opening time in dropdown
		addRestaurantPage.getOpenHoursDropDown(driver, wLib);
		//select closing time in dropdown
		addRestaurantPage.getCloseHourdropdown(driver, wLib);
		//select open days in dropdown
		addRestaurantPage.getOpenDaysrdropdown(driver, wLib);
		//select file 
		addRestaurantPage.uploadFile();
		//select category name
		addRestaurantPage.getCategoryNameDropdown(driver, wLib);
		//enter address
		addRestaurantPage.getAdress(driver, "ok");
		//click on save button
		addRestaurantPage.clickOnsavebtn(driver);
		//click on all restaurant submodule
		
		addRestaurantPage.clickOnAllrestaurantsubModule();
		//driver.findElement(By.xpath("//a[.='All Restaurants']")).click();
		
		// verify the restaurant added or not 
		ListOfRestaurantPage listOfRestaurantPage = new ListOfRestaurantPage(driver);
		List<WebElement> restolist = listOfRestaurantPage.addedRestaurantNames(driver);

		boolean b= false;
		for(int i=0;i<=restolist.size(); i++) {
			
			String restaurantnames = restolist.get(i).getText();
			
			
			if(restaurantnames.contains(restoname1));
			{
				System.out.println(restoname1+":restaurant added succusfully ");
				b=true;
				break;
			}
		}
		if(!b)
		{
			System.out.println(restoname1+"__:restaurant not added");
		}
		//click on dashbord
		adminHomePage.clickOnDashboardModule();
		//verify the restaurant count incresed or not 
		String restaurantCount = adminHomePage.restaurantCount(driver);
		//String restaurantCount = driver.findElement(By.xpath("//div/h2[1]")).getText();
		System.out.println("restaurantcount :"+restaurantCount);
		
	//logout application
		adminHomePage.clickOnAdminlogoutImg();
		adminHomePage.clickOnAdminlogout();
		//close the application
		driver.close(); 
	}
	

}
