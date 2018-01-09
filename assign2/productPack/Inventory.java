package productPack;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

/**
 * The Inventory class has all of the methods 
 * manipulating the Arraylist<Product>.
 * The Arraylist<Product> holds all the the 
 * methods that manipulate the Product class. 
 * @author Weston Knuppel
 * @author Cody Chumchal
 */
public class Inventory implements Comparator<Product> 
{
	int userSKU = 0;
	String userTitle = "";
	double userPrice= 0.0;
	int userQuant = 0;
	String userProduct = "";
	int userISBN = 0;
	String userAuthor;
	int userUPC = 0;
	int userWeight = 0;
	double userShipCost = 0.0;
	
	private ArrayList<Product> ProductInv;
	
	/**
	 * Inventory()
	 * Constructor for an instance of the store inventory.
	 * Creates an ArrayList of Movie, Book and Toy class.
	 * Checks for "ProductInventory.dat" file
	 * and looks for data to fill the Arraylist
	 * which is named ProductInv.
	 */
	public Inventory()
	{
		 ProductInv = new ArrayList<Product>();
		 try 
		 {
			 FileInputStream fis = new FileInputStream("ProductInventory.dat");
			 ObjectInputStream ois = new ObjectInputStream(fis);
			 
			 ProductInv =
			 (ArrayList<Product>)ois.readObject(); // explicit cast read
			 
			 fis.close();
		 }
		 catch (FileNotFoundException e) 
		 {
			 System.out.println("Cannot find datafile.");
		 } 
		 catch (IOException e) 
		 {
			 System.out.println("Problem with file input.");
		 }
		 catch (ClassNotFoundException e) 
		 {
			 System.out.println("Class not found on input from file.");
		 }
	}
			 
	/**
	 * addProduct() is a method for a Menu option
	 * to add a Product. Asks user for what type of
	 * product they wish to add and a SKU. And once 
	 * that is given it searches the Arraylist to 
	 * see if the SKU exists. If it does then an 
	 * error message is printed. If it does not exist,
	 * the method continues asking for the appropriate
	 * information and adds it to the list.
	 * @param Scanner input - scanner passed from menu
	 */
	public void addProduct(Scanner input)
	{
		System.out.println("Enter product type:");
		userProduct = input.next();
		System.out.println("Enter Product SKU:");
		userSKU = input.nextInt();
		
		boolean dup = false;
		//check if product exists
		if(ProductInv.size() != 0)
		{
			for(int i=0; i < ProductInv.size(); i++)
			{
				if(userSKU == ProductInv.get(i).getSKU())
				{
					System.out.println("Product is a dupliate.");
					dup = true;
					break;
				}
			}
		}
		if(dup == false)
		{
			input.nextLine();
			System.out.println("Enter product title:");
			userTitle = input.nextLine();
			System.out.println("Enter the product's price:");
			userPrice = input.nextDouble();
			System.out.println("Enter the quantity of products:");
			userQuant = input.nextInt();
			
			if(userProduct.equals("B"))
			{
				System.out.println("Enter ISBN:");
				userISBN = input.nextInt();
				input.nextLine();
				
				System.out.println("Enter Author:");
				userAuthor = input.nextLine();
				
				Product item = new Book(userSKU, userQuant, userPrice, userTitle, userISBN, userAuthor);
				ProductInv.add(item);
			}
			else if(userProduct.equals("M"))
			{
				System.out.println("Enter UPC");
			    userUPC = input.nextInt();
				
				Product item = new Movie(userSKU, userQuant, userPrice, userTitle, userUPC);
				ProductInv.add(item);
			}
			else if(userProduct.equals("T"))
			{
				System.out.println("Enter weight (in oz):");
				userWeight = input.nextInt();
				
				Product item = new Toy(userSKU, userQuant, userPrice, userTitle, userWeight);
				ProductInv.add(item);
			}
			System.out.println("Product added.\n");
		}
	}
		
	/**
	 * deleteProduct() is a method for a Menu option
	 * to remove a product. It asks the user for the 
	 * SKU of the product they wish to remove. It checks
	 * for the product and if it exists then it is removed.
	 * If it does not exist, an appropriate message is
	 * printed.
	 * @param Scanner input - scanner passed from menu
	 */
	public void deleteProduct(Scanner input)
	{
		boolean found = false;
		System.out.println("Enter product SKU to be removed:");
		userSKU = input.nextInt();
		
		for(int i=0; i < ProductInv.size(); i++)
		{
			if(userSKU == ProductInv.get(i).getSKU())
			{
				ProductInv.remove(i);
				found = true;
				System.out.println("Product removed.");
			}
		}
		if(found == false)
			System.out.println("Product not found.");
	}
	
