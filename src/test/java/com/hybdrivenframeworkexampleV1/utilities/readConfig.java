package com.hybdrivenframeworkexampleV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig 
{
	
	Properties pro;
	
	public readConfig()
	{
		File src= new File("./Configuration/Config.properties");
		
		try 
		{
			FileInputStream fis= new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}
	
	public String getAppURL()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUserName()
	{
		String uname=pro.getProperty("userName");
		return uname;
	}
	
	public String getPass()
	{
		String password=pro.getProperty("pwd");
		return password;
	}
	
	public String getChromePath()
	{
		String chromeBrPath=pro.getProperty("chromepath");
		return chromeBrPath;
	}
	
	public String getMSEdgePath()
	{
		String MSEdgeBrPath=pro.getProperty("MSEdgepath");
		return MSEdgeBrPath;
	}
	
	
	

}
