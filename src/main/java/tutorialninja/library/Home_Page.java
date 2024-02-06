package tutorialninja.library;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tutorialninja.utils.Ninjautils;

public class Home_Page extends Ninjautils {
	
	
	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(1000));
	

	WebElement Myaccount= driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]"));

	
	
	public  void  Login() {
		
		 Myaccount.click();
		
		
		  
		 WebElement Login = driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']"));
			
		 wait.until(ExpectedConditions.elementToBeClickable(Login));
		 Login.click();
	} 
		 
		 public void Loginwithvaliddetails(String email , String pwd) throws InterruptedException {
		 
			 WebElement Emailid = driver.findElement(By.id("input-email"));
			 
			 Emailid.sendKeys(email);
				
				WebElement Password = driver.findElement(By.id("input-password")) ;
				
				Password.sendKeys(pwd);
				
				WebElement Submit = driver.findElement(By.xpath("//input[@value='Login']"));
				  
				Submit.click();
						
				driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
				driver.navigate().back();
		 
	}
		 
		 public void selectproduct() throws InterruptedException {
			 
				
			 driver.navigate().back();
			 
			 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			 
			 Actions actions = new Actions(driver);
			 
			 WebElement Components = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[4]"));
			 
			 actions.moveToElement(Components).perform();
			 
			 try {
			 
			 WebElement selectComponent = driver.findElement(By.xpath("(//a[@href='https://tutorialsninja.com/demo/index.php?route=product/category&path=25_28'])[1]"));
		    	
			 selectComponent.click();
			 

			 } catch (Exception e) {
			        // Handle the exception or log it (optional)
			        e.printStackTrace();
			    }
			
             }
         
		 
		 public void logout() {
			 
			 
					 
			 wait.until(ExpectedConditions.elementToBeClickable(Myaccount));
			  
			 
			 Myaccount.click();
			
			 
			 WebElement Logout = driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/logout']"));
				
			 wait.until(ExpectedConditions.elementToBeClickable(Logout));
			  
			 Logout.click();
			 
		 }
}
