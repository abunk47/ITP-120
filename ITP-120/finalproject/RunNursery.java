/**
 *  This program allows a user to interact with data from a garden nursery.  It allows the user to add/delete
 *  and export/import customer, sales, and inventory data. The code is a mix of Dr. Wolff's and my own. 
 *  @author A.Bunk 7.11.2014
 */
package finalproject;

import java.text.NumberFormat;
import java.util.*;


public class RunNursery 
{

	/**
	 * Main driver program.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		// Setup the array lists for customer, sales, and inventory
		ArrayList<Customer> cust = new ArrayList<Customer>();
		ArrayList<Sales> sales = new ArrayList<Sales>();
		ArrayList<Inventory> inv = new ArrayList<Inventory>();
		MenuInfo mi = new MenuInfo();
		InventoryMenu im = new InventoryMenu();
		ImportMenu imMenu = new ImportMenu();
		ExportMenu emMenu = new ExportMenu();
		Analytics a = new Analytics();
		CustMenu cm = new CustMenu();
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		// load the customer data
		loadData(cust, sales, inv);
		// if possible we should set up a window the user can use to interact with to make their selections
		// that would be a lot better than the current situation
		int choice = 0;
		// Continuing looping through the menu until the user exits
		// need to finish filling all of these in
		while (choice !=13)
		{
			// Show the menu
			choice = showMenu();
			if (choice==-1)
				mi.printAll(cust,sales,inv);
			else if (choice== 1) 
				mi.printSales(sales);
			else if (choice== 2)
			{  // should be sorted  alphabetically by the inventory name
				// need to figure out what is wrong here
				im.compareInv(inv);
				System.out.println("\nInventory:");
				double total = 0;
				for (int i = 0; i < inv.size(); ++i)
				{
					System.out.println(inv.get(i).toString());
					total = (inv.get(i).getCost() * inv.get(i).getNumInStock()) + total;
				}
				
				System.out.println("\nThe total value of all inventory is: " + currency.format(total));
			}
			else if (choice== 3) 
			{
				cm.compareCust(cust);
				for (int i = 0; i < cust.size(); ++i)
					System.out.println(cust.get(i).toString());
			}
			else if (choice== 4) 
				cm.addCust(cust);
			else if (choice== 5) 
				cm.deleteCust(cust);
			else if (choice== 6) 
				sale(inv, sales, cust);
			else if (choice== 7)
				im.invMenu(inv);	
			else if (choice== 8)  
				a.findSales(inv, sales);
			else if (choice== 9) 
				im.searchInv(inv);
			else if (choice== 10) 
			{
				Scanner scan = new Scanner (System.in);
				int decision = 0;
				try 
				{
					while (decision != 4)
					{
		    			System.out.println("Please select a file type to import:\n");
		    			System.out.println("1. Customer Information\n" + "2. Sales Information\n" + "3. Inventory Information\n" + "4. Exit");
		    			decision = scan.nextInt();
		    			if (decision == 1)
		    			{
		    				System.out.println("Please choose a location to import the Customer file: ");
		    				cust = imMenu.readSerializableCust();
		    			}
		    			else if (decision == 2)
		    			{
		    				System.out.println("Please choose a location to import the Sales file: ");
		    				sales = imMenu.readSerializableSales();
		    			}
		    			else if (decision == 3)
		    			{
		    				System.out.println("Please choose a location to import the Inventory file: ");
		    				inv = imMenu.readSerializableInv(); 				
		    			}
		    			else if (decision == 4)
		    				System.out.println("Thank you!");
		    			else if (decision > 4)
		    				System.out.println("That is not a valid choice. Please try again!");
		    			else if (decision < 1)
				            System.out.println("That is not a valid choice. Please try again!");
					}
				}
				catch (InputMismatchException e)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					scan.nextLine();
				}  
				
				
			}
			else if (choice== 11) 
				emMenu.menu(cust, sales, inv);
	    	else if (choice== 12) 
	    	{
	    		Scanner scan = new Scanner (System.in);
	    		int password = 0;
	    		while (password != 1234)
	    		{
	    			try 
	    			{
	    				System.out.println ("Please enter the Manager Password or press 2 to exit:");
	    				password = scan.nextInt();
	    				if (password == 1234)
	    					clearAll(cust, sales, inv);
	    				if (password == 2) 
	    					break;
	    				if (password > 2 && password != 1234)
	    					System.out.println("That is not a valid choice. Please try again!");
	    				if (password < 2) 
	    					System.out.println("That is not a valid choice. Please try again!");
	    			}
	    			catch (InputMismatchException e)
	    			{
	    				System.out.println ("That is not a valid choice. Please try again!");  
	    				scan.nextLine();
	    			}  
	    		}
	    	}
	    
	    	else if (choice== 13) 
	    	{
	    		System.out.println("Thanks for using my program!");
	    		System.exit(0);
	    		// should write out the files and close
	    	}
	    	else if (choice > 13)
	    		System.out.println ("That is not a valid choice. Please try again!");
	    	else if (choice < -1)
	    		System.out.println ("That is not a valid choice. Please try again!");
		} // end of while loop
	} // end of main method

	/**
	 * This is the menu that is displayed to the user to select what they want to do in the main program.
	 * @return
	 */
	public static int showMenu()
	{
		int value = 0;
		Scanner scan = new Scanner(System.in);
		try 
		{
		    System.out.println("\n\nPlease choose from one of the following options:");
		    System.out.println("    (-1 to list all of the raw data)");
		    // DONE FOR YOU but you need to fix the net sales cost
		    System.out.println("1.  Print all sales and the total value");
		    // each sales should have a sub-total (the one you fixed above) and then an overall total for all of the sales
		    System.out.println("2.  Print all inventory items and total values");
		    // should be sorted  alphabetically by the inventory name
		    System.out.println("3.  List all current customers");
		    // alphabetically by last and then first name
		    System.out.println("4.  Add a customer");
		    // make certain that they are unique.  No duplicate first plus last names
		    System.out.println("5.  Delete a customer");
		    // Indicate if they do not exist
		    System.out.println("6.  Make a sale");
		    // make certain to deduct the amount from inventory.  
		    // Make certain that there is enough in the inventory for the sales
		    // Make certain to add the sales to the sales list
		    
		    System.out.println("7.  Add, Delete, or Edit Inventory");
		    // should be able to add to a current inventory item or add a new item
		    // should be able to edit only the two prices
		    // a sub-menu would work well here.
		    System.out.println("8.  List all sales for a given item sorted by date");
		    // show them all the inventory items and ask them for the inventory id
		    // then show all sales for that item sorted by date
		    System.out.println("9.  Search for item by name or part name");
		    // if I put in "maple", it should find all of the maples
		    System.out.println ("10. Import Customer, Sales, or Inventory data");
		    // need to check if these work
		    System.out.println ("11. Export Customer, Sales, or Inventory data");
		    // need to check if these work
		    System.out.println ("12. Clear Data (Need Manager Password)");
		    // need to check if these work
		    System.out.println("13. Exit");
		    // should write out the files and close
		    value = scan.nextInt();

		}
		catch (InputMismatchException e)
		{
			System.out.println ("That is not a valid choice. Please try again!");  
			scan.nextLine();
		} 
		return value;
	}
	
