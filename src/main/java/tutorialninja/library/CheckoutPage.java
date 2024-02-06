package tutorialninja.library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tutorialninja.utils.Ninjautils;

public class CheckoutPage extends Ninjautils{
	
	
	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(1000));
	
	
	
	public void Billingdetails() {
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0,300)");
		  
		  
		WebElement billingbtn = driver.findElement(By.xpath("(//input[@value='Continue'])[1]"));
		 
		wait.until(ExpectedConditions.elementToBeClickable(billingbtn));
		billingbtn.click();
		
		
		}
	  
	
	  public void Deliverydetails() {
		  
		  
		  
		  WebElement deliverydetailsbtn = driver.findElement(By.xpath("(//input[@value='Continue'])[2]"));
		
		  wait.until(ExpectedConditions.elementToBeClickable(deliverydetailsbtn));
	        deliverydetailsbtn.click();

	}
	
	  public void Deliverymethod() throws InterruptedException {
		  
		 
		  WebElement deliverymethodbtn = driver.findElement(By.xpath("//input[@id='button-shipping-method']"));
		  
		  wait.until(ExpectedConditions.elementToBeClickable(deliverymethodbtn));
		  deliverymethodbtn.click();
		  
		  Thread.sleep(1000);
		
		
	}
	
	
	public void Paymentmethod() {
		
		
		  
		driver.findElement(By.name("agree")).click();
		
		
		WebElement paymentbtn = driver.findElement(By.xpath("//input[@id='button-payment-method']"));
	    
		wait.until(ExpectedConditions.elementToBeClickable(paymentbtn));
		paymentbtn.click();
	}
	
	
	public void Confirmpayment() {
		
		
		
		WebElement confirmbtn = driver.findElement(By.xpath("//input[@id='button-confirm']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(confirmbtn));
		confirmbtn.click();
	}
}
