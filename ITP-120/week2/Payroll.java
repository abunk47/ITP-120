/*
 * This class provides information on employees pay, it has information
 * on employees.  As well as methods related to an employee's gross pay.
 * A.Bunk 5.31.2014
 */

package week2;

import java.text.NumberFormat;

public class Payroll 
{
	private String name; 	// the employee's name
	private int	   id;	 	// the employee's ID #
	private double pay;	 	// the hourly pay for the employee
	private double hours;	// # of hours worked
	private double total;	// total gross pay
	
	
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	
	// default constructor / no argument constructor
	public Payroll ()
	{
	}
	
	// full constructor
	public Payroll (String name, int id, double pay, double hours)
	{
		this.name 	= name;
		this.id   	= id;
		this.pay  	= pay;
		this.hours 	= hours;			
	}
	
	// grossPay method
	public double grossPay ()
	{
		return total = pay * hours;
	}
	
	// toString method
	public String toString ()
	{
		return name + " ID #: " + id + " has an hourly pay of " + nf.format(pay)
			   + " and worked " + hours + " hours this week!";
	}

	// get and set methods for each field
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
} // end class
