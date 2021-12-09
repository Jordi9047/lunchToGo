package Assignment;

import java.util.*;

import general.*;

public class Ex1 {
		
	//Final Reciept printing array lists
	static ArrayList<String> basketItems= new ArrayList<String>();//Basket from hot food section to be added onto basketItems for printing
	static ArrayList<String> notes= new ArrayList<String>();
	static ArrayList<Double> priceBasket= new ArrayList<Double>();
	static ArrayList<Integer> qty= new ArrayList<Integer>();
	static ArrayList<Double> subTotal= new ArrayList<Double>();
	
	static ArrayList<String> hotFoodArray= new ArrayList<String>();
	static ArrayList<Double> hotFoodPrice= new ArrayList<Double>();
	static ArrayList<String> hotFoodMeal= new ArrayList<String>();
	static ArrayList<Double> mealPrice= new ArrayList<Double>();
	
	static ArrayList<String> sides= new ArrayList<String>();
	static ArrayList<Double> sidesPrice= new ArrayList<Double>();
	
	static int option = 0;
	static int quantity = 0;
	static char yesNo = ' ';
	static String note = "";
	
	static double total = 0.0;
	public static void main(String[] args)
	{
		
		arraysAdd();
		
		mainMenu();
		
	}
	
	static void arraysAdd()

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
		hotFoodMeal.add("*Nothing available* ");//Needs to be made into a meal, and case 4 needs to be cut and pasted to case 5
		hotFoodMeal.add("*Nothing available* ");
		hotFoodMeal.add("*Nothing available* ");
		hotFoodMeal.add("*Nothing available* ");
		hotFoodMeal.add("+1 side £3.50 or +2 sides £4.00");
		
		//hotFoodMeal.add(9,"*Nothing available* ");
		
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
		
		//hotFoodArray.addAll(sides);
		
		sidesPrice.add(0.60);
		sidesPrice.add(0.40);
		sidesPrice.add(1.00);
		sidesPrice.add(0.60);
		sidesPrice.add(1.20);
		sidesPrice.add(1.20);
		sidesPrice.add(0.60);
		sidesPrice.add(0.60);
		sidesPrice.add(0.60);
		
