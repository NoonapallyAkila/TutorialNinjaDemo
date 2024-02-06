package tutorialninja.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Ninjautils {
	
public static WebDriver driver;
	
	public static String URL="https://tutorialsninja.com/demo/";
	
	public static WebDriverWait WebDriverWait ;
	
	public static ExtentReports extent;

	public static ExtentTest test;
		
	public static void  launchapp() throws IOException{
		
	    
		
		driver = new ChromeDriver();
		
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.get(URL);
		
		}
	
	public static void closeapp() {
		
		driver.close();
		
	}
	
	
	
	public static String prop(String prop) throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Users\\Akila Noonapally\\eclipse-workspace\\tutorialninjademo\\src\\main\\resources\\propertiesdatafile\\ninjademofile");
		properties.load(fis);
		String Value = properties.getProperty(prop);
		return Value; 
	}
	
	public static void Extentreports() {
		
		String reportpath = System.getProperty("user.dir")+"\\reports\\htmlreport";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
		
		reporter.config().setReportName("Tutorialninja Demoreport");
		
		reporter.config().setDocumentTitle("Tutorialninja Demo Title");
		
		  extent = new ExtentReports();
		 
		 extent.attachReporter(reporter);
		 
		 extent.setSystemInfo("Operatingsystem", "windows10");
		
	}

}
