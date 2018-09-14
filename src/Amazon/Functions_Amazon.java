package Amazon;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Amazon.BaseClass;

public class Functions_Amazon extends BaseClass
{
	

	public static void ShopbyDept() throws Exception
	{
		try
		{
			WebElement ShopByDept = driver.findElement(By.xpath(Objects_Locators.getProperty("ShopbyDept")));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(ShopByDept.isDisplayed())
			{
				ShopByDept.click();
				System.out.println("clicked shop by dept");
			}
			
		}
		catch(Exception e)
		{
			Functions_Amazon.CaptureScreenshot();
			Assert.fail("shop by dept is not displayed/clicked");
		}	
	}

	public static void select_kindlepaperwhite() throws Exception
	{
		try
		{
			WebElement KindlePaperwhite = driver.findElement(By.xpath(Objects_Locators.getProperty("KindlePaperwhite")));
			if(KindlePaperwhite.isDisplayed())
			{
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				KindlePaperwhite.click();
				System.out.println("clicked Kindle Paperwhite");
			}
		}
		catch(Exception e)
		{
			Functions_Amazon.CaptureScreenshot();
			Assert.fail("Kindle Paperwhite not clicked/present");
		}
	}
	
	public static void select_quantity() throws Exception
	{
		try
		{
			WebElement selectquantity = driver.findElement(By.xpath(Objects_Locators.getProperty("SelectQuantity")));
			if(selectquantity.isDisplayed())
			{
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				WebElement quantity2 = driver.findElement(By.xpath(Objects_Locators.getProperty("quantity2")));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				quantity2.click();
				System.out.println("increased quantity to 2");
				
			}
			
		}
		catch(Exception e)
		{
			Functions_Amazon.CaptureScreenshot();
			Assert.fail("Quantity not selected ");
		}	
	}
	
	public static void add_to_cart() throws Exception
	{
		try
		{
				WebElement AddtoCart = driver.findElement(By.xpath(Objects_Locators.getProperty("AddtoCart")));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				AddtoCart.click();
				System.out.println("Clicked add to cart");
				WebElement CloseButton = driver.findElement(By.xpath(Objects_Locators.getProperty("CloseButton")));
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				if(CloseButton.isDisplayed())
				{
					System.out.println("new window is displayed, needs to be closed");
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					CloseButton.click();
					CloseButton.click();
					
					System.out.println("closed new window");
				}
			}
		catch(Exception e)
		{
			Functions_Amazon.CaptureScreenshot();
			Assert.fail("could not click on add to cart/could not close window ");
		}
		
	}
	
	public static void checkout() throws Exception
	{
		try
		{
		WebElement CheckoutButton = driver.findElement(By.xpath(Objects_Locators.getProperty("CheckoutButton")));
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			CheckoutButton.click();
			System.out.println("clicked on checkout");
			WebElement EmailLabel = driver.findElement(By.xpath(Objects_Locators.getProperty("EmailLabel")));
			if(EmailLabel.isDisplayed())
			{
				System.out.println("success, email /phone number to be entered by user- displayed");
			}
			
		
		}
		catch(Exception e){
			Functions_Amazon.CaptureScreenshot();
			Assert.fail("email/phone number not displayed on check out ");
		}
		
	}
	
	
	public static void CaptureScreenshot() throws Exception
    {
		try
		{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:/AmazonApp/Screenshots/"+System.currentTimeMillis()+".jpg"));
		}
		catch(IOException e)
		{

			System.out.println(e.getMessage());
		}
    }
	
	
	
	
}
