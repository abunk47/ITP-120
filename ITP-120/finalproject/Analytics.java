/**
 * This class was setup to hold the different Sales related analytical methods.  Such as sales figures and other information.
 * @author A.Bunk 7.18.2014
 */

package finalproject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Analytics 
{
	Scanner scan = new Scanner(System.in);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	/**
	 * This method will find the sales amount and all the sales for a given item in the Inventory.  It will then describe the sales and profit amounts by days.
	 * This method requires Inventory and Sales ArrayLists
	 * @param i
	 * @param s
	 */
	public void findSales (ArrayList<Inventory> inv, ArrayList<Sales> s)
	{
		// set up choice int we will use for the Item #, item is used to hold the inv item #
		int item = 0;
		int choice = 0;
		boolean itemFound = false; // used to determine if the item has been found
		int day = 0; // used to figure out how many days the user wants to use
		ArrayList<Sales> itemSales = new ArrayList<Sales>(); 
		// print out all the inventory items
		for (Inventory i : inv)
			System.out.println(i.toString());
		while (itemFound == false)
		{
			try
			{
				// get the user to input the Item # they want info for
				System.out.println("\nPlease enter the Item # of the item you would like sales information for: (or enter -999 to exit)");
				choice = scan.nextInt();
				// set the way to exit the loop
				if (choice == -999)
				{
					itemFound = true;
					continue;
				}
				// set the loop to see if the Item # exists and the boolean in case no item is found
				for (int j = 0; j < inv.size() ; ++j)
				{
					// set up an if loop to see if choice is equal to an Inventory #
					if (choice == inv.get(j).getInvNum())
					{
						item = inv.get(j).getInvNum();
						// now print out each sale that corresponds with that Inv #
						for (int k = 0; k < s.size(); ++k)
						{
							// now set up an if statement to match the sale with the Item #. If they match add that sale to the itemSales List that we will sort
							if (choice == s.get(k).getInv().getInvNum())
								itemSales.add(s.get(k));
						}
						itemFound = true;
					}	
				}	
				if (itemFound == false)
					System.out.println("Sorry, that item could not be found. Please try again!");
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			}
			
		}
		
		if (choice != -999)
		{
			// need to add in an if  else statement 
			if (itemSales.size() == 0)
			{
				System.out.println("No sales could be found for that item.");
				System.out.println ("You may want to think about discounting this item so as to make space for better selling items.");
				day = -999; 
			}
			else 
			{
				sortSales(itemSales);
				for (Sales thing : itemSales)
					System.out.println(thing.toString());
				// need to print the netSales and netProfit totals for this item
				System.out.println ("\nThe net sales for Item #" + item + " are: " + currency.format(netSales(itemSales)));
				System.out.println ("The net profits for Item #" + item + " are: " + currency.format(netProfit(itemSales)));
			}
		}	
		// now allow the user to input the amount of days they want to check sales for
		// int to use for days
		while (day != -999)
		{
			try
			{
				System.out.println("\nPlease enter the number of days you would like to check sales figures for: (or enter -999 to exit)");
				day = scan.nextInt();
				if (day == -999)
					continue;
				if (day < 1 && day != -999)
				{
					System.out.println("That is not a valid # of days please try again.");
					continue;
				}
				if (choice >= 1)
				{
					System.out.println("The " + day + " day sales for Item #" + item + " are:" + currency.format(salesByDate(day, itemSales)));
					System.out.println("The " + day + " day profits for Item #" + item + " are:" + currency.format(profitByDate(day, itemSales)));
					if (salesByDate(180, itemSales) == 0)
						System.out.println ("You may want to think about discounting this item so as to make space for better selling items.");
					if (salesByDate(180, itemSales) >= 1000)
						System.out.println("This item is selling well and you may want to get more of this item.");
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			}
			
		}
	} // end of method findSales
	
	/**
	 * This method will sort an ArrayList of Sales by the date of the sale.
	 * @param s
	 */
	public void sortSales (ArrayList<Sales> s)
	{
		for (int i = s.size() - 1 ; i > 0; --i)
		{
			for (int j = 0; j < i; ++j)
			{
				// need to get the first sales item 
				Sales first = s.get(j);
				// get second inv item
				Sales second = s.get(j+1);
				// now get string one and string two
				Day one = first.getDateSold();
				Day two = second.getDateSold();
				// if statement with the compare > 0
				if (two.comesBefore(one))
				{
					// make sure to have within the loops the compare and set each one to the opposites place in the list
					s.set(j, second);
					s.set(j+1, first);
				}
			}
		}
	} // end of sortSales method
	
	/**
	 * This method provides the netSales for a list of sales (this would be the total revenue before costs and sales tax are taken out).
	 * @param s
	 * @return double showing the netSales
	 */
	public double netSales (ArrayList<Sales> s)
	{
		double total = 0;
		// set up a loop to iterate through the list and then add to the total with each sale's netSale method
		for (int i = 0; i < s.size(); ++i)
			total = s.get(i).netSales() + total;
		return total;
	}
	
	/**
	 * This method provides the netProfit of a list of sales (this would be the profits after deducting sales tax and costs).
	 * @param s
	 * @return double showing the netProfit
	 */
	public double netProfit (ArrayList<Sales> s)
	{
		double total = 0;
		// set up a loop to iterate through the list and then add to the total with each sale's netSale method
		for (int i = 0; i < s.size(); ++i)
			total = s.get(i).netProfit() + total;
		return total;
	}
	
	
	/**
	 * This method will determine the net sales of an item over a certain period of time.
	 * @param d
	 * @return amount of net sales based on the amount of time
	 */
	public double salesByDate (int d, ArrayList<Sales> s)
	{
		
		// we need to get all the sales that occurred over the d # of days
		Day today = new Day();
		Day before = new Day();
		// make it so we set before to the # of days specified by the user
		before.advance(-d);
		double total = 0;
		for (int i = 0; i < s.size(); ++i)
		{
			// check to see if the sale occurred with the d # of days if it did add that sale netSales to the total
			if (s.get(i).getDateSold().comesBefore(today) && s.get(i).getDateSold().comesAfter(before))
				total = s.get(i).netSales() + total;	
		}
		return total;
		
	}
	
	/**
	 * This method will determine the net profit of an item over a certain period of time.
	 * @param d
	 * @return amount of net profit based on the amount of time
	 */
	public double profitByDate (int d, ArrayList<Sales> s)
	{
		// we need to get all the sales that occurred over the d # of days
		Day today = new Day();
		Day before = new Day();
		// make it so we set before to the # of days specified by the user
		before.advance(-d);
		double total = 0;
		for (int i = 0; i < s.size(); ++i)
		{
			// check to see if the sale occurred with the d # of days if it did add that sale netSales to the total
			if (s.get(i).getDateSold().comesBefore(today) && s.get(i).getDateSold().comesAfter(before))
				total = s.get(i).netProfit() + total;	
		}
		return total;
		
	}
	
	
} // end of class Analytics
