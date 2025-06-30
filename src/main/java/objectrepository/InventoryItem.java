package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class InventoryItem extends SeleniumUtility {
	@FindBy(id = "add-to-cart")
	private WebElement AddtocartBtn;



public InventoryItem(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}



public WebElement getAddtocartBtn() 
{
	return AddtocartBtn;
}


public void clickOnCartBtn()
{
	AddtocartBtn.click();
}

}