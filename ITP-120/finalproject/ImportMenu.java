/**
 * This class allows someone to import byte files of data on customer. inventory, and sales information.
 * The information is organized into three methods.  A user can choose which one they want to use.
 * 
 * @author A.Bunk 7.13.2014
 */

package finalproject;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ImportMenu implements Serializable 
{
	
	/**
	 * This method will allow the user to import a customer file that will add the info to an ArrayList
	 * of the Customer class. 
	 * @return  ArrayList <Customer>
	 */
	public ArrayList<Customer> readSerializableCust()
	{
		// create the arraylist we will return
		ArrayList<Customer> cust = new ArrayList<Customer>();
		// create a window to hold the dialog box
		Frame f = new Frame();  
	    //decide from where to read the file
	    FileDialog foBox = new FileDialog(f,"Reading serialized file", FileDialog.LOAD);
	    foBox.setVisible(true);
	    //get the absolute path to the file
	    String foName = foBox.getFile();
	    String dirPath = foBox.getDirectory();
	    File inFile = new File(dirPath + foName);
	 
	    ObjectInputStream OIS = null;
 
	    try
	    {
	    	FileInputStream IS = new FileInputStream(inFile); // create a file input stream for the file
	    	OIS = new ObjectInputStream(IS); // create the object input stream
	    	cust = (ArrayList<Customer>) OIS.readObject(); // note that you can read in the entire object (the array list) at once
	    }
	    catch (IOException io)
	    {
	    	io.printStackTrace();   // great for debugging!
	    	System.out.println("An IO Exception occurred");
	    }
	    // note that you can also have a class not found exception.
	    catch (ClassNotFoundException cnf)
	    {
	    	cnf.printStackTrace();    // great for debugging!
	    	System.out.println("An IO Exception occurred");
	    }
	    finally    // finally always runs no matter what so close the file here!
	    {
	    	// close the file. Java is neurotic - it worried "but what if it is already closed?" so needs another try/catch 
	    	try
	    	{
	    		OIS.close();
	    	}
	    	catch (Exception e) {}   // note the {} - means "do nothing".  I wanted it closed anyway.
	    }
	    return cust;
	}
	/**
	 * This method will allow the user to import a sales file that will add the info to an ArrayList
	 * of the Sales class. 
	 * @return  ArrayList <Sales>
	 */
	public ArrayList<Sales> readSerializableSales()
	{
	    // create the arraylist we will return
	    ArrayList<Sales> sales = new ArrayList<Sales>();
	    // create a window to hold the dialog box
	    Frame f = new Frame();  
	    //decide from where to read the file
	    FileDialog foBox = new FileDialog(f,"Reading serialized file", FileDialog.LOAD);
	    foBox.setVisible(true);
	    //get the absolute path to the file
	    String foName = foBox.getFile();
	    String dirPath = foBox.getDirectory();
	    File inFile = new File(dirPath + foName);
	 
	    ObjectInputStream OIS = null;
 
	    try
	    {
	      FileInputStream IS = new FileInputStream(inFile); // create a file input stream for the file
	      OIS = new ObjectInputStream(IS); // create the object input stream
	      sales = (ArrayList<Sales>) OIS.readObject(); // note that you can read in the entire object (the array list) at once
	    }
	    catch (IOException io)
	    {
	      io.printStackTrace();   // great for debugging!
	      System.out.println("An IO Exception occurred");
	    }
	    // note that you can also have a class not found exception.
	    catch (ClassNotFoundException cnf)
	    {
	      cnf.printStackTrace();    // great for debugging!
	      System.out.println("An IO Exception occurred");
	    }
	    finally    // finally always runs no matter what so close the file here!
	    {
	    	// close the file. Java is neurotic - it worried "but what if it is already closed?" so needs another try/catch 
	    	try{
	    		OIS.close();
	    	}
	    	catch (Exception e) {}   // note the {} - means "do nothing".  I wanted it closed anyway.
	    }
	    return sales;
	}
	/**
	 * This method will allow the user to import an inventory file that will add the info to an ArrayList
	 * of the Inventory class. 
	 * @return  ArrayList <Inventory>
	 */
	public ArrayList<Inventory> readSerializableInv()
	{
	    // create the arraylist we will return
	    ArrayList<Inventory> inv = new ArrayList<Inventory>();
	    // create a window to hold the dialog box
	    Frame f = new Frame();  
	    //decide from where to read the file
	    FileDialog foBox = new FileDialog(f,"Reading serialized file", FileDialog.LOAD);
	    foBox.setVisible(true);
	    //get the absolute path to the file
	    String foName = foBox.getFile();
	    String dirPath = foBox.getDirectory();
	    File inFile = new File(dirPath + foName);
	 
	    ObjectInputStream OIS = null;
	 
	    try
	    {
	    	FileInputStream IS = new FileInputStream(inFile); // create a file input stream for the file
	    	OIS = new ObjectInputStream(IS); // create the object input stream
	    	inv = (ArrayList<Inventory>) OIS.readObject(); // note that you can read in the entire object (the array list) at once
	    }
	    catch (IOException io)
	    {
	    	io.printStackTrace();   // great for debugging!
	    	System.out.println("An IO Exception occurred");
	    }
	    // note that you can also have a class not found exception.
	    catch (ClassNotFoundException cnf)
	    {
	    	cnf.printStackTrace();    // great for debugging!
	    	System.out.println("An IO Exception occurred");
	    }
	    finally    // finally always runs no matter what so close the file here!
	    {
	    	// close the file. Java is neurotic - it worried "but what if it is already closed?" so needs another try/catch 
	    	try
	    	{
	    		OIS.close();
	    	}
	    	catch (Exception e) {}   // note the {} - means "do nothing".  I wanted it closed anyway.
	    }
	    return inv;
	}
} // end of class