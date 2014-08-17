/*
 * This class provides different fields related to football players,
 * specifically it provides accessible information on player name
 * jersey number, team they play for, and annual salary.
 * A.Bunk 5.31.2014
 */

package week2;
// Decimal Format included so as to format the Salary field in toString
import java.text.DecimalFormat;

public class FootballPlayer {
	
	private String 	name; // name field
	private String 	teamName; // team name field
	private int 	jerseyNumber; // jersey # field
	private double 	salary; // yearly salary field
	
	DecimalFormat df = new DecimalFormat ("0.00");
	
	// default constructor or no argument constructor
	public FootballPlayer ()
	{
	}
	
	// a full constructor with parameters for all four instance variables
	public FootballPlayer (String n, String t, int j, double s)
	{
		name = n;
		teamName = t;
		jerseyNumber = j;
		salary = s;
	}
	
	// a constructor with only two parameters
	public FootballPlayer (String n, String t)
	{
		name = n;
		teamName = t;
		jerseyNumber = 0;
		salary = 0;
	}
	
	// toString method that is accessible from other classes
	public String toString()
	{
		return name + " plays for the " + teamName + " and wears the # " 
			   + jerseyNumber + " jersey!\n" + "He is paid $" + df.format(salary)
			   + " a year!";
		
		
	}
	
	
	
	// setters and getters are listed below for each field...
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	
}
