/**
 * This class creates sales objects.  These objects describe when a customer purchases an item from the inventory.
 * These objects also populate the sales ArrayList
 */
package finalproject;

import java.text.NumberFormat;
import java.io.Serializable;


public class Sales implements Serializable {
 
	private Customer cust; // customer object that describes the customer's info
	private Day dateSold; // Day object which is the date the item was sold
	private Inventory inv; // Inventory object that describes the item
	private int numBought; // the amount purchased
	private int salesNum; // the sales number for tracking purposes
	static final double SALESTAX = .0725;  // the salestax
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	private static int nextNum = 1000; // used with the sales number above
	 
	 
	public Sales()
	{
		salesNum = nextNum;
		nextNum++;
	 
	}
	 
	public Sales(Customer c, Day date, Inventory in, int num)
	{
		cust = c;
		dateSold = date;
	  	inv = in;
	  	numBought = num;
	  	salesNum = nextNum;
	  	nextNum++;
	}
	 
	 
	public String toString()
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String s = "Sales#:" + salesNum +"  " + inv.toStringCust() + "  " + cust.toString() + " bought " + 
				numBought + " of these on " + dateSold + ".\nThe sales price was " + nf.format(inv.getSalesPrice()) + ". Sale Amount: " 
				+ nf.format(netSales()) + ". The store's net profit on this sale is " + nf.format(netProfit()) + "." ;
		return s;
	}
	
	
	public double netSales() 
	{
		// This is actually the sale amount
		double discount = 0;
		// formula to get the total
		double total = inv.getSalesPrice() * numBought;
		// if statements to figure out the discount amount
		if (cust.getType() == "Wholesale")
			discount = (double) cust.getDiscountPercent() / 100;
		if (cust.getType() == "Retail" && total >= 200 )
			discount = (double) 5 / 100;
		else
			discount = 0;
		// Subtract the discount amount from the total 
		double subTotal = (total - (total * (discount)));
		// Add in the tax.
		double netSales = subTotal * (1 + SALESTAX);
		return netSales;
	  
	}
	
	public double netProfit ()
	{
		// we can't count the tax as profit
		double netRevenue = netSales() - (netSales() * SALESTAX);
		// subtract what were paid for the items to get netProfit
		double netProfit = netRevenue - (inv.getCost() * numBought);
		return netProfit;
		
	}
	
	
	
	public Customer getCust() {
		return cust;
	}
	
	 
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	 
	public Day getDateSold() {
		return dateSold;
	}
	
	 
	public void setDateSold(Day dateSold) {
		this.dateSold = dateSold;
	}
	
	public Inventory getInv() {
		return inv;
	}
	
	 
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	
	 
	public int getNumBought() {
		return numBought;
	}
	
	 
	public void setNumBought(int numBought) {
		this.numBought = numBought;
	}
	// added for convenience in other classes
	public int getSalesNum() 
	{
		return salesNum;
	}
}