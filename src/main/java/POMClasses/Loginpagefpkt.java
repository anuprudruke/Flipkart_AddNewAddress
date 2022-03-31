package POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility1;

public class Loginpagefpkt extends Utility1 {
	WebDriver driver;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement login;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pwd;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement submit;
	
	public Loginpagefpkt(WebDriver driver)
	{
		
        PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void username1() throws IOException
	{
		//login.sendKeys("8600244579");
		login.sendKeys(getconfigData("mobno"));
	
	}
	public void EneterPassword() throws IOException
	{
		//pwd.sendKeys("Fpkt@1947");
		pwd.sendKeys(getconfigData("pwd"));
	}
	
	public void submitdetails()
	{
		submit.click();
	}
	

}
