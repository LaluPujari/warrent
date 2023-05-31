package testNGimplentation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.CiboObjectReposforAdmin.AddCategoryPage;
import com.ecom.CiboObjectReposforAdmin.AdminHomePage;
import com.ecom.CiboObjectReposforAdmin.AdminRestaurantPage;

import cibo_WarrentGenriclib.BaseClass;
import cibo_WarrentGenriclib.ExcelUtility;

public class DataFlowBtnAddandListCategoryTestNgTest extends BaseClass {
	@Test(groups="Integrationtest")
	public void script_18() throws IOException {
		 ExcelUtility eLib = new	ExcelUtility();
	       int ranNum = jLib.getRandomNumber();
		String categoryName = eLib.getExcelData("Sheet2", 1, 0);
		SoftAssert asrt = new SoftAssert();
		// verify whether adminPanel page is Displayed or not
		wLib.waitForTitle(driver, "Panel");
		String title = driver.getTitle();
		asrt.assertTrue(title.contains("Admin Panel"), "Admin Panel Page is not Displayed");
		Reporter.log("Admin Panel Page is Disaplayed", true);
		// click on the restaurant to see submodules
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		adminHomePage.clickOnRestaurantmodule();
		// click on Add category
		AdminRestaurantPage adminRestaurantPage = new AdminRestaurantPage(driver);
		adminRestaurantPage.clickOnAddCategoryFeature();
		// Verify Add category Page is Displayed or not
		String categorytitle = driver.getTitle();
		asrt.assertTrue(categorytitle.contains("Add Category"), "Add Category page is not displayed");
		Reporter.log("Add Restaurant Category Page is Displayed", true);
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
			asrt.assertTrue(cnames.contains(categoryName1), categoryName1 + " is not in Listed Categories and Test Fails");
			Reporter.log(categoryName1 + " :  is displayed Listed Categories ", true);
			ck = true;
			break;
		}
		asrt.assertNotEquals(ck, categoryName1 + " is displayed in Listed categories");
		asrt.assertAll();
		Reporter.log("DataFlowBtnAddandListCategoryTestNgTest------- is passed", true);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	

