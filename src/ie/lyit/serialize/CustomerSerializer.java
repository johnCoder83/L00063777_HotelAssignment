/**
 * Class: B.Sc. in Computing
 * Description: Customer serializer
 * Date: 15/11/2017
 * @author John Lee Heaney
 * Student number L00063777
**/
package ie.lyit.serialize;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import ie.lyit.hotel.Customer;


//CLASS NAME IMPLEMENTS SERIALIZABLE
public class CustomerSerializer {

	// CREATE AN ARRAY LILST OF CUSTOMERS
	private ArrayList<Customer> customers;

	// CREATE A CONSTANT FOR FILE
	private final String FILENAME = "customers.ser";
	
	//CREATE OBJECT OF CUSTOMER CLASS
	Customer cus = new Customer();
	
	//CREATE OBJECT OF SCANNER CLASS
	Scanner kIn = new Scanner(System.in);

	// DEFAULT CONSTRUCTOR
	public CustomerSerializer() {

		super();

		// CONSTRUCT CUSTOMER ARRAYLIST
		customers = new ArrayList<Customer>();
		
	}

	// ADD A CUSTOMER
	public void add() {
	
			//CREATE CUSTOMER OBJECT
			Customer cus = new Customer();

			//READ CUSTOMER DETAILS
			cus.read();	
			
			//ADD TO CUSTOMER ARRAYLIST
			customers.add(cus);
		
		}
		

	// VIEW CUSTOMER
	public Customer viewCustomer() {

		// GET USER INPUT
		System.out.println("Enter customer id you want to view: ");
		int choice = kIn.nextInt();

		for (Customer cus : customers) {

			// CHECK TO SEE IF MATCH CUSTOMER ID
			if (cus.getNumber() == choice) {

				// DISPLAY
				System.out.println(cus);

				return cus;
				
			}
			
		}
		
		//CUSTOMER WAS NOT FOUND SO RETURN NULL
		return null;
	}

	//EDIT METHOD
	public void edit() {
		
		//CALL VIEWCUSTOMER() TO FIND AND RETURN CUSTOMER TO EDIT
		Customer tempCus = viewCustomer();

		// IF CUSTOMER != NULL, CUSTOMER ID FOUND
		if (tempCus != null) {
			
			//GET INDEX
			int index  = customers.indexOf(tempCus);
			
			//READ IN NEW CUSTOMER INFO
			tempCus.read();
			
		// RESET THE OBEJCTS IN CUSTOMER
			customers.set(index,tempCus );
					
		}
		//ERROR CHECK IF CUSTOMER FOUND OR NOT
		else{
			System.out.println("Customer ID not found please try again!");
	
		}
	
	}

	// LIST CUSTOMERS
	public void list() {

		// FOR EVERY CUSTOMER OBJECT IN CUSTOMERS
		for (Customer cust : customers)

			// DISPLAY IT
			System.out.println(cust);

	}

	// DELETE CUSTOMER
	public void delete() {

		boolean custFound = false;

		//GET USER INPUT
		System.out.println("Enter customer id you want to delete: ");
		int choice = kIn.nextInt();

		for (int i = 0; i < customers.size(); i++) {

			if (customers.get(i).getNumber() == choice) {
				customers.remove(i);

				i--;//DECREMENT
				custFound = true; //CUSTOMER WITH DESIRED ID REMOVED 

			}

		}
		//ERROR MESSAGE IF NOT FOUND
		if (!custFound)
			System.out.println("Customer with ID " + choice + " was not found");

	}
	
	// METHOD WRITER RECORDS TO FILE THIS METHOD WILL SERIALIZE THE CUSTOMER
	// ARRAYLIST WHEN CALLED--IE WRITE IT TO FILE CUSTOMERS.SER
	public void writeRecordsToFile() {

		ObjectOutputStream os = null;

		try {

			// CREATE OBJECT OF FILEOUPTSTREAM SERIALIZE THE ARRAYLIST
			FileOutputStream fileStream = new FileOutputStream(FILENAME);

			os = new ObjectOutputStream(fileStream);

			os.writeObject(customers);
		}

		catch (FileNotFoundException fNFE) {

			System.out.println("Cannot create file to store books.");
		}

		catch (IOException ioE) {

			System.out.println(ioE.getMessage());
		}

		finally {

			try {
				os.close();
			}

			catch (IOException ioE) {

				System.out.println(ioE.getMessage());
			}
		}
	}

	//THIS METHOD WILL DESERIALIZE THE BOOKS ARRAYLIST WHEN CALLED
	@SuppressWarnings("unchecked")
	public void readRecordsFromFile() {

		ObjectInputStream is = null;

		try {

			// CREATE OBJECT OF FILEOUPTSTREAM SERIALIZE THE ARRAYLIST DESERIALIZE THE ARRAYLIT
			FileInputStream fileStream = new FileInputStream(FILENAME);

			is = new ObjectInputStream(fileStream);

			customers = (ArrayList<Customer>) is.readObject();
			
			//GET LAST INDEX OF ARRAYLIST SIZE AND ADD 1 TO NEWLY CREATED CUSTOMER
			cus.setNumber((customers.get(customers.size() - 1).getNumber() +1));
			is.close();

		} catch (FileNotFoundException fNFE) {

			System.out.println("Cannot create file to customers");
		} catch (IOException ioE) {

			System.out.println(ioE.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {

			try {
				is.close();
			}

			catch (IOException ioE) {
				System.out.println(ioE.getMessage());
			}
		}
	}

}


