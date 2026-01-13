package exceptions;

public class InSuffBalException extends RuntimeException {
	
	public InSuffBalException() {
		super("Sorry, You have insufficient balance to withdraw...");
	}

}
