package BaseClassess;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import PageObject.LoginPage;
import Utilities.ReadProperty;
import Utilities.XLUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginBaseClass {
	ReadProperty rp=new ReadProperty();
	public WebDriver driver;
	public String base_url=rp.getApplicationUrl();
	public String usernameBS=rp.getUSername();
	public String passwordBS=rp.getPassword();
	public Logger logger;
	public LoginPage lp;
	
	XLUtils xl=new XLUtils();
	
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		logger=logger.getLogger("GuruBanking");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearUp()
	{
		driver.quit();
	}
	
	
}
