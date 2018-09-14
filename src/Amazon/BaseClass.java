package Amazon;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class BaseClass
{
	static WebDriver driver;
	public static FileInputStream fp;
	public static Properties Objects_Locators;
	
	
	 
	@Parameters("browser") //will pick up the browser based on the value provided in testng.xml
	@BeforeClass
	public static void loadbrowser(String browser) throws IOException
	{
		Objects_Locators = new Properties();
		fp = new FileInputStream(System.getProperty("user.dir")+"//src//Objects_Locators.properties");
		Objects_Locators.load(fp);
		
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		driver.get("http://www.amazon.ca");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();	
			driver.get("http://www.amazon.ca");
			}
		}	
	
	
	
	
	@Test(priority=0)
	public static void TC_01() throws Exception//click Shop By Dept, Select Kindle paper White and Increase Quantity to 2
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Functions_Amazon.ShopbyDept();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Functions_Amazon.select_kindlepaperwhite();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Functions_Amazon.select_quantity();
	}
	
	@Test(priority=1)// Click Add to Cart, Checkout and Verify Email/Phone Number page is displayed/asked
	
		public static void TC_02() throws Exception
		{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Functions_Amazon.add_to_cart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Functions_Amazon.checkout();
		}
	
	
	@AfterClass
	public void closedriver()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.quit();
	}
}








