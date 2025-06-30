package practice;

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

import genericUtility.FileUtility;
import genericUtility.SeleniumUtility;
import objectrepository.Loginpage;

public class ADDtocartTC01DDT {
	
public static void main(String[] args) throws IOException, InterruptedException {
	//create object of utility
	FileUtility Futil=new FileUtility();
	
	SeleniumUtility Sutil= new SeleniumUtility();
	
	// TODO Auto-generated method stub

String URL = Futil.readDataFromPropertyFile("url");
String USERNAME =  Futil.readDataFromPropertyFile("username");
String PASSWORD =  Futil.readDataFromPropertyFile("password");


String PRODUCTNAME = Futil.readDataFromExcelFile("Products", 1, 2);


WebDriver driver=new EdgeDriver();
Sutil.maximizeWindow(driver);
Sutil.addImplicitlyWait(driver);
//get URL
driver.get(URL);
//validate the credentials
//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//driver.findElement(By.id("password")).sendKeys(PASSWORD);
//driver.findElement(By.id("login-button")).click();
Loginpage lp=new Loginpage(driver);
//lp.getUsernameEdt().sendKeys(USERNAME);
//lp.getPasswordEDT().sendKeys(PASSWORD);
//lp.getLoginBtn().click();
lp.loginToApp(USERNAME, PASSWORD);
Thread.sleep(1000);
//click on product add to cart
driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
Thread.sleep(1000);
driver.findElement(By.id("add-to-cart")).click();
Thread.sleep(3000);
//navigate
driver.findElement(By.id("shopping_cart_container")).click();
//validate
String productinCart = driver.findElement(By.className("inventory_item_name")).getText();

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
driver.findElement(By.id("react-burger-menu-btn")).click();
driver.findElement(By.id("logout_sidebar_link")).click();
	}

}
