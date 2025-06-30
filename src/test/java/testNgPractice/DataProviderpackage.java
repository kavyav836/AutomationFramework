package testNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderpackage {
	@Test(dataProvider = "cusomerinfo")
	public void createCustomer(String name,int id)
	{
		//
		//
System.out.println("the customer name is ->"+name);
	System.out.println("the customer id is ->"+id);
}

//stock your data
@DataProvider(name = "cusomerinfo")//row and columns
public Object[][] gerdata(){//4set of data each set has 2info
	Object[][] data=new Object[4][2];
	
	//first dataset
	data[0][0]="Neethu";
	data[0][1]=12;
	
	//second dataset
	data[1][0]="Prithi";
	data[1][1]=14;
	
	//third dataset
	data[2][0]="Prakruthi";
	data[2][1]=16;
	
	//fourth dataset
	data[3][0]="Grisma";
	data[3][1]=18;
	
	return data;
}	
			
}