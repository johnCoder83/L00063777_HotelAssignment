/**
 * Class: B.Sc. in Computing
 * Description: Customer tester
 * Date: 18/09/2017
 * @author John Lee Heaney
 * Student number L00063777
**/
package ie.lyit.testers;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;

public class CustomerTester {

	public static void main(String[] args) {
		
		// Create a Customer object called customerA
		Customer customerA = new Customer();
								
		// display customerA's details on screen
		System.out.println(customerA);

		// set customerA's details
		customerA.setName(new Name("Mr","Homer","Simpson"));		
		customerA.setAddress("12 Hi Road,Letterkenny");
		customerA.setPhoneNumber("087 1234567");
		customerA.setEmailAddress("homer@hotmail.com");

		// display customerA's details on screen
		System.out.println(customerA);		
		
		// Create a Customer object called customerB with initial values
		Customer customerB = new Customer("Ms","Lisa","Simpson","The Green,Ennis","085 0987654","lisa.simpson@gmail.com");

		// display customerB's details on screen
		System.out.println(customerB);

		// check if customerA is the same as customerB
		if(customerA.equals(customerB))
			System.out.println(customerA + " is the same customer as " + customerB);
		else
			System.out.println(customerA + " is not the same customer as " + customerB);
					
		// check if customerB is female
		if(customerB.getName().isFemale())		
			System.out.println(customerB.getName() + " is female.");			
		else
			System.out.println(customerB.getName() + " is male.");
	}		
}

