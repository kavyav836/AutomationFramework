package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_02AddtoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//launch browser	
WebDriver driver=new EdgeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//get URL
driver.get("https://www.saucedemo.com/");
//validate the credentials
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();
Thread.sleep(1000);
//click on product add to cart
driver.findElement(By.id("item_4_title_link")).click();
Thread.sleep(1000);
driver.findElement(By.id("add-to-cart")).click();
Thread.sleep(3000);
//navigate
driver.findElement(By.id("shopping_cart_container")).click();
//validate
String productinCart = driver.findElement(By.className("inventory_item_name")).getText();

if(productinCart.equals("Sauce Labs Backpack"))
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
