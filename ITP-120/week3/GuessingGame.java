/*
 *  This program generates a random # and then asks the user to guess the #
 *  the program continues to run until the person guesses the correct #.  
 *  A.Bunk 6.8.2014
 */

package week3;

import java.util.Scanner;

public class GuessingGame 
{
	public static void main ( String [] args)
	{
		// initialize the new scanner object
		Scanner scan = new Scanner (System.in);
		
		int random;  // we need an int called random for the random # game
		int guess; // we need an int called guess for user to guess what the random # is
		int guesses = 0; // tracks the # of rounds it took to guess
		String playAgain = "yes"; // set up a string to play the game again and initialize to "yes"

		
		// this loop will be set up to end when the user says "yes" to playing again
		while (playAgain.equalsIgnoreCase("yes"))
		{	
			// generate a random # each time the game runs
			random = (int) (Math.random()*20) + 1;
			
			// reset guess so they can play again
			guess = 0;
			
			// reset guesses back to 0;
			guesses = 0;
			
			// set up a while loop with the game inside of it
			// so that as long as the random # and guess do not equal each other then the loop will run
			while (guess != random)
			{
				// track the # of guesses it takes to play the game.  
				guesses++;
			
				// ask the user to input a guess as to what random # is
				System.out.println ("Please guess the number (between 1-20): ");
				guess = scan.nextInt();
			
				// if the guess is more then 20 question the user  
				if (guess > 20)
					System.out.println ("That's above 20 stupid, please try again!");
				// if guess is below 1 let them know
				else if (guess < 1)
					System.out.println("That guess is less than 1! Try again, this time guess a # between 1 and 20!");
				// if the guess is too high then have console display "Your guess was high, guess again". 
				else if (guess > random)
					System.out.println ("That's too high! Guess again!");
				// if the guess was too low then have the console display "Your guess was low, guess again."
				else if (guess < random)
					System.out.println ("Thats too low! Guess again!"); 
				// if the guess is correct tell the user they are correct and let them know how many guesses it took
				else if (guess == random)
					System.out.println ("Great guess! It only took you " + guesses + " guesses to guess the correct answer!");
			
			} // end first loop
			
			// to avoid the scanner issue
			scan.nextLine();
			
			// then ask them if they want to play again? If they say yes then we play again if not the loop ends
			System.out.println("Great job winning the game! Would you like to play again? (Please enter yes or no) ");
			playAgain = scan.nextLine();
			
		} // end second loop
		// set up a console statement that thanks the user for playing which will also allow us to know if the second loop was exited properly
		System.out.println("Thanks for playing! Have a wonderful day!");
		
		scan.close();
	} // end of main method
	
		
} // end of the class
