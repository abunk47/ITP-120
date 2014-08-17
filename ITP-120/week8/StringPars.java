/**
 * This program takes a User's input from the keyboard and outputs the list of words in the sentence alphabetically.
 * @author A.Bunk 7.11.2014
 */

package week8;

import java.util.*;

public class StringPars
{
	public static void main (String [] args)
	{
		System.out.println ("Were going to enter a sentence into alphabetical order.");
		String [] splitItUp = sArray();
		// Then you will want to run the methods to print out the string in alphabetical order with and without duplicates
		toList(splitItUp);
		toSet(splitItUp);
    
		
	}
	
	public static String [] sArray ()
	{
		// include a scanner that prompts the user to input a line of text.
		// Then you need to cut off any punctuation off the end and reprint to check it worked
		// \\W is a Regex that allows us to strip the punctuation away and replace it with whitespaces
		Scanner scan = new Scanner(System.in);
		System.out.println ("Please input a sentence:");
		String in = scan.nextLine();
		System.out.println ("Does case matter? If it does, capitalized words will come first.");
		System.out.println ("Please enter true or false");
		boolean lowerCase = scan.nextBoolean();
		if (lowerCase == false)
		{
			in = in.toLowerCase();
		}
		String stripped = in.replaceAll("\\W", " ");
		// we need to take into account the fact we may have double spaces so we will reduce those to one
		String strip = stripped.replaceAll("  ", " ");
		// trim the String
		strip.trim();
		// now we need to split the String
		String [] splitItUp = strip.split(" ");
		return splitItUp;
		
	}
  
	public static void toList (String [] s)
	{
		// Set up an ArrayList and then use Collections to sort the list Alphabetically
		// Print out the result. (You may need to set up a loop to do this)
		List <String> split = new ArrayList <String>(Arrays.asList(s));
		Collections.sort(split);
		System.out.println("\nHere is the list of words in alphabetical order:");
		for (String s1 : split)
			System.out.print(s1 + " ");
	}
  
	public static void toSet (String [] s)
	{
		// Then we will need to transform the ArrayList to a set (as it will delete the duplicates)
		// Then we will print out the result again. (You may need to set up a loop to do this)
		// we can also turn an arrayList into a Treeset by SortedSet< String > tree = new TreeSet< String >( list );
		Set <String> set = new TreeSet<String>(Arrays.asList(s));
		Iterator it = set.iterator();
		System.out.println("\nHere is the list of words in alphabetical order without duplicates: ");
		while(it.hasNext())
			  System.out.print(it.next() + " ");
		
	}
}
