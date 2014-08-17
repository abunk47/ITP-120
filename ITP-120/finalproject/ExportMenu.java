/**
 * This class allows someone to export byte files of data on customer. inventory, and sales information.
 * The information is organized into three methods.  A user can choose which one they want to use.
 * 
 * @author A.Bunk 7.13.2014
 */

package finalproject;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class ExportMenu implements Serializable 
{
	/**
	 * This is the base menu the user sees when they want to export files.
	 * @param cust
	 * @param sales
	 * @param inv
	 */
	public void menu (ArrayList<Customer> cust, ArrayList<Sales> sales, ArrayList<Inventory> inv)
	{
		Scanner scan = new Scanner (System.in);
		int decision = 0;
		try 
		{
			while (decision != 4)
			{
				System.out.println("Please select a file type to export:");
				System.out.println("1. Customer Information\n" + "2. Sales Information\n" + "3. Inventory Information\n" + "4. Exit");
				decision = scan.nextInt();
				scan.nextLine();
				if (decision == 1)
				{
					System.out.println("Please choose a location to export the files: ");
					writeSerializableCust(cust);
				}
				else if (decision == 2)
				{
					System.out.println("Please choose a location to export the files: ");
					writeSerializableSales(sales);
				}
				else if (decision == 3)
				{
					System.out.println("Please choose a location to export the files: ");
					writeSerializableInv(inv);
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
	
	/**
	 * Allows the user to export customer type files.
	 * @param cust
	 */
	public void writeSerializableCust(ArrayList<Customer> cust)
	{
		{
			// create the frame for the dialog box
			Frame f = new Frame ();
			// decide where to save the file 
			FileDialog foBox = new FileDialog(f, "Saving Customer file", FileDialog.SAVE);
			foBox.setVisible(true);
			// we need to get the path where the file will be stored.
			// the user will pick one from the dialog box
			// the combination of the directory name plus the file name is the absolute path
			String foName = foBox.getFile();
			String dirPath = foBox.getDirectory();
			// create a File instance for that absolute path
			File outFile = new File (dirPath + foName);
			// create a PrintWriter
			FileOutputStream OS = null;
			ObjectOutputStream OOS = null;
			
			try
			{
				// create the FileOutputStream object
				OS = new FileOutputStream(outFile);
				// create the ObjectOutputStream object
				OOS = new ObjectOutputStream(OS);
				// write out the array list
				OOS.writeObject(cust);	
			}
			// catch any IOExceptions that occur
			catch (IOException io) 
			{
				io.printStackTrace(); // this shows if there are any errors
				System.out.println("An IO Exception occurred");
			}
			
			finally // this always runs no matter what so close the file here
			{ // close the file.
				try 
				{
					OOS.close();
				}
				catch (Exception e)
				{}
			}
		}
	}
	
	/**
	 * Allows the user to export Sales class files.
	 * @param sales
	 */
	public void writeSerializableSales(ArrayList<Sales> sales)
	{
		{
			// create the frame for the dialog box
			Frame f = new Frame ();
			// decide where to save the file 
			FileDialog foBox = new FileDialog(f, "Saving Sales file", FileDialog.SAVE);
			foBox.setVisible(true);
			// we need to get the path where the file will be stored.
			// the user will pick one from the dialog box
			// the combination of the directory name plus the file name is the absolute path
			String foName = foBox.getFile();
			String dirPath = foBox.getDirectory();
			// create a File instance for that absolute path
			File outFile = new File (dirPath + foName);
			// create a PrintWriter
			FileOutputStream OS = null;
			ObjectOutputStream OOS = null;
			
			try
			{
				// create the FileOutputStream object
				OS = new FileOutputStream(outFile);
				// create the ObjectOutputStream object
				OOS = new ObjectOutputStream(OS);
				// write out the array list
				OOS.writeObject(sales);	
			}
			// catch any IOExceptions that occur
			catch (IOException io) 
			{
				io.printStackTrace(); // this shows if there are any errors
				System.out.println("An IO Exception occurred");
			}
			
			finally // this always runs no matter what so close the file here
			{ // close the file.
				try 
				{
					OOS.close();
				}
				catch (Exception e)
				{}
			}
		}
	}
	
	/**
	 * Allows the user to export Inventory class files.
	 * @param inv
	 */
	public void writeSerializableInv(ArrayList<Inventory> inv)
	{
		{
			// create the frame for the dialog box
			Frame f = new Frame ();
			// decide where to save the file 
			FileDialog foBox = new FileDialog(f, "Saving Inventory file", FileDialog.SAVE);
			foBox.setVisible(true);
			// we need to get the path where the file will be stored.
			// the user will pick one from the dialog box
			// the combination of the directory name plus the file name is the absolute path
			String foName = foBox.getFile();
			String dirPath = foBox.getDirectory();
			// create a File instance for that absolute path
			File outFile = new File (dirPath + foName);
			// create a PrintWriter
			FileOutputStream OS = null;
			ObjectOutputStream OOS = null;
			
			try
			{
				// create the FileOutputStream object
				OS = new FileOutputStream(outFile);
				// create the ObjectOutputStream object
				OOS = new ObjectOutputStream(OS);
				// write out the array list
				OOS.writeObject(inv);	
			}
			// catch any IOExceptions that occur
			catch (IOException io) 
			{
				io.printStackTrace(); // this shows if there are any errors
				System.out.println("An IO Exception occurred");
			}
			
			finally // this always runs no matter what so close the file here
			{ // close the file.
				try 
				{
					OOS.close();
				}
				catch (Exception e)
				{}
			}
		}
	}
} // end of class
