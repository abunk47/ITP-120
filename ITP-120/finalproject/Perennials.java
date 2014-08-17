/**
 * The Perennials class describes flower objects and extends the plants class which extends the inventory class.  
 * This is a concrete class and objects of this class will be stored in the Inventory ArrayList.
 */
package finalproject;


public class Perennials extends Plants 
{
	 
	 
	private String flowerColor; // color of the flower
	 
	 
	public Perennials()
	{
		super();
	}
	 
	public Perennials(double c, String i, int nIS, double p, String color)
	{
		super(c, i, nIS, p);
		flowerColor = color;
	}
	
	 
	public String getFlowerColor() {
		return flowerColor;
	}
	
	 
	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}

}