package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {//rule1
	//rule 2
	//Declaration
	@FindBy(id = "user-name")// Identify single element with single locator
	private WebElement usernameEdt;
	
//	@FindAll-identify single web-element with multiple Locator
//	OR operator
//	AutoHealing process
//	@FindAll({@FindBy(id = "user-name"),@FindBy(name = "user-name")});
//	private WebElement usernameEdt;
//	
//	@FindBys-identify single web-element with multiple Locator
//	AND operator
//	@FindBys({@FindBy(id = "user-name"),@FindBy(name = "user-name")});
//	private WebElement usernameEdt;
	
	
	@FindBy(name = "password")
	private WebElement PasswordEDT;
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//Rule3
	//Initilization
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//rule4
	//utilization
	
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEDT() {
		return PasswordEDT;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * this method will perform login operation
	 * @param UN
	 * @param Pwd
	 */
	public void loginToApp(String UN,String Pwd)
	{
		usernameEdt.sendKeys(UN);
		PasswordEDT.sendKeys(Pwd);
		loginBtn.click();
	}
	


}
