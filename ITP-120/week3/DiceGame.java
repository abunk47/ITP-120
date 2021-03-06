/*
 * This dice game will go through and have random dice rolls for the 
 * PC and the User and will track the wins and ties for each.
 * A.Bunk 6.6.2014
 */

package week3;

public class DiceGame 
{
	public static void main (String [] args)
	{
		
		int num; // set up the total int value to count iterations of the for loop
		int cpuWins = 0; // set up the int value to count PC's wins
		int humWins = 0; // set up the int value to count user's wins
		int ties = 0; // set up the int value to count ties
		
		// Explain to the user the final battle for humanity!
		System.out.println ("The final battle for human kind involves 100 random dice rolls between the humans and the CPUs!\n" 
							+ "The fate of humanity hangs in the balance! \nIf humans have more wins they will survive and CPUs will be wiped out." 
							+ "\nIf the CPUs have more wins the" + " human race will be wiped out. \nIf there is a tie in the wins then the world will remain as it is.\n");
		
		// set up a for loop that runs a 100 times, each iteration should print out a line showing
		// the PC's and user's roll, it should then declare a winner for each roll or a tie
		for (num = 1 ; num <= 100 ; num++)
		{	
			int hum = (int) (Math.random()*6) +1; // set up the user dice roll int var here so as to have random rolls each time
			int cpu = (int) (Math.random()*6) +1; // set up the PC's dice roll int var here so as to have random rolls each time
			
			System.out.println ("\nRoll # " + num + ". The Human's dice roll is " + hum + ". The CPU's dice roll is " + cpu + " .");
			
			// set up three if statements. One if statement should 
			// count when the PC wins, the second should count if user wins
			// the third should count when there is a tie, after each if statement
			// it should tally the # of wins or ties 
			
			if (cpu > hum)
			{
				System.out.println("CPU Victory!");
				cpuWins++;
			}
			else if (cpu < hum)
			{
				System.out.println("Human Victory!");
				humWins++;
			}
			else if (cpu == hum)
			{
				System.out.println("Tie!");
				ties++;
			}
			
		} // end of for loop
		
		// Set up three if statements to declare who won or if there was a tie.
		if (humWins > cpuWins)
		{
			System.out.println("\nHumanity is the Grand Winner and all CPUs will be destroyed! Hail the Dice Roller!");
		}
		else if (cpuWins > humWins)
		{
			System.out.println("\nThe CPU's are the Grand Winners! The end of humanity is here!");
		}
		else if (cpuWins == humWins)
		{
			System.out.println("\nNo clear winner, all shall stay as it is and the eternal battle between humanity and CPUs shall continue!");
		}

		//  display the total # of wins and ties
		System.out.println("\nThe final battle resulted in " + humWins + " Human wins, " + cpuWins + " CPU wins,"
							+ " and " + ties + " ties.");		
		
	} // end main method
} // end class DiceGame
