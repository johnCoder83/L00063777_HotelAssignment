/**
 * Class: B.Sc. in Computing
 * Description: Customer serializer tester
 * Date: 15/11/2017
 * @author John Lee Heaney
 * Student number L00063777
**/
package ie.lyit.testers;
import java.util.Scanner;
import ie.lyit.serialize.CustomerSerializer;

//CLASS NAME
public class CustomerSerializerTester {

	// INSTANCE VARIABLES
	public static final int menuStars = 70;

	// MAIN METHOD
	public static void main(String[] args) {

		// CREATE AN OBJECT OF SCANNER CLASS
		Scanner kIn = new Scanner(System.in);

		// DECLARE AND INITIALIZE VARIABLE FOR MENU CHOICE
		int mC = 0;

		// CREATE AN OBJECT OF TYPE CUSTOMERSERIALIZER
		CustomerSerializer customerSerializer = new CustomerSerializer();

		customerSerializer.readRecordsFromFile();// READ INTO FILE

		// PRINT WELCOME
		printWelcome();

		// USE A DO-WHILE TO HAVE USER INPUT A MENU CHOICE UNTIL THE USER PRESSES 0 TO EXIT
		do {

			// CALL MENU OPTION METHOD AND DISPLAY
			showMenu();

			try {

				// DECLARE VARIABLE FOR MENU CHOICE
				mC = kIn.nextInt();

				// SWITCH STATEMENT
				switch (mC) {

				case 1:
					customerSerializer.add();// ADD CUSTOMER
					stars(menuStars);
					System.out.println("Customer added");
					stars(menuStars);
					break;
				case 2:
					customerSerializer.viewCustomer();// VIEW CUSTOMER DETAILS
					stars(menuStars);
					System.out.println("Viewed Customer details");
					stars(menuStars);
					break;
				case 3:// EDIT CUSTOMER
					customerSerializer.edit();//EDIT CUSTOMER
					stars(menuStars);
					System.out.println("Customer details updated");
					stars(menuStars);
					break;
				case 4:
					customerSerializer.delete();// DELETE CUSTOMER
					stars(menuStars);
					System.out.println("Customer deleted");
					stars(menuStars);
					break;
				case 5:
					customerSerializer.list();// LIST CUSTOMERS
					stars(menuStars);
					System.out.println("List Customers");
					stars(menuStars);
					break;
				case 0:
					printCompleted();// METHOD TO PRINT MESSAGE TO USER
					break;
				default:
					stars(menuStars);
					System.out.println("You must choose a valid number from menu (1-5)");
					stars(menuStars);
				}// END SWITCH

				// WANT TO HANDLING EXCEPTION USE SHOULD NOT TYPE NEGATIVE NUMBERS
			} catch (Exception e) {
				if (mC < 0) {
					System.out.println("Unrecognized menu choice; please re-enter");
				}

				showMenu();// WHEN USER PUT WRONG INPUT DIRECT THEM BACK TO MENU
			}

		} while (mC != 0);//EXIT LOOP WHEN 0 IS SELECTED

		customerSerializer.writeRecordsToFile();// WRITE TO FILE WORKING

	}// END MAIN

	// METHOD TO DSIPLAY WELCOME
	public static void printWelcome() {
		stars(menuStars);
		System.out.println("WELCOME TO SELECT HOTELS IRELAND");
		stars(menuStars);
	}

	// METHOD TO DISPLAY MENU
	public static void showMenu() {

		// DISPLAY MENU
		System.out.println("\nCUSTOMER MENU");
		System.out.println("---------------------------");
		System.out.println("1. Add Customer");
		System.out.println("2. View Customer");
		System.out.println("3. Edit Customer");
		System.out.println("4. Delete Customer");
		System.out.println("5. List Customers");
		System.out.println("0. Exit Menu");
		System.out.print("\n\nEnter Menu Choice: ");

	}

	// METHOD TO PRINT THANK YOU FOR USING MENU
	public static void printCompleted() {
		stars(menuStars);
		System.out.println("Thank you for using  Select Hotels , have a great day!");
		stars(menuStars);
	}

	// METHOD TO PRINT STARS FOR BANNER
	public static void stars(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("*");
		}
		System.out.print("\n");
	}

	/*
	 * ALL METHODS WORKING
	 * WHEN A CUSTOMER IS DELETED, THE NEXT CUSTOMER THAT GETS ADDED GETS ASSIGNED 
	 * A CUSTOMER ID ABOVE THE PREVIOUS CUSTOMER THAT WAS DELETED
	 * WHEN YOU FIRST RUN THE MENU YOU WILL
	 * WANT TO ADD A CUSTOMER, THE JDIALOG PANE OPENS UP BEHIND THE IDE, YOU WILL
	 * HAVE TO MINIMILISE THE SCREEN TO ENTER CUSTOMER DETAILS THE SAMEE APPLIES 
	 * FOR THE EDIT CUSTOMER MENU CHOICE
	 */

}// END CLASS
