package testNgPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void hardsample()
	{
	System.out.println("step 1");
	System.out.println("step 2");
	System.out.println("step 3");
	
	Assert.assertEquals(1, 1);
	System.out.println("step 4");
	System.out.println("step 5");
	System.out.println("step 6");
	
	
}
@Test
		public void Softsample()
		{
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(1, 1);
	
		System.out.println("step 4");
		System.out.println("step 5");
		System.out.println("step 6");
		softAssert.assertAll();//log the failure
		
	}
}
