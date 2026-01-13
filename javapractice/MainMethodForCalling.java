package javapractice;

public class MainMethodForCalling {

	public static void main(String[] args) {
		
		FourTypesOfMethodsUsingStatic.c1();
		FourTypesOfMethodsUsingStatic.c2(100);
		
		//if there is return type and has not print statement then those type of methods during call can be print directly
		System.out.println(FourTypesOfMethodsUsingStatic.c3());
		System.out.println(FourTypesOfMethodsUsingStatic.c4(1000));

	}

}
