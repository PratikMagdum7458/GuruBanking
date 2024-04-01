package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import BaseClassess.LoginBaseClass;
import PageObject.LoginPage;
import Utilities.XLUtils;

public class TC_02_DATTestCase extends LoginBaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pass)
	{
		driver.get(base_url);
		lp=new LoginPage(driver);
		lp.setUsername(user);
		logger.info("Username set");
		lp.setPassword(pass);
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

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String ExcelFilePath=".//DATTestData//LoginData1.xlsx";
		int rowcount=XLUtils.getRowCount(ExcelFilePath, "Sheet1");
		int cellcount=XLUtils.getCellCount(ExcelFilePath, "Sheet1", 1);
		
		String[][] loginData=new String[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int c=0;c<cellcount;c++)
			{
				loginData[i-1][c]=XLUtils.getCellData(ExcelFilePath, "Sheet1", i, c);
			}
		}
		return loginData;
	}
}	