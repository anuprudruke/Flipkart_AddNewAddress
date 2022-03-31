package TestClass;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseClass.BaseClass1;
import POMClasses.Loginpagefpkt;
import POMClasses.MyProfilePagefpkt;
import POMClasses.Homepagefpkt;

public class TestClass1 {
	WebDriver driver;
	Loginpagefpkt lp;
	Homepagefpkt hp;
	MyProfilePagefpkt pp;

	ExtentReports reports; // global variables of Extent reports
	ExtentTest test; // global variables of Extent Test

	@Parameters("web")
	@BeforeClass

	public void chromedriver(String a) throws IOException {

		reports = new ExtentReports("ExtenetReports.html", true);
		test = reports.startTest("TestClass1"); // Pass class name as parameter
		driver = BaseClass1.Flipkart(a);
		
		

		     
		
		
	}

	@BeforeMethod

	public void methods() {
		lp = new Loginpagefpkt(driver);
		hp = new Homepagefpkt(driver);
		pp = new MyProfilePagefpkt(driver);

	}

	@Test(priority = 1)

	public void logintofpkt() throws InterruptedException, IOException {

		// Thread.sleep(1100);
		lp.username1();
		// Thread.sleep(1100);

		lp.EneterPassword();
		// Thread.sleep(1100);
		lp.submitdetails();
		hp.movetomyaccount();

		String txt = hp.gettext();

		//		if (txt.equals("Logout")) 
		//		{
		//			System.out.println("you are on Homepage");
		//		}
		//		else 
		//		{
		//			Assert.fail();
		//		}

		Assert.assertEquals(txt, "Logout");

		test.log(LogStatus.PASS, "Log in test Passed"); // this is log status will be displayed in extent reports
		hp.clickonmyprofile();
		hp.movebypointer();
	}

	@DataProvider(name = "dataset")
	public String[][] dataTotest() {
		String[][] data = { { "Anup", "8600244579", "415512", "Pusesavli" },
				{ "Arun", "8830089636", "415001", "Satara" } };
		return data;

	}

	@Test(priority = 2, dataProvider = "dataset")
	public void Myprofilepagefpkt(String name, String number, String pin, String locality)
			throws EncryptedDocumentException, IOException, InterruptedException {
		String txt = pp.accountsettting();
		//		System.out.println(txt);
		//		
		//		if(txt.equals("ACCOUNT SETTINGS"))
		//		{
		//			System.err.println("you are on profilepage");
		//		}
		//		else
		//		{
		SoftAssert soft = new SoftAssert();

		//		}

		soft.assertEquals(txt, "ACCOUNT SETTINGS");
		pp.clickonmanageadaddress();
		pp.ClickonAddnewAddress();
		List<String> datalist = new ArrayList<String>();
		datalist.add(name);
		datalist.add(number);
		datalist.add(pin);
		datalist.add(locality);

		int beforecount = pp.checkaddresscount();
		System.out.println(beforecount);
		pp.insertaddress(datalist);
		// pp.AddAreadetails();

		pp.savenewaddress();

		int aftercount = pp.checkaddresscount();

		System.out.println(aftercount);

		Assert.assertEquals(aftercount, (beforecount + 1));
		test.log(LogStatus.PASS, "Added new addresses");

	}
	
	@AfterMethod

	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE) // if test status failed screenshot will get capture
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(pp.screencpature(driver)), "Taken Screenshot");
		}
	}
	@AfterClass
	public void afterclass()
	{
		reports.endTest(test);
		reports.flush();
		//driver.quit();
		
		
	}
	

}
