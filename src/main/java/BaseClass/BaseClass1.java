package BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import UtilityClass.Utility1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 extends Utility1 {
  
	public static WebDriver Flipkart(String a) throws IOException
	{
    	if(a.equals("chrome"))
    	{
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
		
		driver.get(getconfigData("url"));
		
		return driver;}
		
		else
		{
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup();
	    WebDriver driver=new FirefoxDriver();
  		
   		driver.get("https://www.flipkart.com/");
  		
  		   return driver;
		}
	
	}
    
//    @Parameters("browser1")
//   	public static WebDriver Flipkart1()
//   	{
//   		System.setProperty("webdriver.gecko.driver", "F:\\Automation_FIles\\Browser\\geckodriver.exe");
//          
//   	    WebDriver driver=new ChromeDriver();
//   		
//   		driver.get("https://www.flipkart.com/");
//   		
//   		return driver;
//   	
//   	}
}
