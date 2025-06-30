package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class CartPage extends SeleniumUtility {
	
	@FindBy(className = "inventory_item_name")
	private WebElement itemInfo;
	
	@FindBy(name = "remove-sauce-labs-backpack")
	private WebElement RemoveBtn;
	
	@FindBy(name = "checkout")
	private WebElement ChckoutBtn;

	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getitemInfo() {
		return itemInfo;
	}


	public WebElement getRemoveBtn() {
		return RemoveBtn;
	}


	public WebElement getChckoutBtn() {
		return ChckoutBtn;
	}
	/**
	 * This method will Click on Remove Button
	 */
	public void clickonRemoveBtn()
	{
		RemoveBtn.click();
	}
	/**
	 * This method will capture Product Description
	 * @return
	 */
	public String captureItemName()
	{
		return itemInfo.getText();
	}
	
	
	
	
	

	
	
	
}
