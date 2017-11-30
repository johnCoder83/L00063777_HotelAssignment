/**
 * Class: B.Sc. in Computing
 * Description: Payable Interface
 * Date: 18/09/2017
 * @author John Lee Heaney
 * Student number L00063777
**/
package ie.lyit.hotel;

public interface Payable {
	public abstract double calculateWage(double taxPercentage);
	// Don't have to put in public abstract
	double incrementSalary(double incrementAmount);
}

// A Java interface can contain only abstract 
// methods, i.e. methods without a body