	/**
	 * ProductInfo()is a method for a Menu option
	 * to print the info of a product. It asks 
	 * the user for the SKU of the product they 
	 * wish to view. It checks for the product and 
	 * if it exists then the product's info is printed.
	 * If it does not exist, an appropriate message is
	 * printed.
	 * @param Scanner input - scanner passed from menu
	 */
	public void ProductInfo(Scanner input)
	{
		boolean found = false;
		System.out.println("Enter product SKU:");
		userSKU = input.nextInt();
		
		for(int i=0; i < ProductInv.size(); i++)
		{
			if(userSKU == ProductInv.get(i).getSKU())
			{
				ProductInv.get(i).printProduct();
				found = true;
			}
		}
		if(found == false)
			System.out.println("Product not found.");
	}
	
	/**
	 * showStoreInventoryBySKU()is a method for a Menu option
	 * to print the contents of the Arraylist by their SKU. 
	 * It prints the entire list with an appropriate format.
	 */
	public void showStoreInventoryBySKU()
	{
		Collections.sort(ProductInv, new Inventory());
		
		for(int i=0; i < ProductInv.size(); i++)
		{
			System.out.println(ProductInv.get(i).showInfo());
		}
		System.out.println();
	}
	
	/**
	 * showStoreInventoryByTitle()is a method for a Menu option
	 * to print the contents of the Arraylist by their Title. 
	 * It prints the entire list with an appropriate format.
	 */
	public void showStoreInventoryByTitle()
	{
		Collections.sort(ProductInv);
		
		for(int i=0; i < ProductInv.size(); i++)
		{
			System.out.println(ProductInv.get(i).showInfo());
		}
		System.out.println();
	}
	
	/**
	 * Compares two Product objects, item1 and item2. The return descriptor 
	 * aids in sorting the ArrayList
	 * @param item1
	 * @param item2
	 */
	public int compare(Product item1, Product item2)
	{
		if(item1.getSKU() < item2.getSKU())
		{
			return -1;
		}
		if(item1.getSKU() == item2.getSKU())
		{
			return 0;
		}
		else 
			return 1;
	}
	
	/**
	 * processSale gathers the SKU of the product desired,
	 * the quantity sold of that product, and the cost of shipping.
	 * 
	 * @param Scanner input - scanner passed from menu
	 */
	public void processSale(Scanner input)
	{
		System.out.println("Enter SKU of products sold:");
		userSKU = input.nextInt();
		System.out.println("Enter quantity of products sold:");
		userQuant = input.nextInt();
		System.out.println("Enter cost of shipping:");
		userShipCost = input.nextDouble();
		System.out.println();
		
		int index = 0;
		//find the item 		
		for (int i = 0; i < ProductInv.size(); i++)
		{
			if (userSKU == ProductInv.get(i).getSKU())
			{
				index = i;
			}
		}
		if (ProductInv.get(index).getQuantity() < userQuant || userQuant <= 0)
		{
			System.out.println("Error while processing sale.");
			System.out.println();
		}
		else
		{
			//calculate sale
			double proPrice = ProductInv.get(index).getPrice() * userQuant;
			double proCredit = ProductInv.get(index).credit() * userQuant;
			double proCommission = ProductInv.get(index).commission() * proPrice;
			double proProfit = proPrice + proCredit - (proCommission + userPrice);
			//update product quantity
			ProductInv.get(index).updateQuantity(userQuant);

			//format price and display sale
			DecimalFormat df = new DecimalFormat("$#0.00");
			System.out.print("Total Price:\t\t " + df.format(userPrice));
			System.out.print("\nTotal Shipping Credit:\t " + df.format(proCredit));
			System.out.print("\nTotal Commission:\t " + df.format(proCommission));
			System.out.print("\nTotal Profit:\t\t " + df.format(proProfit) + "\n");
			System.out.println();
		}
	}
	
	
	/**
	 * writeToFile() takes the Arraylist and 
	 * its contents at the moment this method 
	 * is called and saves it to "ProductInventory.dat".
	 */
	public void writeToFile()
	{
		 try 
		 {
			 FileOutputStream fos = new FileOutputStream("ProductInventory.dat");
			 ObjectOutputStream oos = new ObjectOutputStream(fos);
			 oos.writeObject(ProductInv); //ArrayList & contents are serializable
			 fos.close();
		 } 
		 catch (IOException e) 
		 {
			 System.out.println("Problem with file output");
		 }
	}
}
