package stack;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.Augmenter;

public class ParallelTestUsingBrowserStack 
{
	private WebDriver driver;
	
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
	    driver = new RemoteWebDriver(new URL("https://kalai39:UcqSYc4wwyx5FVvLcbzE@hub-cloud.browserstack.com/wd/hub"),
	      capability);
	  }
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
	
	 @AfterClass
	  public void tearDown() throws Exception 
	  {
	    driver.quit();
	  }
}
