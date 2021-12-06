package Assignment;

import java.util.*;

import general.*;

public class Ex1 {
	
	static ArrayList<String> checkout= new ArrayList<String>();//Overall strings (and maybe prices) for printing the recipe
	
	static ArrayList<String> hotFoodBasket= new ArrayList<String>();//Basket from hot food section to be added onto checkout for printing
	static ArrayList<Double> priceBasket= new ArrayList<Double>();
	
	static ArrayList<String> hotFoodArray= new ArrayList<String>();
	static ArrayList<Double> hotFoodPrice= new ArrayList<Double>();
	static ArrayList<String> hotFoodMeal= new ArrayList<String>();
	static ArrayList<Double> mealPrice= new ArrayList<Double>();
	
	static ArrayList<String> sides= new ArrayList<String>();
	static ArrayList<Double> sidesPrice= new ArrayList<Double>();
	
	static int option = 0;
	
	static char yesNo = ' ';
	
	public static void main(String[] args)
	{
		
		hotFoodArray.add("Burger");
		hotFoodArray.add("Lasagne");
		hotFoodArray.add("Stew");
		hotFoodArray.add("Veg Soup");
		hotFoodArray.add("Chicken Soup");
		hotFoodArray.add("Sausage");
		hotFoodArray.add("Sausage Rolls");
		hotFoodArray.add("Vol au vent");
		hotFoodArray.add("Chicken Curry");
		
		hotFoodPrice.add(4.50);
		hotFoodPrice.add(4.00);
		hotFoodPrice.add(2.50);
		hotFoodPrice.add(2.50);
		hotFoodPrice.add(2.50);
		hotFoodPrice.add(0.80);
		hotFoodPrice.add(0.80);
		hotFoodPrice.add(1.00);
		hotFoodPrice.add(3.00);
		
		hotFoodMeal.add("+1 side £5.00");
		hotFoodMeal.add("+1 side £4.50");
		hotFoodMeal.add("+ Crusty roll £2.75 ");
		hotFoodMeal.add("+ Crusty roll £2.75 ");
		hotFoodMeal.add("*Nothing available* ");
		hotFoodMeal.add("*Nothing available* ");
		hotFoodMeal.add("*Nothing available* ");
		hotFoodMeal.add("*Nothing available* ");
		hotFoodMeal.add("+1 side £3.50 or +2 sides £4.00");
		
		mealPrice.add(5.00);
		mealPrice.add(4.50);
		mealPrice.add(2.75);
		mealPrice.add(2.75);
		mealPrice.add(3.50);
		mealPrice.add(4.00);
		
		sides.add("Beans");
		sides.add("Crusty Roll");
		sides.add("Rice");
		sides.add("Peas");
		sides.add("Wedges");
		sides.add("Curly Fries");
		sides.add("Peppered Sauce Dip");
		sides.add("Curry Dip");
		sides.add("Gravy Dip");
		
		sidesPrice.add(0.60);
		sidesPrice.add(0.40);
		sidesPrice.add(1.00);
		sidesPrice.add(0.60);
		sidesPrice.add(1.20);
		sidesPrice.add(1.20);
		sidesPrice.add(0.60);
		sidesPrice.add(0.60);
		sidesPrice.add(0.60);
		
		option = Ex1.home(option);
		
		switch (option)
		{
		/*case 1:
	       	System.out.println("");
	        break;
		case 2:
	       	System.out.println("");
	        break;*/
		case 3:
			hotFood();
	        break;
		case 4:
			reciept();
	        break;
		case 5:
			admin();
	    /*default:
	       	System.out.println("Invalid! You have not chose an option between 1-4");
	        break;*///With the correct validation our team has in place, we should never reach this default
		}
	}
	
	static void hotFood ()
	{
		int option = 0;

		System.out.printf("\n%-20s|%-20s|%-20s", "HOT FOOD", "PRICE", "DEALS");
		System.out.print("\n----------------------------------------------------------------");
		for (int i = 0; i < hotFoodArray.size(); i++) 
		{
			System.out.printf("\n\n%-1s)%-18s|£%-19.2f|%-20s", i+1,hotFoodArray.get(i), hotFoodPrice.get(i), hotFoodMeal.get(i));
			//System.out.printf("\n----------------------------------------------");
		}
		
		option = MyVal.validIntRangeArrayList("\n\nPlease choose an option above", 1, hotFoodArray.size());

		Ex1.basketHotPrice(option);
		
	}
	
