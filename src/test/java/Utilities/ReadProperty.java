package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperty {
	
	Properties pr;
	public ReadProperty() 
	{
		try
		{
		String filePath=".//TestData//config.properties";
		FileInputStream fis=new FileInputStream(filePath);
		pr=new Properties();
		pr.load(fis);
		Thread.sleep(2000);
		
		}
		catch(Exception e)
		{
			System.out.println("File not found");
			
		}
	}
	
	public String getApplicationUrl()
	{
		return pr.getProperty("baseurl");
	}
	
	public String getUSername()
	{
		return pr.getProperty("username");
	}
	
	public String getPassword()
	{
		return pr.getProperty("password");
	}
	
	
}
