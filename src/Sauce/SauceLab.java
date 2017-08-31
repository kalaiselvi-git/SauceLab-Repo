package Sauce;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class SauceLab
{
	private WebDriver driver;
	protected String sessionid;
	@BeforeClass
	@org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception
	{
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "P1");
	    capability.setCapability("build", "1.0");
	    //driver = new RemoteWebDriver(new URL("https://kalaiselvi-sauce:f5c9d16b-ee58-4501-9cf5-6d1e400777e8@ondemand.saucelabs.com:443/wd/hub"),
	      //capability);
	    driver = new RemoteWebDriver(new URL("https://preethi-saucelab:808ab5e6-f310-4257-ad2f-0ee30cef498a@ondemand.saucelabs.com:443/wd/hub"),
	  	      capability);
	    
	    this.sessionid=(((RemoteWebDriver) driver).getSessionId()).toString();
	  }
		 @AfterClass
	  public void tearDown() throws Exception 
	  {
	    driver.quit();
	  }
		
		/*
		 @Override
		 public String getSessionId()
		{
					return sessionid;
			
		}*/
		@Test
		public void testsimple() throws Exception
		{
			driver.get("http://www.calculator.net");
			/*System.out.println("Page Title is:"+driver.getTitle());
			WebElement element=driver.findElement(By.name("q"));
			element.sendKeys("BrowserStack");
			element.submit();*/
			driver.findElement(By.xpath(".//*[@id='hl3']/li[3]/a")).click();//click on percent calculators
			driver.findElement(By.id("cpar1")).sendKeys("10");//Enter First Value
			driver.findElement(By.id("cpar2")).sendKeys("100");//Enter Second Value
			driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();//Click calculate button
			String result=driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
			System.out.println("The Result is " +result);
			if(result.equals("10"))
			{
				System.out.println("Test Case is Passed");
				
			}
			else
			{
			System.out.println("Test case is Failed");
		
			}
			driver=new Augmenter().augment(driver);
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			try
			{
				FileUtils.copyFile(srcFile,new File("Screenshot.png"));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}


}
