package assignments;

import java.util.Scanner;

import exceptions.InSuffBalException;

public class ExceptionThrowAssignment {

	public static void main(String[] args) {

		double currentBalance = 10000.00;

		System.out.println("Enter the Withdraw Amount...");
		Scanner sc = new Scanner(System.in);
		// Here I've used wrapper class whcih is wrong
//		Double withdrawAmount = sc.nextDouble();

		double withdrawAmount = sc.nextDouble();

		if (withdrawAmount <= currentBalance) {
			System.out.println("Your transaction is successful...");

			/*
			 * I shouldn't have used the below code in the above as both are true the inner
			 * if will not run // if (withdrawAmount > currentBalance) { // try { // throw
			 * new InSuffBalException(); // } catch (InSuffBalException e) { //
			 * System.out.println(e.getMessage()); // } // }
			 */

		} else {
			// Here I'm using the Unchecked and Manual exception created by Us
			throw new InSuffBalException();

		}

	}

}
