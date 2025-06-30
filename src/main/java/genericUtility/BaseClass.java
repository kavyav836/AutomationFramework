package genericUtility;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import objectrepository.InventoryPage;
import objectrepository.Loginpage;

public class BaseClass {
	
	public FileUtility Futil= new FileUtility();
	public JavaUtility Jutil= new JavaUtility();
	public 	WebDriver driver;
	public SeleniumUtility Sutil=new SeleniumUtility();
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true )
	public void BSconfig()
	{
		System.out.println("-----------database launch Succesfull----");
	}
	//@Parameters("Browser")
	//@BeforeTest  /*String pValue*/
	@BeforeClass(alwaysRun = true )
public void BCconfig(/*String pValue*/) throws IOException
	{
		String URL = Futil.readDataFromPropertyFile("url");
		
	//			 driver = new EdgeDriver();
//				 if(pValue.equals("edge"))
//				 {
//					 driver=new EdgeDriver();
//					 
//				 }
//				 else if (pValue.equals("firefox"))                  /*   to b */
//				 {
	
		 driver=new FirefoxDriver();
//				 }
//				 else
//				 {
//			 driver= new EdgeDriver();
//				 }
		Sutil.maximizeWindow(driver);
	Sutil.addImplicitlyWait(driver);
	driver.get(URL);
	//for lisners
	 sdriver = driver;
	System.out.println("---------browser launch succesfull---------");
	}
	@BeforeMethod(alwaysRun = true )
	public void BMconfig() throws IOException
	{
	
		String USERNAME = Futil.readDataFromPropertyFile("username");
		String PASSWORD = Futil.readDataFromPropertyFile("password");
		Loginpage lp=new Loginpage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	
	@AfterMethod(alwaysRun = true )
	public void AMconfig()
	{
		InventoryPage ip=new InventoryPage(driver);
		ip.LogoutApp();
		System.out.println("---------logoutof the application---");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true )
	public void ACconfig()
	{
		driver.quit();
		System.out.println("----Browser closer Succesfully-----");
	}
	
	@AfterSuite(alwaysRun = true )
	public void ASconfig()
	{
		System.out.println("---------Database Closer succesfull--------");
	}


}
