package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import objectrepository.Loginpage;

public class TC_01Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//open browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//get url
		driver.get("https://www.saucedemo.com/");
		//validate login cridential
//		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
//	 driver.findElement(By.id("password")).sendKeys("secret_sauce");
//	 driver.findElement(By.id("login-button")).click();
//	 
	
	 Thread.sleep(3000);
	
	 
	 
	
		 //close
	 driver.findElement(By.id("react-burger-menu-btn")).click();
	 driver.findElement(By.id("logout_sidebar_link")).click();
	}

}
