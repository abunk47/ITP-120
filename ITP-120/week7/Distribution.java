/**
 * This program reads from a text file of numbers and then provides the user with
 * a distribution of values as well as the average.
 * @author A.Bunk 7.6.2014
 */

package week7;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class Distribution 
{
	public static void main (String [] args)
	{
		// import the ArrayList
		ArrayList<Integer> num = new ArrayList<Integer>();
		num = readText();
		// make sure the list was imported correctly
		System.out.println ("Your list of #'s looks like this...\n");
		System.out.println(num);
		System.out.println("\nThe total # of #s is " + num.size());
		// run the frequency method to get the # of occurrences for each # type
		frequency(num);
		// then print out the average
		System.out.println("\nThe average value was " + average(num));
		System.out.println("\nThe minimum was " + Collections.min(num));
		System.out.println("\nThe maximum was " + Collections.max(num));
		
	}


	public static ArrayList<Integer> readText () 
	{
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		Frame f = new Frame();        
		//decide from where to read the file
		FileDialog foBox = new FileDialog(f,"Reading text file", FileDialog.LOAD);
		foBox.setVisible(true);
		//get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();	
	   	
		// create a file instance for the absolute path
		File inFile = new File(dirPath + foName);
		BufferedReader in=null;
		
		try
		{
			// create a BufferedReader to use to read in the file
			 in = new BufferedReader(new FileReader(inFile));
			 
			// read in the first entire line from the file
			String line = in.readLine();
			// set up a loop to run to add numbers to the ArrayList
			while(line!=null)
			{
				// add in the String Tokenizer and set the constraints to " "
				StringTokenizer t = new StringTokenizer(line," ");
				// set up a for loop that counts the # of tokens on a line and then loops to add in each #
				// on the line to the num List.  It then moves on to the next line when finished.
				for (int i = t.countTokens() ; i > 0; --i)
					num.add(Integer.parseInt(t.nextToken().trim()));
				line=in.readLine();
			}
		}
		
		catch (IOException io)
		{
			System.out.println("An IO Exception occurred");
			io.printStackTrace();
		}
		finally    // finally always runs no matter what so close the file here!
		{
			// close the file. Java is neurotic - it worried "but what if it is already closed?" so needs another try/catch 
			try{
			in.close();
			}
			catch (Exception e) {}   // note the {} - means "do nothing".  I wanted it closed anyway.
		}
		return num;
	}
	
	// method to print out the frequency for each number
	// I want to calculate the mode why we have this set up and make my list calculate 
	// the frequency for any numbers the user might input
	public static void frequency (ArrayList<Integer> num)
	{
		// I want to calculate the mode why we have this set up and make my list calculate the frequency for any numbers the user might input
		int mode = 0;
		int modeNumber = 0;
		// create a new arraylist to hold all the #'s we want to check the frequency of
		ArrayList <Integer> numberTracker = new ArrayList<Integer>();
		// each time a new # comes up the arrayList will run the frequency to see if the # already exists in this list
		// if not then we add it to the list 
		for (int i = 0 ; i < num.size() ; ++i)
		{
			// get the # from location i in List num
			int b = num.get(i);
			// compare i from num with list numberTracker, 
			// if numberTracker does not have that # then add that # to List numberTracker
			// we need to iterate through numberTracker and compare
			if (Collections.frequency(numberTracker, b) == 0)
				numberTracker.add(b);
			
		}
		// we need to put the List numberTracker in order from lowest to highest
		for (int out = numberTracker.size() - 1; out > 1; out--)
		{
			for (int i = 0; i < out ; i ++)
			{
				int first = numberTracker.get(i);
				int second = numberTracker.get(i + 1);
			
				if (second < first)
				{
					numberTracker.set(i, second);
					numberTracker.set(i+1, first);
				}
			}
		}
		
		// let the user know their frequency distribution is below
		System.out.println("\nThe following is the distribution of values: ");
		// set up our for loop to print out the frequency of List num 
		for (int i = 0 ; i < numberTracker.size() ; ++i)
		{
			// go through the collection to find the frequency of each # then print it to the Console
			int b = Collections.frequency(num, numberTracker.get(i));
			System.out.println(numberTracker.get(i) + ": " + b);
			// we now see if the number is higher than the current mode and if so then we set the modeNumber to the current number being checked above
			if (b > mode)
			{
				mode = b;
				modeNumber = numberTracker.get(i);
			}	
			
		}
		System.out.println("\nThe most common # was " + modeNumber);
	}

	// method to determine the average, should return a double, and inputs the List num
	public static double average (ArrayList<Integer> num)
	{
		double average = 0;
		// we need to set up a loop that will go through the list and add each # to the sum then divide by # of elements in the array
		for (int i = 0 ; i < num.size() ; ++i)
		{
			average = num.get(i) + average;
		}
		average = (double) average/ num.size();
		return average;
	}
	
	
	
	
	
	
	
	
	
}