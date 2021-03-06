/*
 * This program will allow a person to enter the # of packages of software they purchased
 * and the program will provide them with their total, discount, and total after the discount.
 * A.Bunk 5/31/2014
 * 
 */


package week2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class SoftwareSales {
	
	public static void main ( String [] args )
	{
		
		int 	packages; // variable for # of packages purchased
		double 	price = 99.00; // variable for price declared and initialized
		double 	total; // variable for total price
		
		Scanner scan = new Scanner (System.in); // create a new Scanner instance
		DecimalFormat df = new DecimalFormat ("0.00"); // create a new DecimalFormat instance
		
		// Explain to the user the price and discount and ask user to enter # of packages purchased
		System.out.println ("Hi! Thanks for shopping with us today." + 
							"\nFor a few days only we are offering a discount" +
							" if you purchase 10 or more packages \nat the low price of $99 per package." + 
							"\nThe more packages you purchase the bigger your discount." +
							"\nPlease enter the number" + 
							" of packages you would like to purchase today: ");
		packages = scan.nextInt(); // allow user to input amount of packages purchased
		
		total = price * packages; // we initialize variable total 
		
		// confirm to user their total amount of packages purchased and the price before the discount
		System.out.println ("\nYour total for " + packages + 
							" packages before the discount will be $" + df.format(total) + ".");
		
		// below we set up if else statements that will occur based on the # of packages
		// purchased by the user. The more packages they purchase the larger their discount.
		// Each if or else if statement will provide the user with a console print out of 
		// how much their discount was, the % amount, how much they saved off the total, and
		// what their new total price is after the discount.
		
				
		if (packages >= 100) // 50% discount if 100+ purchased
		{
			System.out.println ("\nYou're ridiculously large purchase just earned you" +
								" a 50% discount, \nyou saved $" + 
								df.format(total * .5) + "!" + "\nYour new total is $" +
								df.format(total * .5) + "!" );
			// I hope its ok but I always use brackets with my if and if else statements.  I just 
			// find it is easier to read with the brackets
		}
		
		else if (packages >= 50) // 40% discount if 50+ purchased
		{
			System.out.println ("\nThat's a decent purchase so you earned yourself" +
								" a 40% discount, \nyou saved $" + 
								df.format(total * .4) + "!" + "\nYour new total is $" +
								df.format(total * .6) + "!" );
		}
		
		else if (packages >= 20) // 30% discount if 20+ purchased
		{
			System.out.println ("\nNice purchase, you earned yourself" +
								" a 30% discount, \nyou saved $" + 
								df.format(total * .3) + "!" + "\nYour new total is $" +
								df.format(total * .7) + "!" );
		}
		
		else if (packages >= 10) // 40% discount if 10+ purchased
		{
			System.out.println ("\nKind of small but we will still give you" +
								" a 20% discount, \nyou saved $" + 
								df.format(total * .2) + "!" + "\nYour new total is $" +
								df.format(total * .8) + "!" );
		}
		
		else // No discount if fewer than 10 are purchased
		{	
			System.out.println ("\nDiscounts don't grow on trees! \nYou need to purchase more" +
								" packages if you want a discount!" + "\nYour discount will be 0!" + 
								"\nYour total will be the same as before $" + df.format(total) + ".");
		}
		
		scan.close(); // close the scan object.
	} // end of main method

} // end of class SoftwareSales
