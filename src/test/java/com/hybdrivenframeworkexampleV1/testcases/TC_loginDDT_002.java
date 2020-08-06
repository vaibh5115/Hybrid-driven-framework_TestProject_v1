package com.hybdrivenframeworkexampleV1.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybdrivenframeworkexampleV1.pageobjects.loginPage;
import com.hybdrivenframeworkexampleV1.utilities.XLUtils;

public class TC_loginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginTest(String usr,String pwd) throws InterruptedException, IOException
	{
		driver.get(baseUrl);
		log.info("Url is opened...");
		loginPage lp=new loginPage(driver);
		lp.setUsername(usr);
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
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path="E:\\Study\\Maven_Project_Data\\HybDrivenFrameworkExampleV1\\src\\test\\java\\com\\hybdrivenframeworkexampleV1\\testdata\\hybdriventestdata.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcnt=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][colcnt];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcnt;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
	}
}
