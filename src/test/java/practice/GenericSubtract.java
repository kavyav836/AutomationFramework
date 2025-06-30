package practice;

public class GenericSubtract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int sum= sub (10,30);
		
		System.out.println(sum);
		System.out.println((sub(30,sum)));
		System.out.println(sub(100,300));
		System.out.println(sub(sum,60));
		System.out.println(sub(40,sum));		
		
		
		int sum2= sub(sum,70);
		System.out.println(sum2);
		
		
		
		
		
		
		
	}
	
	
	public static int sub(int a,int b)
	{
		int c= a-b;
		return c;
	}

}
