package Assignment;

import java.util.ArrayList;
import java.util.Scanner;
import general.*;

public class lunchToGoHotFood {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);

		int option = 0;

		String[] items = { "Burger", "Lasagne", "Stew", "Veg Soup", "Chicken Soup", "Sausages", "Sausage Rolls",
				"Vol au vent", "Chicken curry", };// List of the items used for lunches and hot food

		String[] sides = { "Beans", "Crusty Roll", "Rice", "Peas", "Wedges", "Curly Fries", "Peppered Sauce Dip",
				"Curry Dip", "Gravy Dip", }; // List of the sides available during lunch which are also under the hot
												// food section

		String[] hotFood = { "Burger", "Lasagne", "Stew", "Veg / Chicken Soup", "Sausages", "Sausage Rolls",
				"Vol au vent", "Chicken curry", "Beans", "Crusty Roll", "Rice", "Peas", "Wedges", "Curly Fries",
				"Peppered Sauce Dip", "Curry Dip", "Gravy Dip" };
		
		hotFood.add("(1)Burger");
		hotFood.add("(2)Lasagne");
		hotFood.add("(3)Stew");
		hotFood.add("(4)Veg Soup");
		hotFood.add("(5)Chicken Soup");
		hotFood.add("(6)White");

		double[] prices = { 4.50, 4.00, 2.50, 2.50, 0.80, 0.80, 1.00, 3.00, 0.60, 0.40, 1.00, 0.60, 1.20, 1.20, 0.60,
				0.60, 0.60 };

		lunchToGoHotFood.home();
		System.out.print("\n\nPlease choose an option above");
		option = key.nextInt();

		if (option == 3) {
			System.out.printf("\n%-25s|%-25s|%-20s", "MEAT", "PRICES", "DEAL");
			System.out.printf("\n----------------------------------------------------------------------------");
			for (int i = 0; i < hotFood.length; i++) {
				System.out.printf("\n%-25s|%-25.2f", hotFood[i], prices[i]);
				System.out.printf("\n----------------------------------------------------------------------------");
			}
		}
	}

	public static double itemPrice(int foodItem) {
		double itemPrice = 0;

		if (foodItem == 1) {
			// burger= $4.50
			System.out.println("You've ordered a burger");
			itemPrice = 4.50;
		}
		if (foodItem == 2) {
			// lasagne = $4.00
			System.out.println("You've ordered fries");
			itemPrice = 4.00;
		}
		if (foodItem == 3) {
			// soda = $1.00
			System.out.println("You've ordered a soda");
			itemPrice = 1.00;
		}
		if (foodItem == 3) {
			// soda = $1.00
			System.out.println("You've ordered a soda");
			itemPrice = 1.00;
		}
		return itemPrice;
	}

	static void home() {
		lunchToGoHotFood.printHeader();
		lunchToGoHotFood.mainMenu();
	}

	static void mainMenu() {
		System.out.printf("\n(1)%s \n\n(2)%s \n\n(3)%s \n\n(4)%s", "Sandwiches", "Salads", "Hot food", "Checkout");
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
