package TestCaseExecution;

	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class TestCase46 {

		public static void main(String[] args) {
			// open Chrome Browser
			WebDriver driver = new ChromeDriver();
			// implicit wait for the elements to display
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
			// click on the restaurant to see submodules
			driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
			// click on Add category
			driver.findElement(By.xpath("//a[text()='Add Category']")).click();
			// Verify Add category Page is Displayed or not
			String categorytitle = driver.getTitle();
			if (categorytitle.contains("Add Category")) {
				System.out.println("Add Restaurant Category Page is Displayed");
			} else
				System.out.println("Add Category page is not displayed");
			// Write the category name In the category text field
			String categoryName = "pureVeg";
			driver.findElement(By.name("c_name")).sendKeys(categoryName);
			// Click on Save button
			driver.findElement(By.name("submit")).click();

			// Verify The added category is displayed inListed categories or not
			List<WebElement> listedCategoryNames = driver.findElements(By.xpath("//table//td[2]"));
			boolean ck = false;
			for (WebElement cName : listedCategoryNames) {
				if (cName.getText().contains(categoryName)) {
					System.out.println(categoryName + " is displayed in Listed categories");
					ck = true;
					break;
				}

			}
			if (!ck) {
				System.out.println(categoryName + " is not in Listed Categories and Test Fails");
			}
			// logout from the Application
			driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
			driver.findElement(By.xpath("//a[text()=' Logout']")).click();
			driver.close();
		}
	
	
	
	
	
	
	
	

}
