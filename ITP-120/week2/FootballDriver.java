/* 
 * This program interacts with the Football class 
 * and provides information to the user about specific players.
 * A.Bunk 05.31.2014
 */

package week2;

public class FootballDriver 
{
	public static void main ( String [] args )
	{
		// create the RG3 object,  lol that sounds kind of odd
		FootballPlayer player1 = new FootballPlayer ("Robert Griffin III", "Redskins", 10, 4800000);
		// create the Peyton Manning object
		FootballPlayer player2 = new FootballPlayer ("Peyton Manning", "Broncos", 18, 17500000);
		// create the Aaron Rodgers objects
		FootballPlayer player3 = new FootballPlayer ("Aaron Rodgers", "Packers", 12, 12000000);
		// create the Andy Dalton object
		FootballPlayer player4 = new FootballPlayer ("Andy Dalton", "Bengals", 14, 1303550);
		
		// call the toString method for RG3
		System.out.println(player1.toString());
		// call the toString method for Peyton
		System.out.println(player2.toString());
		// call the toString method for Rodgers
		System.out.println(player3.toString());
		// call the toString method for Dalton
		System.out.println(player4.toString());
		
		// set the expectations for Dalton this year
		System.out.println ("Dalton won't make anything next year if we don't make the AFC finals!");
		
				
	}

}
