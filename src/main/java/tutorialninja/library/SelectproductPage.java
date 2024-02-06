package tutorialninja.library;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tutorialninja.utils.Ninjautils;

public class SelectproductPage extends Ninjautils{
	
	
	WebElement Product = driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&path=25_28&product_id=42'][contains(.,'Apple Cinema 30\"')]"));
	
	
	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(1000));

	public void addproducttocart(String text) throws AWTException, InterruptedException, IOException  {
		
		 
		Product.click();
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
 		  jse.executeScript("window.scrollBy(0,800)");
 		
 		  try {
	   
 			 WebElement radiobtn = driver.findElement(By.xpath("(//input[@type='radio'])[6]"));
	
	   wait.until(ExpectedConditions.elementToBeClickable(radiobtn));
	     radiobtn.click();
	     

		 } catch (Exception e) {
		        // Handle the exception or log it (optional)
		        e.printStackTrace();
		    }
	
	   WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
	
	   wait.until(ExpectedConditions.elementToBeClickable(checkbox));

	     checkbox.click();
	
	
	   WebElement value = driver.findElement(By.xpath("//select[@id='input-option217']"));
	
	     Select  select = new Select(value);
	
	     select.selectByValue("3");
	
	   WebElement area = driver.findElement(By.id("input-option209"));
	
	     area.sendKeys(text);
	     
	     Thread.sleep(1000);
	     
	     	     
	     WebElement file = driver.findElement(By.xpath("//button[@id='button-upload222']"));
	     
	     file.click();
	     
	     Robot robot = new Robot();
	     robot.delay(1000);
	     
	      StringSelection stringSelection = new StringSelection("D:\\USB Drive\\akhila\\automation");
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	     
	     robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         
         robot.keyRelease(KeyEvent.VK_CONTROL);
         robot.keyRelease(KeyEvent.VK_V);


         // Press Enter to confirm the file upload
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         
         wait.until(ExpectedConditions.alertIsPresent());

         Alert simplealert = driver.switchTo().alert();
        
		    String actualText = simplealert.getText();
		    System.out.println("Actual text is " + actualText);
		    String expectedText = Ninjautils.prop("ExpectedText");
		    System.out.println("Expected Text is " + expectedText);
      
          assertEquals(actualText, expectedText);
	        simplealert.accept();
	        
	        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
			  jse1.executeScript("window.scrollBy(0,300)");
			  
				WebElement Addtocart = driver.findElement(By.xpath("//button[@id='button-cart']"));
				
				wait.until(ExpectedConditions.visibilityOf( Addtocart));
				Addtocart.click();
		  
			  
	     }
	
	  
	public void adddetailsofproduct() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0,300)");
		  
		  
		
		 
		/*WebElement Calender = driver.findElement(By.xpath("(//i[@class='fa fa-calendar'])[1]"));
		 wait.until(ExpectedConditions.elementToBeClickable(Calender));
		Calender.click();
		  
		
		WebElement Date = driver.findElement(By.xpath("(//td[@class='day'][contains(.,'24')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(Date));

		Date.click();
		
		
			WebElement Quantity = driver.findElement(By.xpath("//input[@id='input-quantity']"));
			
			Quantity.clear();
			
			Quantity.sendKeys("1");*/
			
			WebElement Addtocart = driver.findElement(By.xpath("//button[@id='button-cart']"));
			
			Addtocart.click();
	  }
	



	
	}
