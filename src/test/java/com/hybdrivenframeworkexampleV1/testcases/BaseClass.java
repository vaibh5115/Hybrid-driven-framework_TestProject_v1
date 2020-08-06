package com.hybdrivenframeworkexampleV1.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.Log4jEntityResolver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.hybdrivenframeworkexampleV1.utilities.readConfig;

public class BaseClass 
{

	readConfig read=new readConfig();
	public String baseUrl=read.getAppURL();
	public String userName=read.getUserName();
	public String pwd=read.getPass();
	public static WebDriver driver;
	public static Logger log;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String NameOfBrowser)
	{
		log=Logger.getLogger("hybdrivenframeworkexampleV1");
		PropertyConfigurator.configure("Log4j.properties");
		
		//System.setProperty("webdriver.chrome.driver", "E:\\Study\\Maven_Project_Data\\HybDrivenFrameworkExampleV1\\Drivers\\chromedriver.exe");
		if(NameOfBrowser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", read.getChromePath());
		driver=new ChromeDriver();
		}
		else if(NameOfBrowser.equals("MSEdge"))
		{
			System.setProperty("webdriver.edge.driver", read.getMSEdgePath());
			driver=new EdgeDriver();
		}
		
	}
	
	@AfterClass
	
	public void SetupClosed()
	{
		driver.close();
	}
	
	//taking screenshots of failed test cases
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}


