/*
 * The program prints out the total, average, min, and max sales for the sales of a store over 1 week using an array
 * to hold the sales # for the week.
 * A.Bunk 6.20.2014
 */

package week5;

import java.text.*;

public class SalesDriver 
{
	public static void main (String [] args)
	{
		double[] sales = {45600, 65000, 34750, 87450, 82345, 33440, 79000};
		total (sales);
		average (sales);
		max (sales);
		min (sales);
		
	} // end of main
	
	/*
	 * Each of the last four methods will need to define the array as a parameter that is passed in on the method call.  
	 * So the methods will have a single parameter which is a double[]. 
	 * After you create the array in main, call each of the four methods so that they can print their information
	 */
	
	// a method that calculates and prints the total sales for the week
	public static void total( double[] array)
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		double total = 0;// initialize total 
		// add each of the elements to the total
		for (int counter = 0 ; counter < array.length ; ++counter)
			total += array[counter];
		// println command
		System.out.println ("The total sales for the week were: " + nf.format(total));
					
	} // end of total
	
	// a method that calculates and prints the average daily sales 
	public static void average( double[] array)
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		double total = 0; // initialize total 
		// add each of the elements to the total
		for (int i = 0 ; i < array.length ; ++i)
			total += array[i];
		// divide total by array length	
		System.out.println ("The average daily sales were: " + nf.format(total / array.length));
		
	} // end of average
	
	// method that determines and print  the maximum sales for any day of the week named max().  
	// Also print what day that occurred on (assuming we start our day on Sunday).
	public static void max(double[] array)
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		double max = 0; // var to determine the max, use this to store the max #
		int index = 0; // used to store the array's place in the index
		String day = ""; // used to print out the day
		
		// for loop will iterate through, on each pass it will check to see if the next index is higher than the max if so it becomes the new max
		// index will then also store the location of max in the array
		for (int i = 0; i < array.length ; ++i)
		{
			if (max < array[i])
			{
				max = array[i];
				index = i;
			}
		}
		// we will now set up if and else if statements to determine the day to print out
		if (index == 0)
			day = "Sunday";
		else if (index == 1)
				day = "Monday";
		else if (index == 2)
				day = "Tuesday";
		else if (index == 3)
				day = "Wednesday";
		else if (index == 4)
				day = "Thursday";
		else if (index == 5)
				day = "Friday";
		else if (index == 6)
				day = "Saturday";
		
		// print out
		System.out.println("The maximum sales for a day was: " + nf.format(max) + " that occurred on " + day);
		
	} // end of max
	
	// method that determines and prints the mimimum sales for the week named min(). 
	// Also print what day that occurred on (assuming we start our day on Sunday).
	public static void min(double[] array)
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		double min = array[0]; // var to determine the min, use this to store the min #
		int index = 0; // used to store the array's place in the index
		String day = ""; // used to print out the day
		
		// for loop will iterate through, on each pass it will check to see if the next index is less than the min if so it becomes the new min
		// index will then also store the location of min in the array
		for (int i = 0; i < array.length ; ++i)
		{
			if (min >= array[i])
			{
				min = array[i];
				index = i;
			}
		}
		// we will now set up if and else if statements to determine the day to print out
		if (index == 0)
			day = "Sunday";
		else if (index == 1)
				day = "Monday";
		else if (index == 2)
				day = "Tuesday";
		else if (index == 3)
				day = "Wednesday";
		else if (index == 4)
				day = "Thursday";
		else if (index == 5)
				day = "Friday";
		else if (index == 6)
				day = "Saturday";
		
		// print out
		System.out.println("The minimum sales for a day was: " + nf.format(min) + " that occurred on " + day);
		
	} // end of min
	
	
}
