package cibo_WarrentGenriclib;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author User
 *
 */

public class WebdriverUtility {
	/**
	 * this method is used to maximize the browser windows
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to minimize the browser windows
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method is used to till page gets load
	 * @param driver
	 */
	public void waitTillPageGetsLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstants.implicitWaitDuration));
	}
	/**
	 * this method is used for wait till element to be visiblein the UI
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToVisible(WebDriver driver,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IpathConstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to be wait till click on UI
	 * @param driver
	 * @param element
	 */
      public void waitTillElementToBeClickable(WebDriver driver,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IpathConstants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
      /**
       * this methos used to wait till alert is present
       * @param driver
       * @param element
       */
      public void waitAlertIsPresent(WebDriver driver) {
  		
  		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IpathConstants.ExplicitWaitDuration));
  		wait.until(ExpectedConditions.alertIsPresent());
  	}
      /**
       * this method waits untill the title to be visible in the webpage
       * @param driver
       * @param title
       */
      public void waitForTitle(WebDriver driver, String title) {
    		
    		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IpathConstants.ExplicitWaitDuration));
    		wait.until(ExpectedConditions.titleContains(title));
    	}
      /**
       * this method wait untill the url to be visible in the webpage
       * @param url
       * @param driver
       */
      public void waitForUrl(String url,WebDriver driver) {
  		
  		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IpathConstants.ExplicitWaitDuration));
  		wait.until(ExpectedConditions.urlContains(url));
  	}
      /**
       * this method will ignore if its get  NosuchElementException
       * @param driver
       */
      public void ignorNoSuchElementException(WebDriver driver) {
    		
    		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IpathConstants.ExplicitWaitDuration));
    		wait.ignoring(NoSuchElementException.class);
      }
      /**
       * 
       * @param element
       * @param index
       */
      
      public void selectElementInDropdown(WebElement element,int index) {
    	  Select select = new Select(element);
    	  select.selectByIndex(index);
      }
      /**
       * 
       * @param element
       * @param value
       */
      
      public void selectElementInDropdown(WebElement element,String value) {
    	  Select select = new Select(element);
    	  select.selectByValue(value);
      }
      /**
       * 
       * @param text
       * @param element
       */
      
      public void selectElementInDropdown(String text,WebElement element) {
    	  Select select = new Select(element);
    	  select.selectByVisibleText(text);
      }
      /**
       * 
       * @param element
       */
      
      public void getAllIptionsFromDropdown(WebElement element) {
    	  Select select = new Select(element);
    	  List<WebElement> options = select.getOptions();
    	  for(WebElement option:options)
    	  {
    		  String text = option.getText();
    		  System.out.println(text);
    	  }
      }
      /**
       * 
       * @param driver
       * @param ele
       */
      
      public void mousHoverOnElement(WebDriver driver, WebElement element) {
  		
  		Actions actions = new Actions(driver);
  		actions.moveToElement(element).perform();
      }
      /**
       * 
       * @param driver
       * @param ele
       */
      
      public void rightClickOnElement(WebDriver driver, WebElement element) {
  		Actions actions = new Actions(driver);
  		actions.contextClick(element).perform();
      }
      /**
       * 
       * @param driver
       * @param element
       */
      
      public void  doubleClickOnElement(WebDriver driver,WebElement element) {
  		
  		Actions actions = new Actions(driver);
  		actions.doubleClick(element).perform();
  	}
      /**
       * 
       * @param driver
       * @param index
       */
      public void switchToFrame(WebDriver driver,int index) {
  		driver.switchTo().frame(index);
  	}
      /**
       * this method is to switch frame based on id 
       * @param driver
       * @param id
       */
      public void switchToFrame(WebDriver driver,String id) {
    		driver.switchTo().frame(id);
    	}
      /**
       * this method is to switch to frame based on WebElement
       * @param driver
       * @param element
       */
      public void switchToFrame(WebDriver driver,WebElement element) {
  		driver.switchTo().frame(element);
  	}
      /**
       * this method is to switch to the main frame of webpage
       * @param driver
       */
      public void switchToFrame(WebDriver driver) {
    		driver.switchTo().defaultContent();
    	}
      /**
       * 
       * @param driver
       */
      public void switchToAlertPopupAndAccept(WebDriver driver,String text) {
  		Alert alt = driver.switchTo().alert();
  		if(alt.getText().trim().equalsIgnoreCase(text.trim()))
  		{
  			System.out.println("alert is present");
  		}else
  		{
  			System.out.println("alert is not present");
  		}
  		alt.accept();
  	}
      /**
       * 
       * @param driver
       * @param text
       */
      public void switchToAlertPopupAndDismiss(WebDriver driver,String text) {
    		Alert alt = driver.switchTo().alert();
    		if(alt.getText().trim().equalsIgnoreCase(text.trim()))
    		{
    			System.out.println("alert is present");
    		}else
    		{
    			System.out.println("alert is not present");
    		}
    		alt.dismiss();
    	}
      /**
       * 
       * @param element
       * @param path
       */
      public void fileUpload(WebElement element, String path) {
    	  element.sendKeys(path);
      }
      /**
       * 
       * @param duration
       * @param element
       * @param pollingTime
       */
      public void customWait(int duration,WebElement element,long pollingTime) {
    	  int count=0;
    	  while(count>duration) 
    	  {
    		  try {
    			  element.click();
    			  break;
    		  }catch(Exception e) {
    			  try {
    				  Thread.sleep(pollingTime);
    			  }catch(InterruptedException e1) {
    				  e1.printStackTrace();
    			  }
    			  count++;
    		  }
    	  }
      }
      /**
       * 
       * @param driver
       * @param Screenshotname
       * @return
       * @throws IOException
       */
      
      
      public String takeScreenShot(WebDriver driver,String Screenshotname) throws IOException {
    	  
    	  TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
    	  LocalDate localDate = LocalDate.now();
    	  String datetime = localDate.toString().replace(" ", " ").replace(": ", "_");
    	File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
    	File dest = new File("./Screenshot"+Screenshotname+" "+localDate+" "+datetime+".png");
    	FileUtils.copyFile(src, dest);
    	return Screenshotname;
      }
      public void switchWindow(WebDriver driver, String title) {
    	  
    	  Set<String> set = driver.getWindowHandles();
    	  for(String wd: set)
    	  {
    		  driver.switchTo().window(wd);
    		  String text = driver.getTitle();
    		  if(text.contains(title))
    		  {
    			  break;
    		  }
    	  }
      }
      
    
      
      
      
  
	
	
	
	

}
