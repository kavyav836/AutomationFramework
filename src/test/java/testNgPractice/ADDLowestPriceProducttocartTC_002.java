package testNgPractice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.SeleniumUtility;
import objectrepository.CartPage;
import objectrepository.InventoryItem;
import objectrepository.InventoryPage;
import objectrepository.Loginpage;
@Listeners(genericUtility.ListenersimplementaionUtility.class)
public class ADDLowestPriceProducttocartTC_002 extends BaseClass  {

	@Test(groups = "RegressionSuite")
	public void AddLowestPriceproducttocarttest()  throws IOException, InterruptedException{
		
		// TODO Auto-generated method stub
		String SORTOPTION = Futil.readDataFromExcelFile("Products", 4, 2);
String PRODUCTNAME = Futil.readDataFromExcelFile("Products", 4, 3);

	
	//click on product add to cart
	InventoryPage Ip=new InventoryPage(driver);
	Ip.clickOnHighistPriceProduct(driver, PRODUCTNAME, SORTOPTION);
	Thread.sleep(3000);
	
	//navigate to inventorypage
	InventoryItem iip=new InventoryItem(driver);
	iip.clickOnCartBtn();
	Thread.sleep(3000);
	//navigate to cartikon
	Ip.ClickOnCartContainerBtn();
	Thread.sleep(3000);
	
	//validate for product in cart
	CartPage cp= new CartPage(driver);
	String productinCart = cp.captureItemName();

	Assert.fail();
	Assert.assertEquals(productinCart, PRODUCTNAME);
		System.out.println(productinCart);
	

	
	}
}
