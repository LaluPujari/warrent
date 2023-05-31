package TestCaseExecution;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase49 {

	public static void main(String[] args) {
		
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
		
		//click on restaurant module
		driver.findElement(By.xpath("//a[.='Restaurants ']")).click();
		
		//click on particular restaurant view menu button
		driver.findElement(By.xpath("//a[.='North Street Tavern']/ancestor::div[@class='col-xs-12 col-sm-7 col-md-7 col-lg-9']/descendant::div[6]/descendant::a[.='View Menu']")).click();
		//click on particular dish add to cart button
		driver.findElement(By.xpath("//a[.='Yorkshire Lamb Patties']/ancestor::div[@class='food-item']/descendant::input[@value='Add To Cart']")).click();
		//click on checkout button
		driver.findElement(By.xpath("//a[.='Checkout']")).click();
		
		// select payment option
		driver.findElement(By.xpath("//span[.='Cash on Delivery']")).click();
		//click on orderNow button
		driver.findElement(By.xpath("//input[@value='Order Now']")).click();
		
		//accept the alert popup
		driver.switchTo().alert().accept();
		
		//explicitwait for alretpresent in between 
		w.until(ExpectedConditions.alertIsPresent());
		//accept the alert popup
		driver.switchTo().alert().accept();
		
		
		//verify dish is ordered or not
	List<WebElement> dishnames = driver.findElements(By.xpath("//td[@data-column='Item']"));
	// w.until(ExpectedConditions.VisibilityOf().dishnames);
		boolean b=false;
	for(int i=0;i<dishnames.size();i++)
	{
		
	String dishname = dishnames.get(i).getText();
	if(dishname.contains("Yorkshire Lamb Patties"))
	{
		System.out.println(" dish is orderd");
		b= true;
		break;
	}
	}
	if(!b)
	{
		System.out.println(" dish is not oredred");
	}
	
	//logout the application
	driver.findElement(By.xpath("//a[.='Logout']")).click();
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
