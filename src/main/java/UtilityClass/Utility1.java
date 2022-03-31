package UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility1 {

	WebDriver driver;

	public static void movetoelement(WebDriver driver, WebElement element) {

		// WebElement myaccount=driver.findElement(By.xpath("//div[text()='My
		// Account']"));
		Actions act = new Actions(driver);

		act.moveToElement(element).build().perform();

	}
	
	public static void wait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		
	 wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public static void wait1(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
	 wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void MoveByoffset(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.moveByOffset(300, 0).release().perform();
	}
	
	public static List<String> getdatafromExcel(int firstrow, int lastrow) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("src\\main\\resources\\DataSheets\\Products.xlsx");
		
		List<String> listofaddress=new ArrayList<String>();  // List is in string format
		Sheet sheet=WorkbookFactory.create(file).getSheet("Address");
	
		for(int i=firstrow; i<=lastrow; i++)
		{
			try {
			String Stringdata=sheet.getRow(i).getCell(1).getStringCellValue();// this data may be in int format
			//String string=String.valueOf(data); //  convert int to string
			listofaddress.add(Stringdata); // addition of data into list
			}
			
			catch(Exception e)
			{
			long intdata=(long) sheet.getRow(i).getCell(1).getNumericCellValue();
				String string=String.valueOf(intdata);
				
				listofaddress.add(string);
			}
		}
	    
		return listofaddress;
	}
	
	public String screencpature(WebDriver driver) throws IOException
	{
		
		SimpleDateFormat dt= new SimpleDateFormat("YYYY-mm-hh-ss");
		String date=dt.format(new Date());
		TakesScreenshot sst= (TakesScreenshot)driver;
		
		File dst= new File("screenShot"+date+".png");
		File src=sst.getScreenshotAs(OutputType.FILE);
		
		String path=dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		
		return path;
	}
	public static String getconfigData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("configure\\ids.properties");//define file from where we want to fetch data
		Properties prop=new Properties();
		prop.load(file);
		
		return prop.getProperty(key);
	
	}
}
