package javapractice;

public class FourTypesOfMethodsUsingStatic {
	
	public static void c1() {
		
		int n=10;
		System.out.println(n*(n+1)/2);
	}
	
	public static void c2(int n) {
		System.out.println(n*(n+1)/2);		
	}
	
	public static int c3() {
		int n=20;
		/*We can also write in this way
		 * sum=n*(n+1)/2
		 * return sum;
		*/
		return n*(n+1)/2;
	}
	
	public static int c4(int n) {
		int sum = n*(n+1)/2;
		return sum;
		
	}

}
