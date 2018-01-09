package productPack;

import java.math.*;
/**
 * The Toy class extends the abstract class Product
 * @author Weston Knuppel
 * @author Cody Chumchal
 */
public class Toy extends Product 
{
	//private fields
	private int toyWeight;
	private double toyCredit = 4.99; //$4.99
	private double toyCommission = .15; //15%
	/**
	 * Toy constructor initializes variables
	 * @param newSku sku of product input from user, stored in super
	 * @param newQuantity quantity of product input from user, stored in super
	 * @param newPrice price of product input from user, stored in super
	 * @param newTitle title of product input from user, stored in super
	 * @param newToyWeight weight of product input from user, unique to this type
	 */
	public Toy(int toySku, int toyQuant, double toyPrice, String toyTitle, int weight)
	{
		super(toySku, toyTitle, toyPrice, toyQuant);
		toyWeight = weight;
	}

	/**
	 * printProduct() calls the super to print, then adds weight to the output
	 */
	public void printProduct()
	{
		super.printProduct();
		System.out.println("Weight: " + toyWeight);
	}
	/**
	 * output the item type and the information from the super class
	 */
	public String showInfo()
	{
		return String.format("%5s %s", "Toy", super.showInfo());
	}

	/**
	 * credit()
	 * @returns the shipping credit based on the toy weight for sale processing
	 */
	public double credit()
	{
		double pound = 16.0; //1 pound = 16oz
		double extra = .50;
		return (toyCredit + extra *((int)Math.ceil(toyWeight/pound)));
	}
    /**
     * commission() 
     * @returns the toy commission for sale processing
     */
	public double commission()
	{
		return toyCommission;
	}
}