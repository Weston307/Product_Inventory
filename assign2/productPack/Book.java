package productPack;

/**
 * The Book class extends the abstract Product class
 * @author Weston Knuppel
 * @author Cody Chumchal
 */
public class Book extends Product 
{
	//private fields
	private int ISBN;
	private String authorName = "";
	private double bookCredit = 3.99;		//$3.99
	private double bookCommission = .15;	//15%	
	
	/**
	 * Book constructor initializes variables
	 * @param bookSku
	 * @param bookQuant
	 * @param bookPrice
	 * @param bookTitle
	 * @param bookISBN
	 * @param bookAuthor
	 */
	public Book (int bookSku, int bookQuant, double bookPrice, String bookTitle, int bookISBN, String bookAuthor)
	{
		super(bookSku, bookTitle, bookPrice, bookQuant);
		ISBN = bookISBN;
		authorName = bookAuthor;
	}
	
	/**
	 * printProduct calls the super class to print, then prints the ISBN and Author
	 */
	public void printProduct()
	{
		super.printProduct();
		System.out.println("ISBN: " + ISBN);
		System.out.println("Author: " + authorName);
	}
	
	/**
	 * output the item type and the information from the super class
	 */
	public String showInfo()
	{
		return String.format("%5s %s", "Book", super.showInfo());
	}

	/**
	 * credit() 
	 * @returns the book credit for sale processing
	 */
	public double credit()
	{
		return bookCredit;
	}
	
	/**
	 * commission()
	 * @returns the book commission for sale processing
	 */
	public double commission()
	{
		return bookCommission;
	}
}

