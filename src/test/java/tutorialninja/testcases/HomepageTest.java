package tutorialninja.testcases;

import java.io.IOException;

import tutorialninja.library.Home_Page;
import tutorialninja.utils.Ninjautils;

public class HomepageTest {
	
	public static void main(String[] args)throws InterruptedException, IOException {
		
		
		Ninjautils.launchapp();
		
		Thread.sleep(1000);
		
		Home_Page hop = new Home_Page();
		
		hop.Login();
		
		hop.Loginwithvaliddetails("noonapallyakhila01@gmail.com", "Akhi@2001");
		
		Thread.sleep(2000);
		
		hop.selectproduct();
		
		Thread.sleep(2000);
		
		hop.logout();
	}

}
