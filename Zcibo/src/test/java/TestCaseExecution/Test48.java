package TestCaseExecution;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test48 {
	// normal execution

	public static void main(String[] args) throws InterruptedException {
	   
		
		// open the browser
		  WebDriver driver=new ChromeDriver();
		   
		   //maximize the browser
		 	driver.manage().window().maximize();
		 	
		 	// enter the url
		 	driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		 	//implicitwait duration for 10sec
         	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(10));
	          
	     	//click on login module
		driver.findElement(By.xpath("//a[.='Login']")).click();
		
		//enter username
		driver.findElement(By.name("username")).sendKeys("Pritam@123");
		// enter password
		driver.findElement(By.name("password")).sendKeys("Pritam@123");
		//click on login button
		driver.findElement(By.id("buttn")).click();
		
		
		// verify home page is displaying 
		w.until(ExpectedConditions.titleContains("Home"));
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("Home"))
		{
			System.out.println(" home page is displaying");
		}else
		{
			System.out.println("home is not displaying");
		} 
		
		//click on my orders module
		driver.findElement(By.xpath("//a[.='My Orders']")).click();
		Thread.sleep(3000);
		
		//WebElement deleteitem = driver.findElement(By.xpath("//td[.=' 2023-05-15 14:52:35']/following-sibling::td[1]"));
		//deleteitem.click(); 
		
		
		//driver.switchTo().alert().accept();
		
		List<WebElement> items = driver.findElements(By.xpath("//td[5]"));
		boolean f= false;
		for(int i=0;i<items.size();i++)
		{
			String itemsname = items.get(i).getText();
			if(itemsname.contains("2023-05-15 14:52:35"))
			{
				System.out.println(" dish is not deleted");
				f= true;
				break;
			}
		}
		if(!f)
		{
			System.out.println(" dish is deleted");
		}
		
	
		
		
		
		//logout the application
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		
		
	
	}

}
