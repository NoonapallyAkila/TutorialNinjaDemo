package tutorialninja.testcases;

import java.awt.AWTException;
import java.io.IOException;

import tutorialninja.library.Home_Page;
import tutorialninja.library.SelectproductPage;
import tutorialninja.utils.Ninjautils;

public class SelectproductpageTest {
	
public static void main(String[] args)throws InterruptedException, IOException, AWTException {
		
		
		Ninjautils.launchapp();
		
		Thread.sleep(1000);
		
		Home_Page hop = new Home_Page();
		
		hop.Login();
		
		hop.Loginwithvaliddetails("noonapallyakhila01@gmail.com", "Akhi@2001");
		
		Thread.sleep(2000);
		
		hop.selectproduct();
		
		SelectproductPage spp = new SelectproductPage();
		
		spp.addproducttocart("add product");
		
		spp.adddetailsofproduct();
		
		
	}


}
