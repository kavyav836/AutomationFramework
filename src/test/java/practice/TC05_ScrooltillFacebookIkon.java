package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC05_ScrooltillFacebookIkon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//LAunchBrowser
WebDriver driver=new EdgeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//Launch URL
driver.get("https://www.saucedemo.com/");
//Validate Credentials
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();
Thread.sleep(2000);
//
WebElement Facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
Actions act=new Actions(driver);
act.scrollToElement(Facebook).perform();
Thread.sleep(5000);
//Close app
driver.findElement(By.id("react-burger-menu-btn")).click();
driver.findElement(By.id("logout_sidebar_link")).click();

	}
}