	static void basketHotPrice (int foodItem) {

		switch (foodItem) 
		{ 
		case 1:
		case 2:
		case 3: 
		case 4: //deliberate fall through here as the layout is exactly the same, but foodItem changes the item, price and meal deal text. More efficient and reusable if something in the system changes.
			
			foodItem = foodItem-1;
			
			System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
			
			yesNo = MyVal.validYN("\n\nMake it a meal? " +hotFoodMeal.get(foodItem));
			
			if (yesNo == 'N')
				{
					hotFoodBasket.add(hotFoodArray.get(foodItem));
					System.out.printf("\n%Added to basket");
				}
			else
			{
				Ex1.sidesMenuDeal();
			}
			break;
			
		case 5:
		case 6:
		case 7:
		case 8:
			foodItem = foodItem-1;
			System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
			break;
			
		case 9:
			option = 0;
			foodItem = foodItem-1;
			System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem), hotFoodPrice.get(foodItem));
			
			My.p("\nYou can order "+ hotFoodMeal.get(foodItem));
			
			yesNo = MyVal.validYN("\n\nMake it a meal?");
								
			if (yesNo == 'N')
				{
					hotFoodBasket.add(hotFoodArray.get(foodItem));
					System.out.printf("\nAdded to basket");
					System.out.printf("\nAdded" + hotFoodBasket.toString());
				}
					else
					{
						option = Ex1.printFoodOption(option);
						if (option == 1)
						{
							System.out.printf("\nYou've ordered a Chicken Curry meal with 1 side (£%.2f)" ,mealPrice.get(4));
						}
						else if (option == 2)
						{
							System.out.printf("\nYou've ordered a Chicken Curry meal with 2 sides (£%.2f)" ,mealPrice.get(5));
						}
						Ex1.sidesMenuDeal();
					}
		}
	}
		
	static void reciept ()
	{
		ArrayList<Ex1> checkout = new ArrayList<Ex1>();
		
		System.out.printf("\n%-15s|%-15s|%-15s|%-15s|%-15s", "Item", "Notes", "Price", "Qty", "Subtotal");
		System.out.print("\n--------------------------------------------------------------------------");
	}
	
	static void sidesMenuDeal() 
	{
		
		System.out.printf("\n%-24s|%-20s", "SIDES", "PRICE");
		
		System.out.print("\n----------------------------------");
		
			for (int i = 0; i < sides.size(); i++) 
			{
				System.out.printf("\n\n%-1s)%-22s|£%-19.2f", i+1, sides.get(i), sidesPrice.get(i));//Only our sides will be printed out here,even without the price. The meal has a set price and they can choose whatever side the customer wants
				//System.out.printf("\n----------------------------------------------");
			}
			
		option = MyVal.validIntRange("\n\nPlease choose an option above", 1, sides.size());
		
		System.out.println("\n" + sides.get(option-1) + "\nAdded as a side.");
		
		yesNo = MyVal.validYN("\nReturn to hot food selection (Y), or home (N)?");
		
		if (yesNo == 'N')
		{
			option = Ex1.home(option);
		}
			else if (yesNo == 'Y')
			{
				hotFood();
			}
	}
	
	static void goHome()

	{
		yesNo = MyVal.validYN("\nReturn to hot food selection (Y), or home (N)?");
		
		if (yesNo == 'N')
		{
			main(null);
		}
			else if (yesNo == 'Y')
			{
				hotFood();
			}
	}
	
	static int home(int choice) {
		int option = 0;
		Ex1.printHeader();
		Ex1.mainMenu();
		return Ex1.printFoodOption(option);
	}
	
	static void mainMenu() {

		System.out.printf("\n(1)%s \n\n(2)%s \n\n(3)%s \n\n(4)%s \n\n(5)%s", "Sandwiches", "Salads", "Hot food", "Checkout", "Staff login");
	}

	public static int printFoodOption(int choice)
	{
		int option = 0;
		option = MyVal.validIntRange("\nPlease choose an option above", 1, 5);
		return option;
	}
	
	static void printHeader() {
		System.out.println("+-----------------------------------+");
		System.out.println("|            Welcome to             |");
		System.out.println("|           Lunch and go!           |");
		System.out.println("+-----------------------------------+");
	}
	
	public static double quantity() 
	{
		Scanner key = new Scanner(System.in);
		System.out.println("Enter quantity");
		double quantity = key.nextDouble();
		subTotal(quantity, quantity);
		key.close();
		return quantity;
	}
	
	public static double subTotal(double quantity, double itemPrice) {
		double runningTotal = 0;
		double subTotal = quantity * itemPrice;
		System.out.println("Subtotal" + subTotal);
		runningTotal += subTotal;
		return subTotal;
	}

	static void admin() /*Admin method will be used to identify a staff member, who can make changes to the system 
						depending on stock levels, and remove items from being displayed accordingly. 
						Of course, the staff member can also order, with their discount rate automatically applied*/
	{
		String staff_1 = "jmcelwee1";
		String staff_2 = "treety1";
		String staff_3 = "nmorrow1";
		String login = "";
		
		int count = 0;
		
		Scanner key = new Scanner (System.in);
		My.p("Please enter your sign-in ID");
		login = key.next();
		
		if (login != staff_1 | login != staff_2 | login != staff_3)
		{
			count = count++;
			My.p("Incorrect sign in details!");
		}
		
	}
}