		//hotFoodPrice.addAll(sidesPrice);
	}
	
	static void hotFood ()
	{
		option = 0;

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
			foodItem = foodItem - 1;
			System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
			
			yesNo = MyVal.validYN("\n\nMake it a meal? " +hotFoodMeal.get(foodItem));
			
			if (yesNo == 'N')
				{
					basketItems.add(hotFoodArray.get(foodItem));
					priceBasket.add(hotFoodPrice.get(foodItem));
					addNotes();
					System.out.println("\n" + (hotFoodArray.get(foodItem)) + "\nAdded to basket");
					quantity = quantity();
					qtyTotal(quantity, hotFoodPrice.get(foodItem));
					goHome();
				}
			else
			{
				basketItems.add(hotFoodArray.get(foodItem)+ " Meal");
				priceBasket.add(mealPrice.get(foodItem));
				Ex1.sidesMenuDeal();
			}
			break;
			
		case 5:
		case 6:
		case 7:
		case 8:
			foodItem = foodItem-1;
			System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
			basketItems.add(hotFoodArray.get(foodItem));
			priceBasket.add(hotFoodPrice.get(foodItem));
			addNotes();
			quantity = quantity();
			qtyTotal(quantity, hotFoodPrice.get(foodItem));
			System.out.println("\n" + (hotFoodArray.get(foodItem)) + "\nAdded to basket");
			goHome();
			break;
			
		case 9:
			option = 0;
			foodItem = foodItem-1;
			System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem), hotFoodPrice.get(foodItem));
			
			My.p("\nYou can order "+ hotFoodMeal.get(foodItem));
			
			yesNo = MyVal.validYN("\n\nMake it a meal?");
								
			if (yesNo == 'N')
				{
					basketItems.add(hotFoodArray.get(foodItem));
					priceBasket.add(hotFoodPrice.get(foodItem));
					System.out.printf("\nAdded to basket");
					System.out.printf("\nAdded" + basketItems.toString());
				}
					else
					{
						basketItems.add(hotFoodArray.get(foodItem));
						option = Ex1.printFoodOption(option);
						if (option == 1)
						{
							priceBasket.add(mealPrice.get(4));
							System.out.printf("\nYou've ordered a Chicken Curry meal with 1 side (£%.2f)" ,mealPrice.get(4));
						}
						else if (option == 2)
						{
							priceBasket.add(mealPrice.get(5));
							System.out.printf("\nYou've ordered a Chicken Curry meal with 2 sides (£%.2f)" ,mealPrice.get(5));
						}
						Ex1.sidesMenuDeal();
					}
		}
	}
		
	static void reciept ()
	{
		System.out.printf("\n%-25s|%-40s|%-15s|%-15s|%-15s", "Item", "Notes", "Price", "Qty", "Subtotal");
		System.out.print("\n************************************************************************************************************");
		for (int i = 0; i < basketItems.size(); i++) 
		{
			System.out.printf("\n%-25s|%-40s|£%-14.2f|%-15s|£%-15.2f", basketItems.get(i), notes.get(i), priceBasket.get(i), qty.get(i), subTotal.get(i));
			//System.out.printf("\n----------------------------------------------");
		}
		System.out.print("\n************************************************************************************************************");
		System.out.printf("\n\nTotal Price £%.2f " ,totalPrice(subTotal));
	}
	
		public static double totalPrice(List<Double> list) 
		{
		    int sum = 0;
		    for (double i: list) {
		        sum += i;
		    }
		    return sum;
		}
	
	static void sidesMenu() 
	{
		{
			System.out.printf("\n%-24s|%-20s", "SIDES", "PRICE");
			
			System.out.print("\n----------------------------------");
			
				for (int i = 0; i < sides.size(); i++) 
				{
					System.out.printf("\n\n%-1s)%-22s|£%-19.2f", i+1, sides.get(i), sidesPrice.get(i));//Only our sides will be printed out here,even without the price. The meal has a set price and they can choose whatever side the customer wants
					//System.out.printf("\n----------------------------------------------");
				}
				
			int sideOption = MyVal.validIntRange("\n\nPlease choose an option above", 1, sides.size());
			
			System.out.println("\n" + sides.get(sideOption-1) + "\nAdded as a side.");
			
			int quantity = quantity();
			
			qtyTotal(quantity, mealPrice.get(option-1));
			
			notes.add("+ " + sides.get(option-1) + " side");
			
			yesNo = MyVal.validYN("\nReturn to hot food selection (Y), or home (N)?");
			
			if (yesNo == 'N')
			{
				mainMenu();
			}
				else if (yesNo == 'Y')
				{
					hotFood();
				}
		}
	}
	
	static void sidesMenuDeal() 
	{
		System.out.printf("\n%-24s", "SIDES");
		
		System.out.print("\n-------------------");
		
			for (int i = 0; i < sides.size(); i++) 
			{
				System.out.printf("\n\n%-1s)%-22s", i+1, sides.get(i));//Only our sides will be printed out here,even without the price. The meal has a set price and they can choose whatever side the customer wants
				//System.out.printf("\n----------------------------------------------");
			}
			
		int sideOption = MyVal.validIntRange("\n\nPlease choose an option above", 1, sides.size());
		
		System.out.println("\n" + sides.get(sideOption-1) + "\nAdded as a side.");
		
		quantity = quantity();
		
		System.out.print(mealPrice.toString());
		
		qtyTotal(quantity, mealPrice.get(option-1));
		
		notes.add("+ " + sides.get(option-1) + " side");
		
		yesNo = MyVal.validYN("\nReturn to hot food selection (Y), or home (N)?");
		
		if (yesNo == 'N')
		{
			mainMenu();
		}
			else if (yesNo == 'Y')
			{
				hotFood();
			}
	}
	
	static void addNotes ()
	{
		yesNo = MyVal.validYN("Are there any notes or further requirements for this item?");
		if(yesNo == 'N')
		{
			notes.add("");
		}
			else
			{
				My.p("Note : ");
				Scanner key = new Scanner (System.in);
				note = key.nextLine();
				notes.add(note);
			}
	}
	
	static void goHome()

	{
		yesNo = MyVal.validYN("\nReturn to same food selection (Y), or home (N)?");
		
		if (yesNo == 'N')
		{
			mainMenu();
		}
			else if (yesNo == 'Y')
			{
				hotFood();
			}
	}
	
	static int home(int choice) {
		int option = 0;
		Ex1.printHeader();
		Ex1.mainSelection();
		return Ex1.printFoodOption(option);
	}
	
	static void mainMenu()
	{

		option = Ex1.home(option);
		
		switch (option)
		{
		case 1:
	       	System.out.println("");
	        break;
		/*case 2:
	       	System.out.println("No work from nathan");
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
	
	static void mainSelection() {

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
	
	public static int quantity() 
	{
		int quantity = MyVal.validInt("Enter quantity");
		qty.add(quantity);
		return quantity;
	}
	
	public static double qtyTotal(double quantity, double itemPrice) {

		double qtyTotal = quantity * itemPrice;
		subTotal.add(qtyTotal);
		return qtyTotal;
	}

	static void admin() /*Admin method will be used to identify a staff member, who can make changes to the system 
						depending on stock levels, and remove items from being displayed accordingly. 
						Of course, the staff member can also order, with their discount rate automatically applied*/
	{
		String staff_1 = "jmcelwee";
		String staff_2 = "treety";
		String login = "";
		
		Scanner key = new Scanner (System.in);
		My.p("Please enter your sign-in ID");
		login = key.nextLine();
		
		int count = 0;
		
		if (login.equals(staff_1)| login.equals(staff_2))
		{
			My.pl("\nWelcome Staff member. Remeber you get an automatic 10% discount on your order");
			mainMenu();
		}
		else
		{
			count = count++;
			My.p("Incorrect sign in details!");
		}
	}
}
