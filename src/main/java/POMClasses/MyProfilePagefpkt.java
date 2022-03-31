package POMClasses;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility1;

public class MyProfilePagefpkt extends Utility1 {
	WebDriver driver;
	@FindBy(xpath="//div[text()='ACCOUNT SETTINGS']")
	private WebElement Accountsetting;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement Adressupdate;
	
	@FindBy(xpath="//div[text()='ADD A NEW ADDRESS']")
	private WebElement AddNewaddress;
	
	
	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement Areadetails;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement Save;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> listofaddress;
	
	public MyProfilePagefpkt(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public String accountsettting()
	{
		wait(driver, Accountsetting);
		return Accountsetting.getText();
	}
	
	public void clickonmanageadaddress()
	{
		wait(driver, Adressupdate);
		Adressupdate.click();
	}  
	
	public void ClickonAddnewAddress()
	{
		wait(driver, AddNewaddress);
		AddNewaddress.click();
	}
	public void insertaddress(List<String>datalist) throws EncryptedDocumentException, IOException
	{
		//List<String> list=getdatafromExcel(1,4);
		List<String> list=datalist;
		
		for(int i=1; i<=4; i++)
		{
		WebElement typeaddress=driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
		
		typeaddress.sendKeys(list.get(i-1));
		
		}
		wait1(driver, Areadetails);
		Areadetails.sendKeys("Near ganesh mandir");
		
	}
	
	//(//input[@type='text'][2-3-4-5])
	
//	public void AddAreadetails()
//	{
//		
//      Areadetails.sendKeys("Near ganesh mandir");
//	}
	
	public void savenewaddress()
	{
		wait(driver, Save);
		Save.click();
	}
	
	public int checkaddresscount() throws InterruptedException
	{
		Thread.sleep(2000);
		return listofaddress.size();

	}

	

}
