/*
 *  This program asks the user to enter their package's weight and the amount of 
 *  miles they want to ship the item and then displays the shipping charges.
 *  A.Bunk 5/31/2014
 */

package week2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ShippingCharges 
{
	public static void main ( String [] args )
	{
		double 	weight; // variable for the weight of the package
		int 	miles; // variable for the amount of miles the package will be shipped, this is in units of 500 miles
		double 	price; // variable for the total price to ship the package
		double 	rate; // variable for the shipping rate
		
		Scanner scan = new Scanner (System.in); // create a new Scanner object
		DecimalFormat df = new DecimalFormat ("0.00"); // create a new DecimalFormat object
		
		// welcome the user and ask them for the weight of the package 
		System.out.println("Welcome to the Fast Freight Shipping Company!" +  
							" \nTo determine the total cost to ship your package \nwe will need you to provide us"
							+ " with some information about your package." + "\nHow much does your package weigh in lbs?");
		weight = scan.nextDouble(); // have user input the weight
		
		// thank the user and confirm the weight
		System.out.println("\nThank you for letting me know your package weighs " + df.format(weight) + " lbs.");
		
		// ask the user to input the miles the package will be sent
		System.out.println("How far do you want to ship this package, in miles (please round to the nearest whole #)?"); 
		miles = scan.nextInt(); // have the user input the miles
		
		if (miles <= 0) // in case the person puts in 0 miles!
		{
			miles = 1; // in case we get a negative number from the user
			System.out.println("Why would you ship a package 0 miles? That's ridiculous!" +
								"\nWe will still charge you the minimum price to ship the package!"
								+ "\nWe will calculate the price as if you shipped it 1 mile!");
		}
		
		
		
		System.out.println ("Your package weighs " + weight + " lbs and you want to ship the package " 
							+ miles + " miles.");
		
		
		
		// This if else statement is in case we get a remainder of 0 in our calculation of miles.
		if ((miles % 500) == 0)
		{
			miles = (miles/500);
		}
		else 
		{
			miles = (miles/500) + 1; // miles is in units of 500 miles so this will always be at least 1	
		}
		
		// below I use if and if else statements to determine the price it will cost the user to mail the package
		// each if and if else statement will calculate the price based on the weight and distance to ship
		if (weight > 10)
		{
			rate = 3.80; // set shipping rate for this weight
			price = miles * rate; // units of 500 miles * the shipping rate for that weight
			// let the user know the price per 500 miles and their total 
			System.out.println ("\nThe price per 500 miles will be $" + df.format(rate) +
								" and your total cost to ship the package " + "\nwill be $" + df.format(price) + ".");
						
		}
		
		else if (weight > 6)
		{
			rate = 3.70; // set shipping rate for this weight
			price = miles * rate; // units of 500 miles * the shipping rate for that weight
			// let the user know the price per 500 miles and their total 
			System.out.println ("\nThe price per 500 miles will be $" + df.format(rate) +
								" and your total cost to ship the package " + "\nwill be $" + df.format(price) + ".");
		}
		
		else if (weight > 2)
		{
			rate = 2.20; // set shipping rate for this weight
			price = miles * rate; // units of 500 miles * the shipping rate for that weight
			// let the user know the price per 500 miles and their total 
			System.out.println ("\nThe price per 500 miles will be $" + df.format(rate) +
								" and your total cost to ship the package " + "\nwill be $" + df.format(price) + ".");
		}
		
		else 
		{
			rate = 1.10; // set shipping rate for this weight
			price = miles * rate; // units of 500 miles * the shipping rate for that weight
			// let the user know the price per 500 miles and their total 
			System.out.println ("\nThe price per 500 miles will be $" + df.format(rate) +
								" and your total cost to ship the package " + "\nwill be $" + df.format(price) + ".");
		}
		
		scan.close();
		
	} // end main method
	

} // end class
