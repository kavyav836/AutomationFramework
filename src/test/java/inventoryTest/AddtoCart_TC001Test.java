package inventoryTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.SeleniumUtility;
import objectrepository.CartPage;
import objectrepository.InventoryItem;
import objectrepository.InventoryPage;
import objectrepository.Loginpage;
public class AddtoCart_TC001Test {
	
public static void main(String[] args)  throws IOException, InterruptedException {
		//create object of utility
		FileUtility Futil=new FileUtility();
		SeleniumUtility Sutil= new SeleniumUtility();
		
		// TODO Auto-generated method stub

	String URL = Futil.readDataFromPropertyFile("url");
	String USERNAME =  Futil.readDataFromPropertyFile("username");
	String PASSWORD =  Futil.readDataFromPropertyFile("password");
String PRODUCTNAME = Futil.readDataFromExcelFile("Products", 4, 3);

WebDriver driver=new EdgeDriver();
	Sutil.maximizeWindow(driver);
	Sutil.addImplicitlyWait(driver);
	
	//get URL
	driver.get(URL);
	
	//validate the credentials
	Loginpage lp=new Loginpage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	Thread.sleep(1000);
	
	//click on product add to cart
	InventoryPage Ip=new InventoryPage(driver);
	Ip.clickOnProduct(driver, PRODUCTNAME);
	Thread.sleep(3000);
	
	//navigate to inventorypage
	InventoryItem iip=new InventoryItem(driver);
	iip.clickOnCartBtn();
	Thread.sleep(3000);
	//navigate to cartikon
	Ip.ClickOnCartContainerBtn();
	Thread.sleep(3000);
	
	//validate for product in cart
	CartPage cp= new CartPage(driver);
	String productinCart = cp.captureItemName();

	if(productinCart.equals(PRODUCTNAME))
	{
		System.out.println(productinCart);
	System.out.println("PASS");
	}
	else
	{
		System.out.println("Fail");
	}
	//Close app
	
Ip.LogoutApp();	
JavaUtility JU=new JavaUtility();
String Systemdate=JU.getSystemDate();
System.out.println(Systemdate);
driver.quit();
}
	}


