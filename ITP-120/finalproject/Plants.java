/**
 * This is abstract class that is extended in the Perennials and Trees classes.   
 */
package finalproject;

public abstract class Plants extends Inventory {

	public Plants()
	{
		super();
	}
	
	public Plants(double c, String i, int nIS, double p)
	{
		super(c, i, nIS, p);
	}
}
