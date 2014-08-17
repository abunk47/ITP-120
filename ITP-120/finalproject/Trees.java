/**
 * Extends Plants which extends the Inventory class.  This class is
 */
package finalproject;


public class Trees extends Plants  
{
	 
	private boolean evergreen;
	 
	 
	public Trees()
	{
		super();
	}
	 
	public Trees(double c, String i, int nIS, double p, boolean ever)
	{
		  super(c, i, nIS, p);
		  evergreen = ever;
	}
	
	 
	public boolean isEvergreen() {
		return evergreen;
	}
	
	 
	public void setEvergreen(boolean evergreen) {
		this.evergreen = evergreen;
	}
	
}