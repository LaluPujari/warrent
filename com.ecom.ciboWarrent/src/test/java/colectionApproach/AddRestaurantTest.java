package colectionApproach;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.CiboObjectReposforAdmin.AdminHomePage;
import com.ecom.CiboObjectReposforAdmin.AdminLoginPage;
import com.ecom.CiboObjectReposforAdmin.AdminRestaurantPage;
import com.ecom.CiboObjectReposforAdmin.CollectionApprochAddRestaurantPage;

import cibo_WarrentGenriclib.DpExcelutility;
import cibo_WarrentGenriclib.ExcelUtility;
import cibo_WarrentGenriclib.FileUtility;
import cibo_WarrentGenriclib.JavaUtility;
import cibo_WarrentGenriclib.WebdriverUtility;

public class AddRestaurantTest {
	public static void main(String[] args) throws IOException {
		
	DpExcelutility dpE = new DpExcelutility();

    WebdriverUtility wLib = new WebdriverUtility();
	  JavaUtility jLib = new JavaUtility();
	   FileUtility fLib = new FileUtility();
    ExcelUtility eLib = new	ExcelUtility();
    int ranNum = jLib.getRandomNumber();
	WebDriver driver = new ChromeDriver();
	
	String adurl = fLib.getPropertyKeyValue("adminurl");
	String AuName = fLib.getPropertyKeyValue("adminusername");
	String ApassWord = fLib.getPropertyKeyValue("adminpswd");
	          wLib.maximizeWindow(driver);
	          wLib.waitTillPageGetsLoad(driver);
	        driver.get(adurl);
           AdminLoginPage alp = new AdminLoginPage(driver);
           alp.getAdminUsername(AuName);
           alp.getAdminpassword(ApassWord);
           
           alp.clickOnAdminloginbtn();
          AdminHomePage adh = new AdminHomePage(driver);
          adh.clickOnRestaurantmodule();
          AdminRestaurantPage adr = new AdminRestaurantPage(driver);
          adr.clickOnAddRestaurantFeature();
	CollectionApprochAddRestaurantPage cadd = new CollectionApprochAddRestaurantPage(driver);
	cadd.addRestaurant(dpE.getMultipleData("Sheet7"), driver,jLib);
	
	
	
	
	
	
	
	}	
    
	
	
	
	
	
	
	

}
