package jDbc;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateRmgy {

	public static void main(String[] args)  {
 
		 WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		
		List<WebElement> projectnames = driver.findElements(By.xpath("//table//td[2]"));
		String project = "cibo_warrent22";
		boolean b= false;
		 for(int i=0; i<projectnames.size();i++)
		 {
			if( projectnames.get(i).getText().equalsIgnoreCase(project))
			{
				System.out.println(project+" it is present in the application");
				b=true;
				break;
			}
		 }
		 if(!b) {
			 System.out.println(project+"it is not present in the application ");
		 } 
		
		 
 
		
		
	}
}	
		
  	



