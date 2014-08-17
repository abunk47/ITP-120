/**
 * This class extends the inventory class and describes Bulk Products
 * 
 */

package finalproject;

public class BulkProducts extends Inventory 
{
 
	private double weight; // weight of the product in pounds
 
	public BulkProducts()
	{
		super();
		weight = 0;
	}
 
	public BulkProducts(double c, String i, int nIS, double p, double w)
	{
		super(c, i, nIS, p);
		weight = w;
	}

	public double getWeight() {
		return weight;
	}

 	public void setWeight(double weight) {
		this.weight = weight;
	}

}

