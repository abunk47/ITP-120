/**
 * The Customer class is the base class for a Customer type object. 
 * 
 */

package finalproject;

import java.io.Serializable;


public class Customer implements Serializable 
{
 
 
	private int custNum; // the id # for the customer
	private int discountPercent; // the discount the customer receives
	private String first; // first name
	private String last; // last name
	private String type; // whether retail or wholesale
 
	public static int nextNum = 100;
 
 
	public Customer()
	{
		custNum = nextNum;
		nextNum++;
	}
 
 
	public Customer(String l, String f, String t, int percent)
	{
		last = l;
		first = f;
		type = t;
		discountPercent = percent;
		custNum = nextNum;
		nextNum++;
	}
 
 
	public String toString()
	{
		double discountDecimal = discountPercent / 100.00;
 
		return last + ", " + first + " (#" + custNum + "/" + type + "," +" Discount: "  + discountDecimal + ")"; 
	}
 
	public int getCustNum() {
		return custNum;
	}

 
	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}

 
	public int getDiscountPercent() {
		return discountPercent;
	}

 
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

 
	public String getFirst() {
		return first;
	}

 
	public void setFirst(String first) {
		this.first = first;
	}

 
	public String getLast() {
		return last;
	}

 
	public void setLast(String last) {
		this.last = last;
	}

 
	public String getType() {
		return type;
	}

 
	public void setType(String type) {
		this.type = type;
	}

}