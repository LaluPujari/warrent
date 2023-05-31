package cibo_WarrentGenriclib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ecom.CiboObjectReposforAdmin.AdminHomePage;
import com.ecom.CiboObjectReposforAdmin.AdminLoginPage;
import com.ecom.CiboObjectRepository.UserHomePage;
import com.ecom.CiboObjectRepository.UserLoginPage;

public class BaseClass {
	
	public  WebdriverUtility wLib = new WebdriverUtility();
	public  JavaUtility jLib = new JavaUtility();
	public   FileUtility fLib = new FileUtility();
	public    ExcelUtility eLib = new	ExcelUtility();
	public static WebDriver driver;
	
	//CONNECT DATABASE
	@BeforeSuite(groups={"systemTest","IntegrationTest"})
	public void config_BS() {
		System.out.println("------DataBase connected-----------");
	}
	//@Parameters("BROWSER")
	//LAUNCH THE BROWSER
	@BeforeClass(groups={"systemTest","IntegrationTest"})
	public void config_BC() throws IOException {
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		 
		 if(BROWSER.equalsIgnoreCase("Chrome")) 
		 {
			 driver=new ChromeDriver();
	 }else
	 {
		 driver=new FirefoxDriver();
	 } 
		 wLib.maximizeWindow(driver); 
		 
		 System.out.println("----open the browser successfully------");
	}
	
	//LOGIN TO THE APPLICATION
	@BeforeMethod(groups={"systemTest","Integrationtest"})
	public void config_BMLogin() throws IOException {
        //USER CREDENTIALS
	/*	String USERURL = fLib.getPropertyKeyValue("Userurl");
		String UuSERNAME = fLib.getPropertyKeyValue("Uusername");
		String UserPASSWORD = fLib.getPropertyKeyValue("Uuserpswd");  */
		//ADMIN CREDNETIALS
		 String ADMINURL = fLib.getPropertyKeyValue("adminurl");
		String ADMINUSERNAME = fLib.getPropertyKeyValue("adminusername");
		String ADIMPASSWORD = fLib.getPropertyKeyValue("adminpswd");  
		wLib.waitTillPageGetsLoad(driver);
		//USER LOGIN
	/*	driver.get(USERURL);
		UserHomePage uHome = new UserHomePage(driver);
		uHome.clickLoginModule();
		UserLoginPage ulogin=new UserLoginPage(driver);
		ulogin.getUsername(UuSERNAME);
		ulogin.getPassword(UserPASSWORD);
		ulogin.clickLoginbtn() ;   */
 	
	
		//ADMIN LOGIN
	  driver.get(ADMINURL);
		AdminLoginPage alogin = new AdminLoginPage(driver);
		alogin.getAdminUsername(ADMINUSERNAME);
		alogin.getAdminpassword(ADIMPASSWORD);
		alogin.clickOnAdminloginbtn();  
		System.out.println("----------LOGGED IN SUCCESSFULLY-------");
	}
	//LOGOUT TO THE APPLICATION
	@AfterMethod(groups={"systemTest","Integrationtest"})
	public void confid_AMLogout() throws InterruptedException {
		/* UserHomePage uHome = new UserHomePage(driver);
		uHome.clicklogoutmodule();  */

		AdminHomePage aHome = new AdminHomePage(driver);
		aHome.clickOnAdminlogoutImg();
		aHome.clickOnAdminlogout();  
		System.out.println("-----LOGGED OUT SUCCESSFULLY----"); 
	} 
	//CLSOE THE BROWESER
	@AfterClass(groups={"systemTest","Integrationtest"})
	public void config_ACCloseBrowser() {
	
	  driver.quit();
		  System.out.println("--------closed browser successfully---");
	}
	//CLOSE THE DATABASE CONNECTION
	@AfterSuite(groups={"systemTest","Integrationtest"})
	public void config_ASCloseTheDB() {
		System.out.println("-----DataBase Connection Closed-------");
	}
   
}
