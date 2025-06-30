package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class InventoryPage extends SeleniumUtility {
	
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
private WebElement Productname;
	
	@FindBy (className =  "product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement Cartcantainer;
	
	@FindBy(className = "bm-burger-button")
	private WebElement MenuBtn;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutlink;
	
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getProductname() {
		return Productname;
	}

	public WebElement getsortDropDown() {
		return sortDropDown;
	}

	public WebElement getCartcantainer() {
		return Cartcantainer;
	}

	public WebElement getMenuBtn() {
		return MenuBtn;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	/**
	 * This method will perform Logout Operation
	 */
	//library
	public void LogoutApp()
	{
	MenuBtn.click();
	logoutlink.click();
	}
	/**
	 * this methos will click on cart container button
	 */
	public void ClickOnCartContainerBtn()
	{
		Cartcantainer.click();
	}
	/**
	 * This method will click on Product
	 * @param driver
	 * @param PRODUCTNAME
	 */
	public void clickOnProduct(WebDriver driver,String PRODUCTNAME)
	{
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();;
	}
	/**
	 * This method will Click on SOrt Dropdownbutton
	 */
	public void clickOnHighistPriceProduct(WebDriver driver,String ProductName,String SortOption)
	{

	handelDropdownbyvisibletext(sortDropDown,SortOption);
	driver.findElement(By.xpath("//div[.='"+ProductName+"']")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
