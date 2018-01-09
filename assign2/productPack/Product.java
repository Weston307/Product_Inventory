package productPack;

import java.text.*;
import java.io.*;

/**
 * The Product class sets all of the items such as
 * SKU, title, price, quantity and sets all
 * of these variables to either empty or
 * zero. It also holds the methods that the
 * Inventory class accesses to manipulate
 * the Arraylist. 
 * @author Weston Knuppel
 * @author Cody Chumchal
 */
public abstract class Product implements Serializable, Comparable<Product>
{
	//Fields
	private int SKU;
	private String title;
	private double price;
	private int quantity; 
	
	/**
	 * Constructor Product() sets all values such
	 * as SKU, title, price, and quantity
	 * to either empty or zero.
	 */
	public Product()
	{
		SKU = 0;
		title = "";
		price = 0.0;
		quantity = 0;
	}
	
	/**
	 * Secondary Constructor Product() initializes
	 * local variables to the parameters passed. 
	 * @param inSKU is the SKU of the Product
	 * @param inTitle is the title of the Product
	 * @param inPrice is the price of the Product
	 * @param inQuantity is the quantity of the Product
	 */
	public Product(int inSKU, String inTitle, double inPrice, int inQuantity)
	{
		SKU = inSKU;
		title = inTitle;
		price = inPrice;
		quantity = inQuantity;
	}
	
	/**
	 * getSKU() gets the SKU of the object
	 * this function is called on in the 
	 * Inventory class.
	 * @return returns the SKU of the invoked
	 * object accessed in the Inventory
	 * class.
	 */
	public int getSKU()
	{
		return SKU;
	}
	
	/**
	 * getTitle() gets the title of the object
	 * this function is called on in the Inventory
	 * class.
	 * @return returns the title of the invoked
	 * object class accessed in the Inventory class.
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * getPrice() gets the price of the object
	 * this function is called on in the Inventory class.
	 * @return returns the price of the invoked object
	 * class accessed in the Inventory class.
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * getQuantity() gets the Quantity of the object
	 * this function is called on in the Inventory class.
	 * @return returns the Quantity of the invoked object
	 * class accessed in the Inventory class.
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	/**
	 * updateQuantity(int inQuant) sets the quantity
	 * to the newly updated quantity after sale is
	 * processed.
	 * @param inQuant
	 */
	public void updateQuantity(int inQuant)
	{
		quantity = quantity - inQuant;
	}
	
	/**
	 * compareTo(Product newProduct) compares the invoking
	 * object to the object that is passed.
	 * @param newProduct
	 * @return either -1 if the passed object is less, 0
	 * if the passed object is equal, and 1 if the passed
	 * object is greater than the invoking object.
	 */
	public int compareTo(Product newProduct)
	{
		return this.getTitle().compareTo(newProduct.getTitle());
	}
	
	/**
	 * showInfo() prints an appropriate format
	 * for the info of a desired product. 
	 */
	public String showInfo()
	{
		DecimalFormat df = new DecimalFormat("$#0.00");
		return String.format("%5s %5d %8s %-20s", SKU, quantity, df.format(price), title);
	}
	
	/**
	 * prints product by data type
	 */
	public void printProduct()
	{
		System.out.println("SKU: " + SKU);
		System.out.println("Title: " + title);
		System.out.printf("Price: $%.2f\n",price);
		System.out.println("Quantity: " + quantity);
	}
	
	/**
	 * Abstract methods that are to be defined in sub classes of Product
	 */
	public abstract double credit();
	public abstract double commission();
}
