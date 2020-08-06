package com.hybdrivenframeworkexampleV1.testcases;
import com.hybdrivenframeworkexampleV1.testcases.BaseClass;
import com.hybdrivenframeworkexampleV1.pageobjects.loginPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HybDrivenFrameworkExampleV1_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseUrl);
		log.info("Url is opened...");
		loginPage lp=new loginPage(driver);
		lp.setUsername(userName);
		log.info("user name is provided...");
		lp.setPass(pwd);
		log.info("Password is provided...");
		
		lp.clikOnlogin_btn();
		log.info("login button is clicked...");
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clikOnlogout_btn();
			log.info("login test case is passed...");
		}
		else 
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			log.info("login test case is failed...");
		}
		
	}
	
}