	/**
	 * This method basically just loads the data into the different ArrayLists created in the main method.
	 * I modified the dates of the sales so as to make them more recent for the use of the Analytics class
	 * @param cust
	 * @param sales
	 * @param inv
	 */
	public static void loadData(ArrayList<Customer> cust, ArrayList<Sales> sales, ArrayList<Inventory> inv)
	{
	  // Some customer data
	  cust.add(new Customer("Wolff", "Diane", "Retail", 0));
	  cust.add(new Customer("Mouse", "Mickey", "Retail", 0));
	  cust.add(new Customer("Duck", "Donald", "Wholesale", 15));
	  cust.add(new Customer("Miller", "Mike", "Wholesale", 10));
	  // Some inventory data
	  inv.add(new BulkProducts(0.10, "Soil", 50000, 0.25, 100000));
	  inv.add(new BulkProducts(0.30, "Mulch", 5000, 0.60, 10000));
	  inv.add(new Perennials(1.75, "Lilly", 75, 4.99, "white"));
	  inv.add(new Perennials(5.99, "KnockOut Rose", 500, 10.99, "purple"));
	  inv.add(new Perennials(12.99, "KnockOut Rose", 500, 19.99, "yellow"));
	  inv.add(new Trees(16.00, "Eastern White Pine", 300, 29.50, true));
	  inv.add(new Trees(35.00, "Sugar Maple", 90, 65.00, false));
	  inv.add(new Trees(120.00, "Japanese Maple", 25, 165.00, false));
	  inv.add(new Trees(82.00, "Norway Maple", 12, 165.00, false));
	  inv.add(new Trees(20.00, "Virginia Pine", 30, 45.00, true));
	  // Some sales data
	  sales.add(new Sales(cust.get(0), new Day(), inv.get(5), 25));
	  sales.add(new Sales(cust.get(1), new Day(2014, 5, 30), inv.get(0), 3500));
	  sales.add(new Sales(cust.get(2), new Day(2013, 10, 29), inv.get(4), 5));
	  sales.add(new Sales(cust.get(3), new Day(2013, 10, 28), inv.get(2), 10));
	  sales.add(new Sales(cust.get(0), new Day(2013, 12, 28), inv.get(3), 15));
	  sales.add(new Sales(cust.get(1), new Day(2014, 1, 27), inv.get(5), 20));
	  sales.add(new Sales(cust.get(2), new Day(2014, 2, 26), inv.get(0), 25));
	  sales.add(new Sales(cust.get(3), new Day(2014, 2, 26), inv.get(4), 30));
	  sales.add(new Sales(cust.get(0), new Day(2014, 3, 26), inv.get(2), 35));
	  sales.add(new Sales(cust.get(1), new Day(2014, 3, 25), inv.get(3), 40));
	  sales.add(new Sales(cust.get(2), new Day(2014, 4, 24), inv.get(1), 45));
	  sales.add(new Sales(cust.get(3), new Day(2014, 4, 20), inv.get(1), 50));
	}

