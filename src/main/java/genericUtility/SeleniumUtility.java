package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will manimize the window
	 * @param driver
	 */
 public void minimizeWindow(WebDriver driver) {
	 driver.manage().window().minimize(); 
 }
 /**
  * This method will make full screen the window
  * @param driver
  */
 public void FullScreenWindow(WebDriver driver) {
	 driver.manage().window().fullscreen(); 
 }
 /**
  * This method will Implicitlywait the window is loaded
  * @param driver
  */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	/**
	 * This method will explicitlywait the window is loaded
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * this method will hadeldropdown by index
	 * @param element
	 * @param index
	 */
	public void handelDropdown(WebElement element,int index)
	{
	
		Select s=new Select(element);
		s.selectByIndex(index);
		
	}
	/**
	 * this method will hadeldropdown by Text
	 * @param element
	 * @param text
	 */
	public void handelDropdownbyvisibletext(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * this method will hadeldropdown by value
	 * @param value
	 * @param element
	 */
	public void handelDropdown(String value,WebElement element)
	{
		Select s= new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method will mouseover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	
	}
	/**
	 *this method will Dragand dropaction 
	 * @param driver
	 * @param element
	 */
	public void dragandDropAction(WebDriver driver,WebElement Selement,WebElement Telement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(Selement, Telement).perform();
	
	}
	/**
	 * this method will Doubleclickaction
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	
	}
	/**
	 * this method will right click
	 * @param driver
	 * @param element
	 */
	public void contextClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickandHoldAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.release(element).perform();
	
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void scrollAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	
	}
	/**
	 * 
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
		
	}
	/**
	 * 
	 * @param driver
	 * @param Felement
	 */
	
	public void switchtoFrame(WebDriver driver, WebElement Felement)
	{
		driver.switchTo().frame(Felement);
		
	}
	/**
	 * 
	 * @param driver
	 * @param Fname
	 */
	public void switchtoFrame(WebDriver driver,String Fname)
	{
		driver.switchTo().frame(Fname);
	
		}
	/**
	 * 
	 * @param driver
	 * @param Fname
	 */
	
	public void switchtoParentFrame(WebDriver driver,String Fname)
	{
		driver.switchTo().parentFrame();
	
		}
	/**
	 * 
	 * @param driver
	 * @param Fname
	 */
	public void switchtoDefaltFrame(WebDriver driver,String Fname)
	{
		driver.switchTo().defaultContent();
	
		}
	/**
	 * 
	 * @param driver
	 * @param windowID
	 */
	public void switchtoWindow(WebDriver driver,String windowID)
	{
		driver.switchTo().window(windowID);
	}
	
	public void acceptAlert(WebDriver driver)
	{
	driver.switchTo().alert().accept();	
	}
	
	public void dismissalert(WebDriver driver)
	{
	driver.switchTo().alert().dismiss();;	
	}
	
	public void getalertText(WebDriver driver)
	{
	driver.switchTo().alert().getText();
	}
	public void EnterAlertData(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);","");
	}
	public String captureScreenShot(WebDriver driver, String ScreenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screenshots\\"+ScreenshotName+".png");
	FileHandler.copy(src, dst);
	return dst.getAbsolutePath();//for extent Report
	
	
	}
	
}
