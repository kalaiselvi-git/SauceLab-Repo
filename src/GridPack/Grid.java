package GridPack;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;



public class Grid 
{
	public WebDriver driver;
	public String URL,Node;
	//protected ThreadLocal<RemoteWebDriver> threadDriver=null;
	
	@Parameters("browser")
	@BeforeTest
	public void testcalc(String browser) throws MalformedURLException
	{
	String URL="http://www.calculator.net";
	//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.out.println("Executing on Chrome");
		//System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver_2.28.exe");
		String Node="http://192.168.100.109:4442/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		driver=new RemoteWebDriver(new URL(Node),cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	}
	 	/*if(browser.equalsIgnoreCase("firefox"))
	{
		System.out.println("Executing on Firefox");
		String Node="http://192.168.100.109:4443/wd/hub";
		//System.setProperty("webdriver.gecko.driver","C:\\Driver 2\\geckodriver.exe");
		DesiredCapabilities cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN10);
		driver=new RemoteWebDriver(new URL(Node),cap);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}*/
	/*else if(browser.equalsIgnoreCase("ie"))
	{
		System.out.println("Executing on IE");
		String Node="http://192.168.100.109:4443/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
		cap.setBrowserName("ie");
		cap.setPlatform(Platform.WIN10);
		driver=new RemoteWebDriver(new URL(Node),cap);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}*/
	
	else if(browser.equalsIgnoreCase("chrome1"))
	{
		System.out.println("Executing on Chrome");
		//System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver_2.28.exe");
		String Node="http://192.168.100.109:4443/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		driver=new RemoteWebDriver(new URL(Node),cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(URL);
		driver.manage().window().maximize();
	}
	
	
	else if(browser.equalsIgnoreCase("chrome2"))
	{
		System.out.println("Executing on Chrome");
		//System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver_2.28.exe");
		String Node="http://192.168.100.109:5555/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		driver=new RemoteWebDriver(new URL(Node),cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		
	}
	}
	
	@Test
	public void calculatePercent() 
	{
		//driver.findElement(By.xpath(".//*[@id='hcalc']/table/tbody/tr/td[2]/div[3]/a")).click();//click on Math Calculators
		driver.findElement(By.xpath(".//*[@id='hl3']/li[3]/a")).click();//click on percent calculators
		driver.findElement(By.id("cpar1")).sendKeys("20");//Enter First Value
		driver.findElement(By.id("cpar2")).sendKeys("100");//Enter Second Value
		driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();//Click calculate button
		String result=driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
		System.out.println("The Result is " +result);
		if(result.equals("20"))
		{
			System.out.println("Test Case is Passed");
			
		}
		else
		{
		System.out.println("Test case is Failed");
	
		}
	}
	@AfterTest
	public void closeBrowser()
	{
		//driver.quit();
	}
}


