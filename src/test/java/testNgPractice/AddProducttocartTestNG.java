package testNgPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.SeleniumUtility;
import objectrepository.CartPage;
import objectrepository.InventoryItem;
import objectrepository.InventoryPage;
import objectrepository.Loginpage;

public class AddProducttocartTestNG extends BaseClass{
@Test
public void AddProducttocartTestNg() throws IOException, InterruptedException{

// TODO Auto-generated method stub

String PRODUCTNAME = Futil.readDataFromExcelFile("Products", 4, 3);


//click on product add to cart
InventoryPage Ip=new InventoryPage(driver);
Ip.clickOnProduct(driver, PRODUCTNAME);
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
Assert.assertEquals(productinCart, PRODUCTNAME);
System.out.println(productinCart);
}

}
