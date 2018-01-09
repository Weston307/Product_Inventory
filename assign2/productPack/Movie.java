package productPack;

/**
 * Movie class that extends the absract Product super class
 * @author Weston Knuppel
 * @author Cody Chumchal
 */
public class Movie extends Product 
{
	//private fields
	private int UPC;
	private double movieCredit = 2.98;		//$2.98
	private double movieCommission = .12;	//12%
	/**
	 * Movie constructor initializes variables
	 * @param movieSku sku of product input from user
	 * @param movieQuant quantity of product input from user
	 * @param moviePrice price of product input from user
	 * @param movieTitle title of product input from user
	 * @param movieUPC upc of product input from user.
	 */
	public Movie(int movieSku, int movieQuant, double moviePrice, String movieTitle, int movieUPC)
	{
		super(movieSku, movieTitle, moviePrice, movieQuant);
		UPC = movieUPC;
	}


	/**
	 * printProduct() calls the super class to print, and then prints the UPC.
	 */
	public void printProduct()
	{
		super.printProduct();
		System.out.println("UPC: " + UPC);
	}
	/**
	 * output the item type and the information from the super class
	 */
	public String showInfo()
	{
		return String.format("%5s %s", "Movie", super.showInfo());
	}

	/**
	 * credit() 
	 * @returns the movie credit for sale processing
	 */
	public double credit()
	{
		return movieCredit;
	}
	/**
	 * commission()
	 * @returns the movie commission for sale processing	
	 */
	public double commission()
	{
		return movieCommission;
	}
}
