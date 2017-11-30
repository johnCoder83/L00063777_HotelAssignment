/**
 * Class: B.Sc. in Computing
 * Description: Customer class
 * Date: 15/11/2017
 * @author John Lee Heaney
 * Student number L00063777
**/
package ie.lyit.hotel;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//USING INHERITENCE FROM PERSON CLASS
public class Customer extends Person implements Serializable {

	// INSTANCE VARIABLES
	private String emailAddress;
	private int number;
	private static int nextNumber = 0;// STATIC NUMBER SET A ZERO

	// DEFAULT CONSTRUCTOR
	public Customer() {

		super();
		emailAddress = null;

		// SET NUMBER TO STATIC NEXTNUMBER BEFORE INCREMENTING
		number = nextNumber++;

	}

	// INITIALIZED CONSTRUCTOR
	public Customer(String t, String fN, String sn, String adDress, String pNo, String email) {

		// CALL SUPER CLASS CONSTRUCTOR
		super(t, fN, sn, adDress, pNo);
		emailAddress = email;
		number = nextNumber++;

	}

	// TO STRING METHOD
	@Override
	public String toString() {

		// PRINTING NULL VALUES
		return ("\n" + "Customer ID: " + number + "\n" + name.getTitle() + "\n" + name.getFirstName() + "\n"
				+ name.getSurname() + "\n" + address + "\n" + emailAddress + "\n" + phoneNumber + "\n" + "");
	}

	// EQUALS METHOD FOR NUMBER
	@Override
	public boolean equals(Object obj) {

		Customer cObject;

		if (obj instanceof Customer)

			cObject = (Customer) obj;

		else

			return false;

		return (this.number == cObject.number);

	}

	// GET AND SET METHODS
	public void setEmailAddress(String emailAddress) {

		this.emailAddress = emailAddress;

	}

	public String getEmailAddress() {

		return this.emailAddress;

	}

	public int getNumber() {

		return number;

	}

	// SET CUSTOMER ID NOT DUPLICATE
	public void setNumber(int i) {

		nextNumber = i;

	}

	// METHOD TO READ AND ADD USER DETAILS
	public void read() {

		JTextField num = new JTextField();
		num.setText("" + this.getNumber());

		// CREATE TEXT FIELDS FOR CUSTOMER
		JTextField title = new JTextField();
		JTextField firstname = new JTextField();
		JTextField surname = new JTextField();
		JTextField email = new JTextField();
		JTextField phoneNum = new JTextField();
		JTextField addres = new JTextField();

		Object[] message = {

				"Number:", num, "Title:", title, "First Name:", firstname, "Surname:", surname, "Email address:", email,
				"PhoneNo:", phoneNum, "Address:", addres, };

		int option = JOptionPane.showConfirmDialog(null, message, "Enter customer details",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {

			this.name.setTitle(title.getText());
			this.name.setFirstName(firstname.getText());
			this.name.setSurname(surname.getText());
			this.emailAddress = email.getText();
			this.address = addres.getText();
			this.phoneNumber = phoneNum.getText();

		}

	}

}
