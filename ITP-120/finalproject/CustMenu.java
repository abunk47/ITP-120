/**
 * This class contains methods for adding, deleting, and removing customers.  I organized those methods here since it allowed the RunNursery class to be a bit less cluttered
 * and all of these methods relate to the Customer class.
 * @author A.Bunk 7.16.2014
 */

package finalproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustMenu 
{
	/**
	 * This method allows the user to add a customer to the cust ArrayList
	 * @param cust
	 */
	public void addCust (ArrayList<Customer> cust)
	{
		Customer c = new Customer(); // new Customer object
		boolean carryOn = true;  // used to see if we set the customer's type as either Retail or Wholesale
		boolean keepGoing = false; // used to see if we set the customer's discount code
		Scanner scan = new Scanner (System.in);
		int choice = 0;
		while (choice == 0)
		{
			try 
			{
				System.out.println("Please enter the customer's last name: ");
				String last = scan.nextLine();
				c.setLast(last);
			      
				System.out.println("Please enter the customer's first name: ");
				String first = scan.nextLine();
				c.setFirst(first);
			
		
				System.out.println("Is the name correct? " + c.getLast() + ", " + c.getFirst() +
						"\nPlease put 1 for Yes or 2 for No:");
				choice = scan.nextInt();
				if (choice == 2)
				{
					choice = 0;
					scan.nextLine();
					continue;
				}
				if (choice > 2 || choice < 1)
					choice = 0;
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			} 
		} // end of while loop
		for (int i = 0; i < cust.size(); ++i)
		{
			// compare input with customer's last name 
			if (c.getLast().toLowerCase().equals(cust.get(i).getLast().toLowerCase()))   
			{
				if (c.getFirst().toLowerCase().equals(cust.get(i).getFirst().toLowerCase()))
				{
					System.out.println ("This customer is already in the system.\n" + cust.get(i).toString());   
					carryOn = false;
				}
			}
		} 
 

		while (carryOn == true)
		{  
			try 
			{
				System.out.println ("Please enter the customer type: \n1. for Retail\n2. for Wholesale");
				int type = scan.nextInt();
				if (type == 1)
				{
					String retail = "Retail";
					c.setType(retail);
					c.setDiscountPercent(0);
					cust.add(c);
					keepGoing = false;
					carryOn = false;
					System.out.println(c.toString() + "\nHas been added to the Customer list.");
				}
				else if (type == 2)
				{
					String whole = "Wholesale";
					c.setType(whole);
					keepGoing = true;
					carryOn = false;
				}
				else if (type > 2)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					scan.nextLine();
				}  
				else if (type < 1)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					scan.nextLine();
				}  
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			}  
		}
  
		while (keepGoing == true)
		{
			try 
			{
				System.out.println ("Please enter the customer's discount % (enter a whole number):");
				int discount = scan.nextInt();
				if (discount < 0 || discount > 50)
				{
					System.out.println ("That is not a valid discount amount. Please try again.");
					continue;
				}
				c.setDiscountPercent(discount);
				cust.add(c);
				keepGoing = false;  
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid entry. Please try again!");  
				scan.nextLine();
			}  
		}
	} // end of method
	
	/**
	 * This method sorts the customer's by their last name and then their first name.
	 * @param c
	 */
	public void compareCust(ArrayList<Customer> c)
	{
		for (int i = c.size() - 1 ; i > 0; --i)
		{
			for (int j = 0; j < i; ++j)
			{
				// need to get the first inventory item's name
				Customer first = c.get(j);
				// get second inv item's name
				Customer second = c.get(j+1);
				// now get string one and string two
				String one = first.getLast();
				String two = second.getLast();
				// if statement with the compare > 0
				if (two.compareTo(one) < 0)
				{
					// make sure to have within the loops the compare and set each one to the opposites place in the list
					c.set(j, second);
					c.set(j+1, first);
        
				}
				
				for (int k = 0; k < j; ++k)
				{
					Customer custOne = c.get(k);
					Customer custTwo = c.get(k+1);
					String nameFirst = custOne.getFirst();
					String nameTwo = custTwo.getFirst();
					if (nameTwo.compareTo(nameFirst) < 0)
					{
						c.set(k, custOne);
						c.set(k+1, custTwo);
						
					}
				}
			}
		}
	} // end of compareCust
	

	/**
	 * This method allows the user to delete a customer from the cust ArrayList
	 * @param cust
	 */
	public void deleteCust (ArrayList <Customer> cust)
	{
		// first we need to print out all the customer ids and add try and catch statements as well as a while loop
		Scanner scan = new Scanner (System.in);
		int choice = 0; // used to record the customer's choice
		while (choice != 3)
		{
			try
			{
				// the menu should have three options, check customer ids, delete a customer, and exit.
				System.out.println ("Please choose a choice from below: ");
				System.out.println ("1. Check Customer #'s\n2. Delete a Customer\n3. Exit");
				choice = scan.nextInt();
				// then we need to prompt the user to choose a customer to delete then have the program del
				if (choice == 1)
				{
					for (Customer c : cust)
						System.out.println(c.toString());
				}
				// allow the user to choose the cust # to delete, use an if statement to compare the ID numbers
				if (choice == 2)
				{
					int custId = 0;
					while (custId != -999)
					{
						try 
						{
							System.out.println ("Please input the Customer # of the record you want to delete (or -999 to exit): ");
							custId = scan.nextInt();
							boolean found = false;
							// if they choose a number that doesn't match a customer let the user know the cust doesn't exist and to try again
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
							// allow them a way to get out of the loop manually
							else if (custId == -999)
							{
								continue;
							}
							for (int i = 0; i < cust.size(); ++i)
							{
								if (custId == cust.get(i).getCustNum())
								{
									System.out.println (cust.get(i).getFirst() + " " + cust.get(i).getLast() + " has been removed from the system.\n");
									cust.remove(i);
									found = true;
									break;
								}
							}
							if (found == false)
							{
								System.out.println ("The Customer # you provided was not found.  Please try again!");
								continue;
							}
							
                
						}
						catch (InputMismatchException e)
						{
							System.out.println ("That is not a valid choice. Please try again!");  
							scan.nextLine();
						} 
					}
				}
				if (choice ==  3)
					continue;
				if (choice > 3 || choice < 1)
				{
					System.out.println ("That is not a valid choice. Please try again!");
					continue;
				}
					
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			} 
		} // end of try statement
	} // end of deleteCust
} // end of class
