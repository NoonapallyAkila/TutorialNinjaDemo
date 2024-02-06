package tutorialninja.scripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import tutorialninja.library.Cart_Page;
import tutorialninja.library.CheckoutPage;
import tutorialninja.library.Home_Page;
import tutorialninja.library.SelectproductPage;
import tutorialninja.utils.Ninjautils;

public class NinjaEndtoEndTest {
	
public static WebDriver driver;
	
	public static String URL="https://tutorialsninja.com/demo/";
	
	public static WebDriverWait WebDriverWait ;
	
	public static ExtentReports extent;

	public static ExtentTest test;
	
	
	@BeforeSuite
	public void launchapp() throws IOException {
		
		Ninjautils.launchapp();
		
      String path = System.getProperty("user.dir")+"\\reports\\htmlreport";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Tutorialninja Demoreport");
		
		reporter.config().setDocumentTitle("Tutorialninja Demo Title");
		
		  extent = new ExtentReports();
		 
		 extent.attachReporter(reporter);
		 
		 extent.setSystemInfo("Operatingsystem", "windows10");
		
		 test = extent.createTest("Testcase 1");
		  test.info("navigated to application ");
		  test.pass("landed to homepage");

}
	
	
	@BeforeTest
	public void Loginintoapp() throws InterruptedException, IOException {
		
     Home_Page hop = new Home_Page();
     		
		hop.Login();
		

		test = extent.createTest("Testcase 2");
		 test.info("Navigated to loginpage");
		
		 test.pass("successfully Navigated to loginpage");

		
		hop.Loginwithvaliddetails(hop.prop("Email"),hop.prop("pass"));
		
		test = extent.createTest("Testcase 3");
		 test.info("Entered user email and password  ");
		
		 test.pass("successfully login into application");

		
	}
	
	@Test(priority=0)
	
	public void Selectproduct() throws InterruptedException {
		
		 Home_Page hop = new Home_Page();
			
		hop.selectproduct();
		test = extent.createTest("Testcase 4");
		test.info(" select the product from components");
		test.pass(" Selected the product");

		
		
		}
	
	 @Test(priority=1)
	 
	 public void Addproducttocart() throws AWTException, InterruptedException, IOException {
		 
		 
		 SelectproductPage spp = new SelectproductPage();
			
		  String text = Ninjautils.prop("text");
			spp.addproducttocart(text);
			
			test = extent.createTest("Testcase 5");
			test.info(" Enter desired requirement of product");
			test.info(" Upload required file");
			test.pass("Expected text is visible on popup");
			
			
	 }
	 
	 
	/* @Test(priority=2)
	 
	 public void Adddetailsofproduct() {
		 
		 SelectproductPage spp = new SelectproductPage();
		 
		 spp.adddetailsofproduct();
		 
		 test = extent.createTest("Testcase 6");
			test.info(" add product to cart ");
			test.pass("successfully added product to cart");

			

		 }*/
	 
	  @Test(priority=3)
	  
	  public void  viewcart() throws InterruptedException {
		  
		  
		  Cart_Page cp = new Cart_Page();
			
			cp.viewcart();
			test = extent.createTest("Testcase 7");
			test.info(" View product in cart and then checkout ");
			test.pass("Successfuly sended product to checkout");
			
	  }
	  
	  @Test(priority=4)
	  
	  public void Billingdetails() {
		  
		  CheckoutPage cop = new CheckoutPage();
			
			cop.Billingdetails();
			test = extent.createTest("Testcase 8");
			test.info(" Add address details for billing ");
			test.pass("selected address for billing");
			
	  }
	  
	  @Test(priority=5)
	  
	  public void  Deliverydetails() {
		  
		  CheckoutPage cop = new CheckoutPage();
		  cop.Deliverydetails();
		  test = extent.createTest("Testcase 9");
			test.info(" Add address for delivery  ");
			test.pass(" Address added successfuly");
	  }
	  
	  @Test(priority=6)
	  
	  public void  Deliverymethod() throws InterruptedException {
		  
		  CheckoutPage cop = new CheckoutPage();
		  cop.Deliverymethod();
		  test = extent.createTest("Testcase 10");
			test.info(" Add any requirement for delivery ");
			test.pass(" test case is passe for delivery");
	  }
	  
	  
	  @Test(priority=7)
	  
	  public void Paymentmethod() {
		  
		  CheckoutPage cop = new CheckoutPage();
		  cop.Paymentmethod();
		  test = extent.createTest("Testcase 11");
			test.info(" Select the conform box ");
			test.pass(" Payment is completed ");
			
	  }
      
	  @Test(priority=8)
	  
	  public void Confirmpayment() {

		  CheckoutPage cop = new CheckoutPage();
		  cop.Confirmpayment();
		  test = extent.createTest("Testcase 12");
			test.info(" Click on confirm payment  ");
			test.pass(" order is placed");
			
	  }
	  
	  @AfterTest
	  
	  public void logout() throws InterruptedException {
		  
		  Thread.sleep(2000);
		  Home_Page hop = new Home_Page();
		  hop.logout();
		  test = extent.createTest("Testcase 13");
			test.info(" Select the logout option ");
			test.pass("logout from application");
		  
	  }
	  
	  @AfterSuite
	  
	  public void closeapp() {
		  
		  Ninjautils.closeapp();
		  test = extent.createTest("Testcase 14");
			test.info(" test completed ");
			test.pass(" closed the browser");
			extent.flush();
	  }
	  
	  

}
