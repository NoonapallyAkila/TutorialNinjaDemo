
package tutorialninja.library;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tutorialninja.utils.Ninjautils;

public class Cart_Page extends Ninjautils {
	
	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(3000));
	
	
	public void viewcart() throws InterruptedException {
		
		try {
		WebElement Cartbtn = driver.findElement(By.xpath("//span[@id='cart-total']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(Cartbtn));
		Cartbtn.click();
		
		 } catch (Exception e) {
		        // Handle the exception or log it (optional)
		        e.printStackTrace();
		    }
		
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		try {
		WebElement cart = driver.findElement(By.xpath("//strong[contains(.,'View Cart')]"));
		
		
		wait.until(ExpectedConditions.visibilityOf(cart));
		cart.click();
		
		 } catch (Exception e) {
		        // Handle the exception or log it (optional)
		        e.printStackTrace();
		    }
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0,800)");
		  
		  WebElement checkoutbtn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		  
		  wait.until(ExpectedConditions.elementToBeClickable(checkoutbtn));
		  checkoutbtn.click();
	}

}
