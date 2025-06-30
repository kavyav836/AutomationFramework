package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtility.FileUtility;
import genericUtility.SeleniumUtility;

public class TC_04HandelDropdown {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		FileUtility Futil= new FileUtility();
		SeleniumUtility Sutil=new SeleniumUtility();
		String URL = Futil.readDataFromPropertyFile("url");
		String USERNAME =Futil.readDataFromPropertyFile("username");
		String PASSWORD =Futil.readDataFromPropertyFile("password");

		
		String SORTOPTION = Futil.readDataFromExcelFile("Products",1,2);

		String PRODUCTNAME =Futil.readDataFromExcelFile ("Products",4,3);
	
		
WebDriver driver=new EdgeDriver();
Sutil.maximizeWindow(driver);
Sutil.addImplicitlyWait(driver);
driver.get(URL);
driver.findElement(By.id("user-name")).sendKeys(USERNAME);
driver.findElement(By.id("password")).sendKeys(PASSWORD);
driver.findElement(By.id("login-button")).click();
Thread.sleep(1000);

WebElement ele = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
//handel drop down
Sutil.handelDropdownbyvisibletext(ele, SORTOPTION);

Thread.sleep(4000);

//click on the product and add to cart
driver.findElement(By.xpath("div[.='"+PRODUCTNAME+"']"));
driver.findElement(By.id("add-to-cart")).click();

//Navigate to Cart
driver.findElement(By.id("shopping_cart_container")).click();

// Validate for the product in Cart
String productInCart = driver.findElement(By.className("inventory_item_name")).getText();

if (productInCart.equals(PRODUCTNAME)) {
System.out.println(productInCart);
System.out.println("PASS");
		} 
else {
System.out.println("FAIL");
		}




//Close app
driver.findElement(By.id("react-burger-menu-btn")).click();
driver.findElement(By.id("logout_sidebar_link")).click();
}

}