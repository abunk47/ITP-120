/**
 * This class runs all the methods related to the Inventory menu items or class.  Such as add, delete, or edit inventory, and sales figures.  
 * As a number of methods dealt with the Inventory Class I felt like it was more convenient to put everything in one class.
 * @author A.Bunk 7.18.2014
 */

package finalproject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class InventoryMenu 
{
	Scanner scan = new Scanner (System.in);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	/**
	 * This is the main inventory menu.
	 * @param inv
	 */
	public void invMenu (ArrayList<Inventory> inv)
	{
		// add in a scanner
		// need a sub-menu here (so while loop with try and catch)
		int choice = 0;
		while (choice != -999)
		{
			try
			{
				System.out.println ("Inventory Menu: \n" + "1. Add a new item to the inventory\n2. Edit a current item in the inventory\n3. Delete an item in Inventory\n4. Exit");
				choice = scan.nextInt();
				
				if (choice == 1)
					typeMenu(inv);// do the method related to adding an inventory item
				else if (choice == 2)
					editInv(inv);
				// delete the inventory
				else if (choice == 3)
					deleteInv(inv);
				// exit the loop
				else if (choice == 4)
					choice = -999;
				// in case user puts in a number higher or lower than our choices
				else if (choice > 4 || choice < 1)
				{
					System.out.println("That is not a valid choice. Please try again!");
					choice = 0;
				}
				
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			}
		
		}
		
		// If the user chooses 2. then it should print all items in inventory and request the user to choose an item 
		// based on the item's id.  Once that has been chosen then the user should be given a sub-menu on what they want to edit 
		// A. Cost of Item, B. Price Sold At C. Exit then each of those items should be coded to their specific needs.
		//
	} // end of editInv method
	
	/**
	 * This is the menu a user will see when they choose to add a new item to the Inventory.
	 * @param inv
	 */
	public void typeMenu (ArrayList<Inventory> inv)
	{
		// For 1. you first need to ask the user what type of item it is, Tree, Perennial, Bulk Product
		// Then user needs to input info for the specific class of product they want, then add it to the inventory
		int type = 0;
		while (type !=-999)
		{
			try
			{
				System.out.println ("Please choose an item type to add to the inventory: ");
				System.out.println ("1. Tree\n2. Perennial\n3. Bulk Product\n4. Exit");
				type = scan.nextInt();
				
				if (type == 1)
					addTree(inv);
				else if (type == 2)
					addPeren(inv); // do the perennial method 
				else if (type == 3)
					addBulk(inv); // do the bulk product method
				else if (type == 4)
					type = -999;
				else if (type > 4 || type < 1)
				{
					System.out.println ("That is not a valid choice. Please try again!"); 
					type = 0;
				}
					

			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			}
		}
	} // end of typeMenu method
	
	// adds a new tree type item, a tree has a name (string), a cost to buy (double), a sales price( double), if it is an evergreen (boolean), and the number in stock (int)
	/**
	 * This is the main method when a user wants to add a tree type to the Inventory.
	 * @param inv
	 */
	public void addTree (ArrayList<Inventory> inv)
	{
		Trees t = new Trees();
		// need to set the loop triggers to know what fires off next
		boolean forward = false; // for the outermost loop
		// we will set 3 inner loops which will go through and add each part that is needed to construct a tree type
		while (forward != true)
			try
			{
				scan.nextLine(); // due to scanner issue
				// we need to set the item name
				System.out.println("Please enter the name of the tree: ");
				String tName = scan.nextLine();
				t.setItemName(tName);
				boolean inner = false;
				
				while (inner != true)
				{
					try
					{
						System.out.println ("Please enter the cost to purchase: ");
						double cost = scan.nextDouble();
						if (cost < 0.01)
						{
							System.out.println("Please enter the actual cost!");
							continue;
						}
						t.setCost(cost);
						while (inner != true)
						{
							try
							{
								System.out.println ("Please enter the amount in stock: ");
								int nis = scan.nextInt();
								if (nis < 0)
								{
									System.out.println("Please enter the actual amount in stock!");
									continue;
								}
								t.setNumInStock(nis);
								while (inner != true)
								{
									try
									{
										System.out.println ("Please enter the sales price: (It should be more than " + currency.format(t.getCost()) + ").");
										double sale = scan.nextDouble();
										if (sale < 0.01 || sale <= t.getCost())
										{
											System.out.println("Please enter the actual sales price!");
											continue;
										}
										t.setSalesPrice(sale);
										while (inner != true)
										{
											try
											{
												System.out.println ("Is the tree an evergreen? (Enter true or false): ");
												boolean evergreen = scan.nextBoolean();
												t.setEvergreen(evergreen);
												inv.add(t);
												System.out.println(t.toString() + "\n" + t.getItemName() + " has been sucessfully added to the Inventory!\n");
												inner = true;
												forward = true;
												
											}
											catch (InputMismatchException e)
											{
												System.out.println ("That is not a valid choice. Please try again!");  
												scan.nextLine();
											}
											
										}								
									}
									catch (InputMismatchException e)
									{
										System.out.println ("That is not a valid choice. Please try again!");  
										scan.nextLine();
									}
									
								}
								
								
							}
							catch (InputMismatchException e)
							{
								System.out.println ("That is not a valid choice. Please try again!");  
								scan.nextLine();
							}	
						}
						
					}
					catch (InputMismatchException e)
					{
						System.out.println ("That is not a valid choice. Please try again!");  
						scan.nextLine();
					}
					
				}
				
				
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			}
	} // end of add tree method
	
	
	/**
	 * This is the method used when a user wants to add a bulk product to the inventory list.
	 * @param inv
	 */
	public void addBulk (ArrayList<Inventory> inv)
	{
		// this has a weight question instead of the evergreen question
		BulkProducts bp = new BulkProducts();
		// need to set the loop triggers to know what fires off next
		boolean forward = false; // for the outermost loop
		// we will set 3 inner loops which will go through and add each part that is needed to construct a bulkproduct type
		while (forward != true)
			try
			{
				scan.nextLine(); // due to scanner issue
				// we need to set the item name
				System.out.println("Please enter the name of the product: ");
				String tName = scan.nextLine();
				bp.setItemName(tName);
				boolean inner = false;
				
				while (inner != true)
				{
					try
					{
						System.out.println ("Please enter the cost to purchase: ");
						double cost = scan.nextDouble();
						if (cost < 0.01)
						{
							System.out.println("Please enter the actual cost!");
							continue;
						}
						bp.setCost(cost);
						while (inner != true)
						{
							try
							{
								System.out.println ("Please enter the amount in stock: ");
								int nis = scan.nextInt();
								if (nis < 0)
								{
									System.out.println("Please enter the actual amount in stock!");
									continue;
								}
								bp.setNumInStock(nis);
								while (inner != true)
								{
									try
									{
										System.out.println ("Please enter the sales price: (It should be more than " + currency.format(bp.getCost()) + ").");
										double sale = scan.nextDouble();
										if (sale < 0.01 || sale <= bp.getCost())
										{
											System.out.println("Please enter the actual sales price!");
											continue;
										}
										bp.setSalesPrice(sale);
										while (inner != true)
										{
											try
											{
												System.out.println ("Please enter the weight of the item in pounds: ");
												double weight = scan.nextDouble();
												if (weight < 0)
												{
													System.out.println("Please enter the actual weight of the item in pounds!");
													continue;
												}
												bp.setWeight(weight);
												inv.add(bp);
												System.out.println(bp.toString() + "\n" + bp.getItemName() + " has been sucessfully added to the Inventory!\n");
												inner = true;
												forward = true;
												
											}
											catch (InputMismatchException e)
											{
												System.out.println ("That is not a valid choice. Please try again!");  
												scan.nextLine();
											}
											
										}								
									}
									catch (InputMismatchException e)
									{
										System.out.println ("That is not a valid choice. Please try again!");  
										scan.nextLine();
									}
									
								}
								
								
							}
							catch (InputMismatchException e)
							{
								System.out.println ("That is not a valid choice. Please try again!");  
								scan.nextLine();
							}	
						}
						
					}
					catch (InputMismatchException e)
					{
						System.out.println ("That is not a valid choice. Please try again!");  
						scan.nextLine();
					}
					
				}
				
				
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!");  
				scan.nextLine();
			}
		
	} // end of addBulk method
	
	/**
	 * This method allows a user to add a new Perennial item to the Inventory list.
	 * @param inv
	 */
	public void addPeren (ArrayList<Inventory> inv)
	{
		// this has a weight question instead of the evergreen question
				Perennials p = new Perennials();
				// need to set the loop triggers to know what fires off next
				boolean forward = false; // for the outermost loop
				// we will set 3 inner loops which will go through and add each part that is needed to construct a bulkproduct type
				while (forward != true)
					try
					{
						scan.nextLine(); // due to scanner issue
						// we need to set the item name
						System.out.println("Please enter the name of the perennial: ");
						String tName = scan.nextLine();
						p.setItemName(tName);
						boolean inner = false;
						
						while (inner != true)
						{
							try
							{
								System.out.println ("Please enter the cost to purchase: ");
								double cost = scan.nextDouble();
								if (cost < 0.01)
								{
									System.out.println("Please enter the actual cost!");
									continue;
								}
								p.setCost(cost);
								while (inner != true)
								{
									try
									{
										System.out.println ("Please enter the amount in stock: ");
										int nis = scan.nextInt();
										if (nis < 0)
										{
											System.out.println("Please enter the actual amount in stock!");
											continue;
										}
										p.setNumInStock(nis);
										while (inner != true)
										{
											try
											{
												System.out.println ("Please enter the sales price: (It should be more than " + currency.format(p.getCost()) + ").");
												double sale = scan.nextDouble();
												if (sale < 0.01 || sale <= p.getCost())
												{
													System.out.println("Please enter the actual sales price!");
													continue;
												}
												p.setSalesPrice(sale);
												while (inner != true)
												{
													try
													{
														scan.nextLine();
														System.out.println ("Please enter the perennial's flower's color: ");
														String color = scan.nextLine();
														p.setFlowerColor(color);
														inv.add(p);
														System.out.println(p.toString() + "\n" + p.getItemName() + " has been sucessfully added to the Inventory!\n");
														inner = true;
														forward = true;
														
													}
													catch (InputMismatchException e)
													{
														System.out.println ("That is not a valid choice. Please try again!");  
														scan.nextLine();
													}
													
												}								
											}
											catch (InputMismatchException e)
											{
												System.out.println ("That is not a valid choice. Please try again!");  
												scan.nextLine();
											}
											
										}
										
										
									}
									catch (InputMismatchException e)
									{
										System.out.println ("That is not a valid choice. Please try again!");  
										scan.nextLine();
									}	
								}
								
							}
							catch (InputMismatchException e)
							{
								System.out.println ("That is not a valid choice. Please try again!");  
								scan.nextLine();
							}
							
						}				
					}
					catch (InputMismatchException e)
					{
						System.out.println ("That is not a valid choice. Please try again!");  
						scan.nextLine();
					}
	} // end of addPeren method
	
	/**
	 * This method allows the user to edit inventory information.
	 * @param inv
	 */
	public void editInv (ArrayList<Inventory> inv)
	{
		// we then need to print out all of the inventory items for the user to see
		for (Inventory i : inv)
			System.out.println (i.toString());

		System.out.println("\nPlease note that you can only edit the Cost, Item Name, Number in Stock, and Sales Price in this menu.\nIf you'd like to edit specific information of an item" +
							" such as weight, evergreen, or color\nthen you should add a new item and delete the old one.");
		// for this method we will need a while loop
		int choice = 0;
		while (choice != -999)
		{
			// then ask the user to input the item they want to modify
			try
			{
				System.out.println("\nPlease input the item # you would like to edit: (or enter -999 to exit)");
				choice = scan.nextInt();
				if (choice == -999)
					break;
				if (choice < 1000 && choice != -999)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					continue;
				}
				else 
				{
					// set up a boolean that will let the user know if there item was not found
					boolean notFound = true;
					// get the item the user chose
					for (int i = 0; i < inv.size(); ++i)
					{
						if (choice == inv.get(i).getInvNum())
						{
							notFound = false;
							int decide = 0;
							while (decide != 5)
							{
								// print out the item so the user knows that they will be editing
								System.out.println (inv.get(i).toString());
								try
								{
									// give the user options on what to edit then set up if else if statements below for each item
									System.out.println("Please choose what you would like to edit about this item: \n1. Cost\n2. Item Name\n3. Number in Stock\n4. Sales Price\n5. Exit ");
									decide = scan.nextInt();
									if (decide < 1 || decide > 6)
									{
										System.out.println("That is not a valid choice. Please try again!");
										continue;
									}
									if (decide == 1)
									{
										while (decide == 1)
										{
											try
											{
												System.out.println ("Please enter the item's new cost:");
												double cost = scan.nextDouble();
												if (cost < 0.01)
												{
													System.out.println("Please enter the actual cost!");
												}
												else
												{
													inv.get(i).setCost(cost);
													if (inv.get(i).getCost() >= inv.get(i).getSalesPrice())
													{
														System.out.println("The cost is higher than or equal to the sale's price. Please modify the sales price.\n");
														decide = 4;
													}
													else 
														decide = 0;
												}
											}
											catch (InputMismatchException e)
											{
												System.out.println ("That is not a valid choice. Please try again!");  
												scan.nextLine();
											}
										}
									}
										
									if (decide == 2)
									{
										while (decide == 2)
										{
											try
											{
												scan.nextLine();
												System.out.println ("Please enter the item's new name:");
												String name = scan.nextLine();
												inv.get(i).setItemName(name);
												decide = 0;
											}
											catch (InputMismatchException e)
											{
												System.out.println ("That is not a valid choice. Please try again!");  
												scan.nextLine();
											}
										}
									}
									if (decide == 3)
									{
										while (decide == 3)
										{
											try
											{
												System.out.println ("Please enter the new amount in stock:");
												int nis = scan.nextInt();
												if (nis < 0)
												{
													System.out.println("Please enter the actual amount in stock!");
												}
													
												else
												{
													inv.get(i).setNumInStock(nis);
													decide = 0;
												}
											}
											catch (InputMismatchException e)
											{
												System.out.println ("That is not a valid choice. Please try again!");  
												scan.nextLine();
											}
										}
									}
									if (decide == 4)
									{
										while (decide == 4)
										{
											try
											{
												System.out.println ("Please enter the new sale price:");
												double sale = scan.nextDouble();
												if (sale < 0.01 || sale < inv.get(i).getCost())
													System.out.println("The price is below cost, please try again!");
												else
												{
													inv.get(i).setSalesPrice(sale);
													decide = 0;
												}
											}
											catch (InputMismatchException e)
											{
												System.out.println ("That is not a valid choice. Please try again!");  
												scan.nextLine();
											}
										}
									}

							
								}
								catch (InputMismatchException e)
								{
									System.out.println ("That is not a valid choice. Please try again!");  
									scan.nextLine();
								}
							}
						}
					}
					// let the user know the item was not found
					if (notFound == true)
						System.out.println ("That item # does not exist. Please try again!");
					
				}
				
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid choice. Please try again!\n");  
				scan.nextLine();
			}
		
		} // end of while loop
	} // end of editInv method
	
	/**
	 * This method sorts the Inventory ArrayList by the name of the item.
	 * @param inv
	 */
	public void compareInv (ArrayList<Inventory> inv)
	{
		for (int i = inv.size() - 1 ; i > 1; --i)
		{
			for (int j = 0; j < i ; ++j)
			{
				// need to get the first inventory item's name
				Inventory first = inv.get(j);
				// get second inv item's name
				Inventory second = inv.get(j+1);
				// now get stirng one and string two
				String one = first.getItemName();
				String two = second.getItemName();
				// if statement with the compare > 0
				if (one.compareTo(two) > 0)
				{
					// make sure to have within the loops the compare and set each one to the opposites place in the list
					inv.set(j, second);
					inv.set(j+1, first);
      
				}
			}
		}
	} // end of method
	
	/**
	 * This method allows the user to enter the name of the item they are interested in and the program will find the item.
	 * @param inv
	 */
	public void searchInv (ArrayList<Inventory> inv)
	{
		Scanner scan = new Scanner(System.in);
		// do a while loop with a try and catch
		boolean exit = false;
		while (exit != true)
		{
			try
			{
				// need a scanner and need to prompt the user to enter in the name of the item (string) they are looking for
				System.out.println("\nPlease enter the name of the item you would like to search the inventory for (or type 'exit' to return to the main menu): ");
				String search = scan.nextLine();
				// trim the string down 
				search = search.trim();
				// set up a string to make it lowercase to account for issues with searching
				if (search.toLowerCase().equals("exit"))
				{
					exit = true;
					continue;
				}
				// then we need to compare the Scanner string with the names of the different items
				// if they are similar then we need to print out the item's info so the user can find the info they need. 
				// if I put in "maple", it should find all of the maples
				// set a boolean if an item is found
				boolean found = false;
				System.out.println("\nThe following items contain the search terms you entered: ");
				for (int i = 0; i < inv.size(); ++i)
				{
					if (inv.get(i).getItemName().toLowerCase().contains(search.toLowerCase()))
					{
						System.out.println (inv.get(i).toString());
						found = true;
					}	
				}
				if (found == false)
					System.out.println("Your search was unable to return any relevant items. Please try again.");
				
				
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid item name. Please try again!\n");  
				scan.nextLine();
			}
		}
		
	} // end of searchInv method
	
	/**
	 * This method will delete an item in the inventory.
	 * @param inv
	 */
	public void deleteInv (ArrayList<Inventory> inv)
	{
		int choice = 0; // int for user to input the inv #
		boolean found = false; // to check if the item exists
		int index = 0; // the index location of the item to be deleted
		
		for (Inventory i : inv)
			System.out.println (i.toString());

		System.out.println("\nUsing this option will delete an inventory item from the database and should only be done at the request of a manager.");
		// for this method we will need a while loop
		while (choice != -999)
		{
			// then ask the user to input the item they want to modify
			try
			{
				System.out.println("\nPlease input the item # you would like to edit: (or enter -999 to exit)");
				choice = scan.nextInt();
				if (choice == -999)
					continue;
				else if (choice < 1000 && choice != -999)
				{
					System.out.println ("That is not a valid choice. Please try again!");  
					continue;
				}
				// then get the item they want to modify or if the item cannot be found then let the user know.  
				for (int i = 0; i < inv.size(); ++i)
				{
					if (choice == inv.get(i).getInvNum())
					{
						found = true;
						index = i;
						break;
					}
				}
				if (found == false)
					System.out.println ("That item # does not exist. Please try again!");
				else if (found == true)
				{
					if (inv.get(index).getNumInStock() > 0)
						System.out.println ("That item still has inventory in stock.  It is not recommended to delete an item if the item is still in stock.");
					boolean confirm = false;
					while (confirm != true)
					{
						
						try
						{
							System.out.println ("Please confirm the you would like to delete " + inv.get(index).getItemName() + ", please entere 'true' or 'false':");
							confirm = scan.nextBoolean();
							if (confirm == false)
							{
								choice = -999;
								confirm = true;
								continue;
							}
							if (confirm == true)
							{
								System.out.println ("Item: " + inv.get(index).getItemName() + " has been deleted!\n");
								inv.remove(index);
								choice = -999;
							}
						}
						catch (InputMismatchException e)
						{
							System.out.println ("That is not a valid entry. Please try again!\n");  
							scan.nextLine();
						}
					}
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println ("That is not a valid item number. Please try again!\n");  
				scan.nextLine();
			}
		}
	} // end of delete inventory method
} // end of class
