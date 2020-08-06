package com.hybdrivenframeworkexampleV1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage 

{
	public WebDriver ldriver;
	
	public loginPage(WebDriver rDriver)	
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="Email")
	WebElement txtUserName;
	
	@FindBy(id="Password")
	WebElement txtPass;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")
	WebElement loginbtn;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div/ul/li[3]/a")
	WebElement logoutbtn;
	
	
	public void setUsername(String uname) 
	{
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}
	
	public void setPass(String pass) 
	{
		txtPass.clear();
		txtPass.sendKeys(pass);
	}
	
	public void clikOnlogin_btn() 
	{
		loginbtn.click();
	}
	
	public void clikOnlogout_btn() 
	{
		logoutbtn.click();
	}
	
}


