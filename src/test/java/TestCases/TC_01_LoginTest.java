package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClassess.LoginBaseClass;
import PageObject.LoginPage;

public class TC_01_LoginTest extends LoginBaseClass{

	@Test
	public void loginTest()
	{
		
		driver.get(base_url);
		lp=new LoginPage(driver);
		lp.setUsername(usernameBS);
		logger.info("Username set");
		lp.setPassword(passwordBS);
		logger.info("Password set");
		lp.clickLoginButton();
		logger.info("Click on login button");
		
		if(alertIsPresent()==true)
		{
			logger.info("Test CAse Failed...........");
			driver.switchTo().alert().accept();
			logger.info("Login failed Alert Acceoed");
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("Test Case Passed........");
			Assert.assertTrue(true);
			lp.clickLogoutButton();
			driver.switchTo().alert().accept();
			logger.info("Logout Alert Acceoed");
		}
		
		
	}
	
	public boolean alertIsPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
