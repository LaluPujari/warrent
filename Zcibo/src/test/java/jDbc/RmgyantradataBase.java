package jDbc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RmgyantradataBase {

	public static void main(String[] args) {
		String project = "cibo_warrent2";
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		
		
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(project);
		driver.findElement(By.name("createdBy")).sendKeys("lalappa");
		WebElement ele = driver.findElement(By.name("status"));
		
		Select s= new Select(ele);
		s.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
		


	}

}