	/**
	 * Clears out all the ArrayLists.
	 * @param cust
	 * @param sales
	 * @param inv
	 */
	private static void clearAll(ArrayList<Customer> cust, ArrayList<Sales> sales, ArrayList<Inventory> inv)
	{
		cust.removeAll(cust);
		sales.removeAll(sales);
		inv.removeAll(inv);
		System.out.println("All records have been successfully deleted.");
	}
 
	/**
	 * This method conducts a sale and will create a new sales object and will deduct the item the user purchases from the 
	 * appropriate object in the Inventory ArrayList. The sales object will be added to the sales ArrayList as well. 
	 * @param inv
	 * @param s
	 * @param cust
	 */
	public static void sale (ArrayList<Inventory> inv, ArrayList<Sales> s, ArrayList<Customer> cust )
	{
		// create a new sale item
		Scanner scan = new Scanner(System.in);
		Sales newSale = new Sales ();
		int choice = 0; // used to identify the inventory item the user wants to purchase
		int amount = 0; // used to determine how many of the item the customer wants to purchase
		int custId = 0; // used to determine the Customer that is making the purchase
		boolean custCheck = false; // used to see if the customer is in the system
		boolean invCheck = false; // used to see if the item is in the inventory
		// set up a menu to add the customer's sale id, the inv # and sale amount, 
		while (custId != -999)
		{
			try
			{
				for (Customer c : cust)
				{
					System.out.println (c.toString());
				}
				System.out.println ("\nPlease enter the Customer # of the purchaser: (or enter -999 to exit) ");
				custId = scan.nextInt();
				if (custId <= 0 && custId != -999)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					continue;
				}
				else if (custId > 0 && custId < 100)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					continue;
				}
				if (custId == -999)
				{
					custCheck = false;
					continue;
				}
				boolean numFound = false;
				for (int i = 0; i < cust.size(); ++i)
				{
					if (custId == cust.get(i).getCustNum())
					{
						newSale.setCust(cust.get(i));
						numFound = true;
						custCheck = true;
						custId = -999;
					}
				}
       
				if (numFound == false)
					System.out.println ("The customer # you entered does not exist. Please try again.");
       
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid #. Please try again!\n");  
				scan.nextLine();
			}
		} // end of custId while loop   
		while (custCheck == true)
		{
			// we need to print out the inventory and have the user enter the item # and amount to purchase
			for (Inventory i : inv)
				System.out.println (i.toString());
			// You need to include an if statement to make sure there is enough of the item in inventory.
			try
			{
				System.out.println ("\nPlease enter the Item # of the inventory item the Customer would like to purchase: (or -999 to exit)");
				choice = scan.nextInt();
				if (choice <= 0 && choice != -999)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					continue;
				}
				else if (choice > 0 && choice < 1000)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					continue;
				}
				if (choice == -999)
				{
					custCheck = false;
					break;
				}
				// need to make sure that item exists in the Inventory
				boolean invFound = false;
				for (int i = 0; i < inv.size(); ++i)
				{
					if (choice == inv.get(i).getInvNum())
					{
						newSale.setInv(inv.get(i));
						invFound = true;
						custCheck = false;
						invCheck = true;
					}
				}    
				if (invFound == false)
					System.out.println ("That item does not exist in the inventory!");
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid #. Please try again!");  
				scan.nextLine();
			}
		} // end of choice while loop  
		while (invCheck == true)
		{
			try 
			{
				System.out.println ("\nPlease enter the amount in whole numbers the customer would like to purchase: (or enter -999 to exit)");
				if (newSale.getCust().getType().equals("Retail"))
					System.out.println ("Remember!!! Retail customers recieve a 5% discount on purchases of $200 or more everyday!");
				amount = scan.nextInt();
				if (amount <= 0 && amount != -999)
				{
					System.out.println ("Try again! This time please enter an actual amount!");  
					continue;
				}
				if (amount == -999)
				{
					invCheck = false;
					continue;
				}
				if (amount > newSale.getInv().getNumInStock())
				{
					System.out.println ("There is not enough of that item in stock to complete the transaction!");
					continue;
				}   
				else if (amount < newSale.getInv().getNumInStock() || amount == newSale.getInv().getNumInStock())
				{
					System.out.println ("That amount will be deducted from the inventory.");
					int newAmount = newSale.getInv().getNumInStock() - amount;
					newSale.getInv().setNumInStock(newAmount);
					newSale.setNumBought(amount);
					Day day = new Day();
					newSale.setDateSold(day);
					s.add(newSale);
					System.out.println(s.get(s.size()-1).toString());
					invCheck = false;
					if (newSale.getInv().getNumInStock() == 0)
						System.out.println ("\nPlease restock " + newSale.getInv().getItemName() + " Inventory #: " + newSale.getInv().getInvNum() + ".");
				}
       
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid #. Please try again!");  
				scan.nextLine();
			}
		} // end of amount while loop
	} // end of method

} // end of class