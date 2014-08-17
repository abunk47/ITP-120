/**
 * This is the base class for all the different objects the Nursery sells, including plants, trees, and bulk products.  
 */
package finalproject;

import java.text.NumberFormat;
import java.io.Serializable;

public abstract class Inventory implements Serializable 
{
 
 
	protected double cost; // the price the Nursery pays for this item.
	protected int invNum; // the Item # for this item
	protected String itemName; // the name of the item
	protected int numInStock; // the amount that is in stock
	protected double salesPrice; // the price the Nursery sells the item for
		  
	protected static int nextNum = 1000;
		 
	private NumberFormat currency = NumberFormat.getCurrencyInstance();
	 
	public Inventory(double c, String i, int nIS, double p)
	{
		cost = c;
		itemName = i;
		numInStock = nIS;
		salesPrice = p;
 
		invNum = nextNum;
		nextNum++;
	}
 
 
	public Inventory()
	{
		invNum = nextNum;
		nextNum++;
	}
 
	public String toString()
	{
		double totalValue = cost * numInStock;
		 
		return "There are " + numInStock + " of " + itemName + " (Item Number:  " + invNum 
				+ ") in stock with a cost of " + currency.format(cost) + " each.  The sales price of the item is " + currency.format(salesPrice) +". The total value in inventory is "
				+ currency.format(totalValue) + "."; 
	}
 
	public String toStringCust() 
	{
		return  itemName + " (Item Number:  " + invNum + ") which cost " +
				currency.format(cost) + " each. ";
 
	}


 
	public double getCost() {
		return cost;
	}

 
	public void setCost(double cost) {
		this.cost = cost;
	}

 
	public int getInvNum() {
		return invNum;
	}

 
	public void setInvNum(int invNum) {
		this.invNum = invNum;
	}

 
	public String getItemName() {
		return itemName;
	}

 
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

 
	public int getNumInStock() {
	return numInStock;
	}

 
	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

 
	public double getSalesPrice() {
		return salesPrice;
	}

 
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

}
