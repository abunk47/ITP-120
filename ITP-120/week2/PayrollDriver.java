/*
 * In this program we will create two payroll classes
 * and then we will show the employees' gross pay (pay * hours).
 * A.Bunk 5.31.2014
 */

package week2;

import java.text.NumberFormat;

public class PayrollDriver 
{
	public static void main ( String [] args )
	{
		//create the nf object 
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		// create the employee1 instance and then call the toString method
		Payroll employee1 = new Payroll ("John Smith", 2345, 99.85, 52.00);
		System.out.println (employee1.toString());
		
		// figure out John Smith's grossPay
		System.out.println (employee1.getName() + " makes " + 
				   nf.format(employee1.grossPay()) + " a week!");
		
		// create the employee2 instance and set fields and then call the toString method
		Payroll employee2 = new Payroll ();
		
		// set employee2's fields
		employee2.setName	("Abraham Lincoln");
		employee2.setId		(1865);
		employee2.setPay	(185.43);
		employee2.setHours	(55);
		
		System.out.println (employee2.toString());
		
		// call the grossPay method and print Employee2's grossPay
		// I actually call the employee's grossPay twice here.  I wanted to just do it once
		// within the println command and see if it worked (which it did) but since you specifically asked us to 
		// call the grossPay method before the println I did that as well.
		employee2.grossPay(); 
		System.out.println (employee2.getName() + " makes " + 
						   nf.format(employee2.grossPay()) + " a week!");
				
		
	} // end main method
} // end main class
