package TestCaseExecution;

	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	public class TestCase60 {

		public static void main(String[] args) {
			// open Chrome Browser
			WebDriver driver = new ChromeDriver();
			// implicit wait for the elements to display
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//Create reference variable of WebDriverWait class to give conditional waiting mechanism
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// maximize the window
			driver.manage().window().maximize();
			// Enter the Admin URl
			driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/ ");
			// Enter the username in username textField
			driver.findElement(By.name("username")).sendKeys("admin");
			// Enter the password in password textfield
			driver.findElement(By.name("password")).sendKeys("codeastro");
			// click on login button
			driver.findElement(By.name("submit")).click();
			// verify whether adminPanel page is Displayed or not
			wait.until(ExpectedConditions.titleContains("Panel"));
			String title = driver.getTitle();
			if (title.contains("Admin Panel")) {
				System.out.println("Admin Panel Page is Disaplayed");
			} else {
				System.out.println("Admin Panel Page is not Displayed");
			}
			// click on the orders module
			driver.findElement(By.xpath("//span[text()='Orders']")).click();
			//Verify My orders Page Should be Displayed
			wait.until(ExpectedConditions.titleContains("Orders"));
			String orderTitle=driver.getTitle();
			if(orderTitle.contains("Orders")) {
				System.out.println("My orders Page is Displayed");
			}
			else
				System.out.println("My orders Page is not Displayed");
			//click edit icon
			driver.findElement(By.xpath("//table//td[.='Prawn Crackers']/..//a[2]")).click();
			//Verify View oders Page Should be Displayed
			wait.until(ExpectedConditions.titleContains("Order"));
			String viewOrderTitle=driver.getTitle();
			if(viewOrderTitle.contains("View Orders")) {
				System.out.println("View orders Page is Displayed");
			}
			else
				System.out.println("View orders Page is not Displayed");
			//verify Update order button is Displyed or not
			if(driver.findElement(By.xpath("//button[.='Update Order Status']")).isDisplayed()) {
				System.out.println("Update order button is Displayed");
			}
			else
				System.out.println("Update order button is not Displayed");
			
			//verify View User Details button is Displayed or not
			if(driver.findElement(By.xpath("//button[.='View User Detials']")).isDisplayed()) {
				System.out.println("View User Details button is Displayed");
			}
			else
				System.out.println("View User Details button is Displayed is not Displayed");
			//click on Update order button
			driver.findElement(By.xpath("//button[.='Update Order Status']")).click();
			//Switch to child window and verify Order update child window is opened or not
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		String chtitle=null;
		for (String cw : childWindow) {
			driver.switchTo().window(cw);
			 chtitle = driver.getTitle();	
		}
		if(chtitle.contains("Order update")) {
			System.out.println("order update child window  is Displayed");
		}
		else
			System.out.println("order update child window  is not Displayed");
		
		//Select the order status
		Select sel=new Select(driver.findElement(By.name("status")));
		sel.selectByVisibleText("On the way");
		//write the comment
		driver.findElement(By.name("remark")).sendKeys("Your order is on the Way");
		//click on the submit button
		driver.findElement(By.name("update")).click();
		//verify the Form Details Updated Successfully alert is displayed and accept it
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		//Switch back to Parent window
		driver.switchTo().window(parentWindow);
			// logout from the Application
			driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
			driver.findElement(By.xpath("//a[text()=' Logout']")).click();
			driver.quit();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


