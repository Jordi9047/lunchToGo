package Assignment;

import java.awt.Menu;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import general.*;

	public class lunchToGoHotFood 
	{

		public static void main(String[] args) 
		{
			Scanner key = new Scanner(System.in);
			
			int option = 0;
			
			String[] bread = {"White", "Brown", "Granary", "White Roll", 
					"Brown Roll", "White Wrap", "Brown Wrap", "Gluten free",}; //List of the bread options
			
			String[] spread = {"Butter", "Mayonnasie"}; //List of the spreads for the sandwiches
			
			String[] meat = {"Grilled Chicken", "Breaded Chicken", "Ham", "Pepperoni", 
					"Turkey", "Steak", "Tuna", "Chicken Supreme", "Taco Chicken", "Chicken Tikka"}; //List of the meat 
			
			String[] salad = {"Lettuce", "Tomato", "Onions", "Peppers", "Cucumber", "Sweetcorn", 
					"Cheese", "Pickles", "Rice", "Egg", "Spinach", "Coleslaw"} ;//List of the salads 
			
			String[] sauce = {"Mayo", "Taco", "BBQ", "Ketchup", "HP Brown Sauce"}; //List of the sauces for all menu options
			
			String[] items = {"Burger", "Stew", "Lasagne", "Veg Soup", "Chicken Soup", 
					"Sausages", "Sausage Rolls",  "Vol au vent", "Chicken curry",};//List of the items used for lunches and hot food
			
			String[] sides = {"Chips", "Beans", "Crusty Roll", "Rice", "Peas", 
					"Wedges", "Curly Fries",  "Peppered Sauce Dip", "Gravy Dip",}; //List of the sides available during lunch which are also under the hot food section 
		
			
			lunchToGoHotFood.home();
			System.out.print("\n\nPlease choose an option above");
			option = key.nextInt();
			
			if (option == 3)
			{
				System.out.printf("\n%-25s|%-25s|%-20s", "MEAT", "SIDES", "DEAL");
				System.out.printf("\n--------------------------------------------------------------------");
				for (int i = 0; i< 8; i++)	
				{
				System.out.printf("\n%-25s|%-25s|%-20s", items[i], sides[i], sides[i]);
				System.out.println("");
				//System.out.printf("\n----------------------------------------------------------------------------");
				}
			}
		}
		
		static void hotFood ()
		{
			for (int i = 0; i< 5; i++)	
			{
			My.p(String.format("\n\t%-12s %10d %10d %10d %15.1f", meat[i], math[i], eng[i], it[i], avg[i]));
			}
		}
		
		
		static void home ()
		{
			lunchToGoHotFood.printHeader();
			lunchToGoHotFood.mainMenu();
		}
		
		static void mainMenu ()
		{
			System.out.printf("\n(1)%s \n\n(2)%s \n\n(3)%s \n\n(4)%s", "Sandwiches", "Salads", "Hot food", "Checkout");
		}
		
		static void printHeader() 
		{
	        System.out.println("+-----------------------------------+");
	        System.out.println("|            Welcome to             |");
	        System.out.println("|           Lunch and go!           |");
	        System.out.println("+-----------------------------------+");
		}
		
		
	}
