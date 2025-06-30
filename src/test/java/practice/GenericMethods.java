package practice;

public class GenericMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum= add (10,30);
		
		System.out.println(sum);
		System.out.println((add(30,sum)));
		System.out.println(add(100,300));
		System.out.println(add(sum,60));
		System.out.println(add(40,sum));		
		
		
		int sum2= add(sum,70);
		System.out.println(sum2);
		
		
	}
	public static int add(int a,int b)
	{
		int c= a+b;
		return c;

	}

}
