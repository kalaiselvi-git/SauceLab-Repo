package stack;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class TestBrowserStack
{

  public static final String USERNAME = "kalai39";
  public static final String AUTOMATE_KEY = "UcqSYc4wwyx5FVvLcbzE";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {

    //DesiredCapabilities caps = DesiredCapabilities.safari();
    //caps.setPlatform(Platform.WIN8);
    //caps.setCapability("browserstack.debug", "true");
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("browserName", "iPhone");
	  caps.setPlatform(Platform.MAC);
	  caps.setCapability("device", "iPhone 5");
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("BrowserStack");
    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }
}
