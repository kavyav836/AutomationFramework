package testNgPractice;

import org.testng.annotations.Test;

public class TestNgPractice {

	@Test(priority = 2)
	public void create()
	{
		System.out.println("create");
	}
	@Test(enabled = true,priority = 0)
	public void modify()
	{
		System.out.println("modify");
	}
	@Test(priority = 1,dependsOnMethods = "create")
	public void  delete()
	{
		System.out.println("delete");
	}
}
