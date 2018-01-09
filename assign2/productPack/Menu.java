package productPack;

import java.util.Scanner;

/**
 * The Menu class has all the menu options for the user.
 * It accesses and utilizes the Inventory, Product, Movie, Book, and Toy classes.
 * Menu holds the main.
 * @author Weston Knuppel
 * @author Cody Chumchal
 */
public class Menu
{
	/**
	 * menuDisplay() holds the menu and prints it to the user.
	 * Options include; Add a product, Remove a product, search for product,
	 * display inventory by SKU, display inventory by title, process a sale, and quit.
	 */
	public static void menuDisplay()
	{
	   System.out.println("======================================================");
	   System.out.println("Product Inventory Menu");
	   System.out.println("");
       System.out.println("1) Add a product to the inventory");
       System.out.println("2) Remove a product from the inventory (by the SKU)");
       System.out.println("3) Search for a product (by the SKU)");
       System.out.println("4) Display the inventory (by the SKU)");
       System.out.println("5) Display the inventory (by the title)");
       System.out.println("6) Process a sale");
       System.out.println("7) Quit");
       System.out.println("======================================================");
	}

	/**
	 * The main driver uses the Inventory to execute tasks
	 * @param args are used for command line arguments
	 */
	public static void main(String[] args)
	{
	   Scanner sc = new Scanner(System.in);
	   int choice;
	   //Create an instance of the store inventory
	   Inventory ProductInv = new Inventory();

	   do
	   {
		  menuDisplay();
          System.out.println("Please enter your choice: ");
		  choice = sc.nextInt();

		  //checks validity of input
		  while((choice > 7) || (choice < 1))
		  {
             System.out.println("Error! Input not 1,2,3,4,5,6 or 7.");
             menuDisplay();
   		     choice = sc.nextInt();
		  }
	      switch(choice)
	      {
	         case 1: ProductInv.addProduct(sc);
	                 break;//Add a product to the inventory (prompt user for input values in this order: sku,
	    	               //title, price, quantity).
	         case 2: ProductInv.deleteProduct(sc);
	        	     break;//Remove a product from the inventory (by sku).
	         case 3: ProductInv.ProductInfo(sc);
	        	     break;//Display the information for a product (given the sku).
	         case 4: ProductInv.showStoreInventoryBySKU();
	        	     break;//Display the inventory (by sku).
	         case 5: ProductInv.showStoreInventoryByTitle();
	        	 	 break;//Display the inventory (by title)
	         case 6: ProductInv.processSale(sc);
	        	 	 break;//Process a sale and display the sale
	         case 7:
	        	     break;//Quit
	      }
	    } while(choice != 7);

	   ProductInv.writeToFile();
	   sc.close();
	}
}
