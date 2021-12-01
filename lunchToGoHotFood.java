package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

import Arrays.Ex1;
import Switch.TEST;
import general.*;

public class lunchToGoHotFood {

	public static void main(String[] args) 
	{
		Scanner key = new Scanner(System.in);

		int option = 0;

		String[] items = { "Burger", "Lasagne", "Stew", "Veg Soup", "Chicken Soup", "Sausages", "Sausage Rolls","Vol au vent", "Chicken curry"};// List of the items used for lunches and hot food

		String[] sides = { "Beans", "Crusty Roll", "Rice", "Peas", "Wedges", "Curly Fries", "Peppered Sauce Dip","Curry Dip", "Gravy Dip"}; // List of the sides available during lunch which are also under the hot food section

		String[] meal = { "+1 side £5.00", "+1 side £4.50", "+ Crusty roll £2.75", "+ Crusty roll £2.75", "*Nothing available*", "*Nothing available*", "*Nothing available*", "*Nothing available*","(+1 side £3.50)\n\t\t\t\t\t  (+2 sides £4.00)"};
		
		double[] itemPrices = { 4.50, 4.00, 2.50, 2.50, 2.50, 0.80, 0.80, 1.00, 3.00 };//Prices for items
		
		double[] sidePrices = { 0.60, 0.40, 1.00, 0.60, 1.20, 1.20, 0.60, 0.60, 0.60 };//Prices for sides

		lunchToGoHotFood.home();
		option = lunchToGoHotFood.printOption(option);

		switch (option)
		{
		/*case 1:
	       	System.out.println("");
	        break;
		case 2:
	       	System.out.println("");
	        break;*/
		case 3:
			option = 0;
			System.out.printf("\n%-20s|%-20s|%-20s", "HOT FOOD", "PRICE", "DEALS");
			System.out.print("\n----------------------------------------------------------------");
			for (int i = 0; i < items.length; i++) 
			{
				System.out.printf("\n\n%-1s)%-18s|£%-19.2f|%-20s", i+1, items[i], itemPrices[i], meal[i]);
				//System.out.printf("\n----------------------------------------------");
			}
			option = lunchToGoHotFood.printOption(option);
			lunchToGoHotFood.itemPrice(option);
	        break;
		/*case 4:
	       	System.out.println("");
	        break;
	    default:
	       	System.out.println("Invalid! You have not chose an option between 1-4");
	        break;*/  
		}
		
	}
	static double itemPrice(int foodItem) {

		double itemPrice = 0.0;

		char yesNo = ' ';
		
		switch (foodItem) 
		{ 
		case 1:
			itemPrice = 4.50;
			
			System.out.printf("\nYou've ordered a burger (£%.2f)" ,itemPrice);
			
			yesNo = MyVal.validYN("\n\nMake it a meal?");
				if (yesNo == 'N')
				{
					System.out.printf("\nAdded to basket");
				}
				else if (yesNo == 'Y')
				{
					itemPrice = 5.00;
				}
				break;
		case 2:
			itemPrice = 4.00;
			
			System.out.printf("\nYou've ordered Lasagne (£%.2f)" ,itemPrice);
			
			MyVal.validYN("\n\nMake it a meal? (+1 side £4.50)");
			
			break;
		case 3: 
			
			itemPrice = 2.50;
			
			System.out.printf("\nYou've ordered a Stew (£%.2f)" ,itemPrice);
			
			MyVal.validYN("\n\nMake it a meal? (+Crusty roll £2.75)");
			
			break;
		case 4:
			itemPrice = 2.50;
			
			System.out.printf("\nYou've ordered a Vegetable Soup (£%.2f)" ,itemPrice);
			
			MyVal.validYN("\n\nMake it a meal? (+Crusty roll £2.75)");

			break;
		case 5:
			itemPrice = 2.50;
			System.out.printf("\nYou've ordered a Chicken Soup (£%.2f)" ,itemPrice);
			MyVal.validYN("\n\nMake it a meal? (+Crusty roll £2.75)");
		
			break;
		case 6:
			itemPrice = 0.80;
			System.out.printf("\nYou've ordered Sausages (£%.2f)" ,itemPrice);
			
			break;
		case 7:
			itemPrice = 0.80;
			System.out.printf("\nYou've ordered Sausage rolls (£%.2f)" ,itemPrice);
			
			break;
		case 8:
			itemPrice = 1.00;
			System.out.printf("\nYou've ordered Vol au vent (£%.2f)" ,itemPrice);
			
			break;
		case 9:
			int option = 0;
			itemPrice = 3.00;
			System.out.printf("\nYou've ordered a Chicken Curry (£%.2f)" ,itemPrice);
			MyVal.validYN("\n\nMake it a meal?  \n(+1 side £3.50) \n(+2 sides £4.00)");
			lunchToGoHotFood.printOption(option);
			if (option == 1)
			{
				itemPrice = 3.50;
				System.out.printf("\nYou've ordered a Chicken Curry meal with 1 side (£%.2f)" ,itemPrice);
			}
			else if (option == 2)
			{
				itemPrice = 4.00;
				System.out.printf("\nYou've ordered a Chicken Curry meal with 2 side (£%.2f)" ,itemPrice);
			}
			break;
		}
		return itemPrice;
	}

	static void home() {
		lunchToGoHotFood.printHeader();
		lunchToGoHotFood.mainMenu();
	}

	static void mainMenu() {

		Scanner key = new Scanner(System.in);
		System.out.printf("\n(1)%s \n\n(2)%s \n\n(3)%s \n\n(4)%s", "Sandwiches", "Salads", "Hot food", "Checkout");
	}

	public static int printOption(int choice)
	{
		int option = 0;
		Scanner key = new Scanner(System.in); 
		System.out.println("\n\nPlease choose an option above");
		option = key.nextInt();
		return option;
	}
	
	static void printHeader() {
		System.out.println("+-----------------------------------+");
		System.out.println("|            Welcome to             |");
		System.out.println("|           Lunch and go!           |");
		System.out.println("+-----------------------------------+");
	}

	public static double quantity() {
		Scanner key = new Scanner(System.in);
		System.out.println("Enter quantity");
		double quantity = key.nextDouble();
		subTotal(quantity, itemPrice(0));
		return quantity;
	}

	public static double subTotal(double quantity, double itemPrice) {
		double runningTotal = 0;
		double subTotal = quantity * itemPrice;
		System.out.println("Subtotal: " + subTotal);
		runningTotal += subTotal;
		return subTotal;
	}

}
