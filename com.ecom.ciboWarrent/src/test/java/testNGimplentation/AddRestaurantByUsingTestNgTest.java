package testNGimplentation;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.CiboObjectReposforAdmin.AddRestaurantPage;
import com.ecom.CiboObjectReposforAdmin.AdminHomePage;
import com.ecom.CiboObjectReposforAdmin.AdminRestaurantPage;
import com.ecom.CiboObjectReposforAdmin.ListOfRestaurantPage;

import cibo_WarrentGenriclib.BaseClass;
import dev.failsafe.internal.util.Assert;
@Listeners(cibo_WarrentGenriclib.Listeners.class)
public class AddRestaurantByUsingTestNgTest extends BaseClass {
	@Test          (groups="systemTest")      //(retryAnalyzer=cibo_WarrentGenriclib.Retry.class)                              
	public void script_addrestaurant() throws EncryptedDocumentException, IOException, InterruptedException {
		int ranNum = jLib.getRandomNumber();
		// verify whether adminPanel page is Displayed or not
		wLib.waitForTitle(driver, "Panel");
		
		String title = driver.getTitle(); 
		 Reporter.log(title, true);
		  SoftAssert asrt = new SoftAssert();
		  asrt.assertTrue(title.contains("Admin Panel"), " Admin panel page is displaying");
		
		/*if (title.contains("Admin Panel")) {
			System.out.println("Admin Panel Page is Disaplayed");
		} else {
			System.out.println("Admin Panel Page is not Displayed");
		} */
		
		// click on the restaurant to see submodules
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		Thread.sleep(3000);
		adminHomePage.clickOnRestaurantmodule();
  //	asrt.fail();
		//click on add restaurant
		AdminRestaurantPage adminRestaurantPage = new AdminRestaurantPage(driver);
		adminRestaurantPage.clickOnAddRestaurantFeature();
		//verify addrestaurant page is displaying or not
		wLib.waitForTitle(driver, "Add Restaurant");
		String addrestauranttitle = driver.getTitle();
		asrt.assertTrue(addrestauranttitle.contains("Add Restaurant"), "addrestaurant page is not displaying");
		Reporter.log("addrestaurant page is displaying", true);
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
		// verify the restaurant added or not 
		ListOfRestaurantPage listOfRestaurantPage = new ListOfRestaurantPage(driver);
		List<WebElement> restolist = listOfRestaurantPage.addedRestaurantNames(driver);
		boolean b= false;
		for(int i=0;i<=restolist.size(); i++) {
			String restaurantnames = restolist.get(i).getText();
			asrt.assertTrue(restaurantnames.contains(restoname1), "restaurant not added successfully");
			Reporter.log("restaurant added successfully", true);
			b=true;
			break; 
		}
		asrt.assertNotEquals(b, "restaurant added successfully");
	
		//click on dashbord
		adminHomePage.clickOnDashboardModule();
		//verify the restaurant count incresed or not 
		String restaurantCount = adminHomePage.restaurantCount(driver);
		//String restaurantCount = driver.findElement(By.xpath("//div/h2[1]")).getText();
		Reporter.log(":restaurantcount"+restaurantCount);
		//System.out.println("restaurantcount :"+restaurantCount);
	   asrt.assertAll();
	   Reporter.log(" AddRestaurantByUsingTestNgTestClass------ testcase is pass", true);
	}


	
}
