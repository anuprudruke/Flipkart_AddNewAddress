package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility1;

public class Homepagefpkt extends Utility1  {
	WebDriver driver;
	@FindBy(xpath="//div[text()='My Account']")
	private WebElement Myaccout;
	
	@FindBy(xpath="//div[text()='Logout']")
	private WebElement Logout;
	
	@FindBy(xpath="//div[text()='My Profile']")
	private WebElement Myprofile;
	
	
	public Homepagefpkt(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void movetomyaccount()
	{
		wait(driver, Myaccout);
		movetoelement(driver, Myaccout);
		
	}
	
	public String gettext()
	{
		return Logout.getText();
	}
	
	public void hovertomyprofile()
	{
		wait(driver, Myprofile);
		movetoelement(driver, Myprofile);
	}
	public void clickonmyprofile()
	{
		wait( driver, Myprofile);
		Myprofile.click();
	}
	
	public void movebypointer() throws InterruptedException
	{
		MoveByoffset(driver);
		Thread.sleep(2000);
	}
	
	
	}


