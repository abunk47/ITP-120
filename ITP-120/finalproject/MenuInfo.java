/**
 * This class provides a place to hold methods related to different print methods that did not seem to fit in any of the other classes.  
 */

package finalproject;


import java.text.NumberFormat;
import java.util.*;

public class MenuInfo
{
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	/**
	 * Prints out each of the ArrayLists starting with Customer
	 * @param cust
	 * @param sales
	 * @param inv
	 */
	public void printAll(ArrayList<Customer> cust, ArrayList<Sales> sales , ArrayList<Inventory> inv)
	{
		System.out.println("\nCustomers:");
		for(Customer c: cust)
			System.out.println(c.toString());
		System.out.println("\nSales:");
		for(Sales s: sales)
			System.out.println(s.toString());
		System.out.println("\nInventory:");
		for(Inventory i: inv)
			System.out.println(i.toString());
	}
  
	/**
	 * Prints out each of the sales and then prints out the total sales.  
	 * @param sales
	 */
	public void printSales(ArrayList<Sales> sales)
	{
		double total = 0;
		System.out.println("\nSales:");
		for (Sales s : sales)
		{
			System.out.println (s.toString());
			total = s.netSales() + total;
		}
		System.out.println ("\nThe total sales were: " + currency.format(total));
    
	}

}