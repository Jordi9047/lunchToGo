package Assignment;

import java.util.*;

import general.*;

public class StockItem {
	
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
	static ArrayList<Integer> hotFoodQty= new ArrayList<Integer>();
	
	static ArrayList<String> sides= new ArrayList<String>();
	static ArrayList<Double> sidesPrice= new ArrayList<Double>();
	static ArrayList<String> sauce = new ArrayList<String>();
	
	static int option = 0;
	static int quantity = 0;
	static char yesNo = ' ';
	static String note = "";
	static String staff = "";
	static double total = 0.0;
	
	
	public static void main(String[] args)
	{
		
		arraysAdd();

		mainMenu();
		
	}
	
	public static void arraysAdd()

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
		
		hotFoodMeal.add("+1 side");
		hotFoodMeal.add("+1 side");
		hotFoodMeal.add("+ Crusty roll");
		hotFoodMeal.add("+ Crusty roll");
		hotFoodMeal.add("+ Crusty roll");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("+1 side £3.50 or +2 sides £4.00");

		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		//hotFoodMeal.add(9,"*Nothing available* ");
		
		mealPrice.add(5.00);
		mealPrice.add(4.50);
		mealPrice.add(2.75);
		mealPrice.add(2.75);
		mealPrice.add(2.75);
		mealPrice.add(3.50);
		mealPrice.add(4.00);
		
		sides.add("Chips");
		sides.add("Beans");
		sides.add("Crusty Roll");
		sides.add("Rice");
		sides.add("Peas");
		sides.add("Wedges");
		sides.add("Curly Fries");
		sides.add("Peppered Sauce Dip");
		sides.add("Curry Dip");
		sides.add("Gravy Dip");
		
		hotFoodArray.addAll(sides);
		
		sidesPrice.add(1.20);
		sidesPrice.add(0.60);
		sidesPrice.add(0.40);
		sidesPrice.add(1.00);
		sidesPrice.add(0.60);
		sidesPrice.add(1.20);
		sidesPrice.add(1.20);
		sidesPrice.add(0.60);
		sidesPrice.add(0.60);
		sidesPrice.add(0.60);
		
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		hotFoodQty.add(50);
		
		sauce.add("Mayo");
		sauce.add("Taco");
		sauce.add("BBQ");
		sauce.add("Ketchup");
		sauce.add("HP Brown Sauce");
		
		hotFoodPrice.addAll(sidesPrice);
	}
	
	static void printHotFood ()
	{
		option = 0;

		System.out.printf("\n%-22s|%-20s|%-20s", "HOT FOOD", "PRICE", "DEALS");
		System.out.print("\n---------------------- ------------------- --------------------------------");
		for (int i = 0; i < hotFoodArray.size(); i++) 
		{
			System.out.printf("\n\n%2s)%-19s|£%-19.2f|%-20s", i+1,hotFoodArray.get(i), hotFoodPrice.get(i), hotFoodMeal.get(i));
			
		}
		System.out.print("\n---------------------- -------------------- -------------------------------");
		option = MyVal.validIntRangeArrayList("\nPlease choose an option above (1 - " + hotFoodArray.size() + ")", 1, hotFoodArray.size());
	}
	
	static void hotFoodSelection ()
	{
		printHotFood();
		
		StockItem.basketHotPrice(option);
	}
	
	static void basketHotPrice (int foodItem) 

	{
		foodItem = foodItem-1;
		if (hotFoodMeal.get(foodItem).equals("+1 side"))
		{ 
			// This is a correction to make this code more usable if case 2 is picked (option ==2) then index 1 of hotFoodArray will be chosen.
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
				System.out.println("\n" + (hotFoodArray.get(foodItem)) + " meal added to basket");
				priceBasket.add(mealPrice.get(foodItem));
				StockItem.sidesMenuDeal();
			}
		}
		
			else if (hotFoodMeal.get(foodItem).equals("+ Crusty roll"))
			{
				System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
				
				yesNo = MyVal.validYN("\n\nMake it a meal? + 1 Crusty roll £2.75 ");
				
				if (yesNo == 'N')
					{
						basketItems.add(hotFoodArray.get(foodItem));
						priceBasket.add(hotFoodPrice.get(foodItem));
						addNotes();
						My.p("\n" + (hotFoodArray.get(foodItem)) + "\nAdded to basket");
						quantity = quantity();
						qtyTotal(quantity, hotFoodPrice.get(foodItem));
						goHome();
					}
						else
						{
							basketItems.add(hotFoodArray.get(foodItem)+ " Meal");
							priceBasket.add(mealPrice.get(foodItem));
							notes.add("+ Crusty Roll side");
							My.p("\n" + (hotFoodArray.get(foodItem)) + " meal added to basket");
							quantity = quantity();
							qtyTotal(quantity, hotFoodPrice.get(foodItem));
							goHome();
						}
			}
			else if (hotFoodArray.get(foodItem).equals("Chicken Curry"))
			{
				option = 0;
				System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem), hotFoodPrice.get(foodItem));
				
				yesNo = MyVal.validYN("\n\nMake it a meal?");
									
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
							System.out.println("\n" + (hotFoodArray.get(foodItem)) + " meal added to basket");
							My.p("\nYou can order "+ hotFoodMeal.get(foodItem));
							option = MyVal.validIntRangeArrayList("\n\nPlease choose an option above", 1, 2);
							if (option == 1)
							{
								priceBasket.add(mealPrice.get(5));
								System.out.print(mealPrice.get(5));
								System.out.printf("\n1 side meal (£%.2f)" ,mealPrice.get(5));
								Ex1.sidesMenuDeal();
							}
								else if (option == 2)
								{
									System.out.printf("\n2 sides meal(£%.2f)" ,mealPrice.get(6));
									basketItems.add("");
									priceBasket.add(mealPrice.get(6));
									priceBasket.add(0.0);
									
									
									for (int i = 0; i < option; i++)
									{
										for (int j = 0; j < sides.size(); j++)
										{
											System.out.printf("\n\n%-1s)%-22s", j+1, sides.get(j));//Only our sides will be printed out here,even without the price. The meal has a set price and they can choose whatever side the customer wants									//System.out.printf("\n----------------------------------------------");
										}
									
									int sideOption = MyVal.validIntRange("\n\nPlease choose an option above", 1, sides.size());
									
									System.out.println("\n" + sides.get(sideOption-1) + "\nAdded as a side.");
															
									yesNo = MyVal.validYN("\nAre there any notes or requirements?");
									if(yesNo == 'N')
									{
										notes.add("+ " + sides.get(sideOption-1) + " side");
									}
										else
										{
											sauceChoice();
											My.p("Note : ");
											Scanner key = new Scanner (System.in);
											note = key.nextLine();
											notes.add("+ " + sides.get(option-1) + " side / " + note); //New method make addNotesMeal to clean space
										}
										
									}
										int quantity = quantity();
										
										qtyTotal(quantity, mealPrice.get(6));
										
										qty.add(quantity);
										
										subTotal.add(0.0);
										
										goHome();
								}
							
						}
			}
							else
							{
								System.out.printf("\nYou've ordered: \n%10s (£%.2f)", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
								basketItems.add(hotFoodArray.get(foodItem));
								priceBasket.add(hotFoodPrice.get(foodItem));
								quantity = quantity();
								addNotes();
								qtyTotal(quantity, hotFoodPrice.get(foodItem));					
								My.p("\n" + (hotFoodArray.get(foodItem)) + "\nAdded to basket");
								goHome();
							}
	}
	
	static void reciept ()
	{
		System.out.printf("\n%-25s|%-40s|%-15s|%-15s|%-15s", "Item", "Notes", "Price", "Qty", "Subtotal");
		//System.out.printf("\n%-26s%-41s%-16s%-16s%-16s", "----", "-----", "-----", "---", "--------");
		System.out.print("\n************************************************************************************************************");
		for (int i = 0; i < basketItems.size(); i++) 
		{
			System.out.printf("\n%-25s|%-40s|£%-14.2f|%-15s|£%-15.2f", basketItems.get(i), notes.get(i), priceBasket.get(i), qty.get(i), subTotal.get(i));
			System.out.printf("\n");
		}
		System.out.println("\n************************************************************************************************************");
		
		if (staff.equals("jmcelwee") || staff.equals("treety"))
		{
			total = (totalPrice(subTotal)/100 * 10);
			System.out.printf("\n%-80s%-5s|£%-10.2f", "", "10% staff discount", total);
			total = (totalPrice(subTotal) - total);
			System.out.printf("\n\n%-93s%-5s|£%-10.2f", "", "Total", total);
		}
			else
			{
				//System.out.printf("\n\t\t\t\t\t\t\t\t\t\tTotal Price £%.2f " ,totalPrice(subTotal));
				System.out.printf("\n%-93s%-5s|£%-10.2f", "", "Total", totalPrice(subTotal) );
			}
	}
	
	static double totalPrice(List<Double> list) // Total price method that calculates the total sum of the priceBasket
		{
		    double sum = 0; // Variable
		    for (double i: list) { //For each index in the list, loops to the size of the priceBasket
		        sum += i; //Add the sum of the index to the sum
		    }
		    return sum; //Final result, our total, will be returned
		}
	
	static void sidesMenu() //Dead code. Hot food and the sides have been combined in the final product.
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
					hotFoodSelection();
				}
		}
	}
	
	static void sidesMenuDeal() //If a meal deal is selected, we want the sidesMenuDeal method to run, which prints out a dedicated sides menu.

	{
		System.out.printf("\n%-24s", "SIDES");
		
		System.out.print("\n-------------------");
		
			for (int i = 0; i < sides.size(); i++) 
			{
				System.out.printf("\n\n%-1s)%-22s", i+1, sides.get(i));//Only our sides will be printed out here,even without the price. The meal has a set price and they can choose whatever side the customer wants
				//System.out.printf("\n----------------------------------------------");
			}
			
		int sideOption = MyVal.validIntRange("\n\nPlease choose an option above", 1, sides.size()); //Using MyVal, we can set the validation range to be the size of the sides list, which can either be increased or decrease by staff / admin
		
		System.out.println("\n" + sides.get(sideOption-1) + " added as a side.");//Confirms to the customer that the item has been added as a side
		
		quantity = quantity(); //
		
		qtyTotal(quantity, mealPrice.get(option-1)); //Calling qtyTotal method which times the quantity of the item by the mealPrice.
		
		addNotes(); //Calling addNotes. Allows customer to input any other extras or info such as no veg, extra hot, well done etc. 
		
		goHome(); //Option of returning to the main menu, or returning to the start of the hot food selection again for another option.
	}
	
	static void sauceChoice()
	{
		My.pl("\nThese are the available sauce choices if you wish to chance or add a sauce as a side");
		System.out.printf("\n%-24s", "SAUCES");
		
		System.out.print("\n-------------------");
			for (int i = 0; i < sauce.size(); i++) 
			{
				System.out.printf("\n\n%-1s)%-22s", i+1, sauce.get(i));
			}
			//Adding to the sandwichContent ArrayList
	}
	
	static void addNotes ()
	{
		yesNo = MyVal.validYN("\nAre there any notes or requirements?");
		if(yesNo == 'N')
		{
			notes.add("");
		}
			else
			{
				sauceChoice();
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
				hotFoodSelection();
			}
	}
	
	static int home(int choice) 
	{
		int option = 0;
		StockItem.printHeader();
		StockItem.mainSelection();
		return StockItem.printFoodOption(option);
	}
	
	static void mainMenu()
	{

		option = StockItem.home(option);
		
		switch (option)
		{
		case 1:
	       	System.out.println("WIP");
	       	mainMenu();
	        break;
		case 2:
	       	System.out.println("No work from Nathan, our Salads are currently unavailible to order.");
	       	mainMenu();
	        break;
		case 3:
			hotFoodSelection();
	        break;
		case 4:
			reciept();
	        break;
		case 5:
			if (staff.equals("jmcelwee") || staff.equals("treety"))
			{
				stockUpdateHot();
			}
				else
				{
					admin();
				}
			break;
	    /*default:
	       	System.out.println("Invalid! You have not chose an option between 1-4");
	        break;*///With the correct validation our team has in place, we should never reach this default
		}
	}
	
	static void mainSelection() 
	{
		if (staff.equals("jmcelwee") || staff.equals("treety"))
		{
			My.p("\n -----------------------------------");
			My.p(String.format("\n|   %-18s %14s ", "(1) Sandwiches", "|"));
			My.p("\n -----------------------------------");
			My.p(String.format("\n|   %-18s %14s ", "(2) Salad", "|"));
			My.p("\n -----------------------------------");
			My.p(String.format("\n|   %-18s %14s ", "(3) Hot Food", "|"));
			My.p("\n -----------------------------------");
			My.p(String.format("\n|   %-18s %14s ", "(4) Checkout", "|"));
			My.p("\n -----------------------------------");
			My.p(String.format("\n|   %-18s %9s ", "(5) Update Availability", "|"));
			My.p("\n -----------------------------------");
		}
			else 
			{
				My.p("\n -----------------------------------");
				My.p(String.format("\n|   %-18s %14s ", "(1) Sandwiches", "|"));
				My.p("\n -----------------------------------");
				My.p(String.format("\n|   %-18s %14s ", "(2) Salad", "|"));
				My.p("\n -----------------------------------");
				My.p(String.format("\n|   %-18s %14s ", "(3) Hot Food", "|"));
				My.p("\n -----------------------------------");
				My.p(String.format("\n|   %-18s %14s ", "(4) Checkout", "|"));
				My.p("\n -----------------------------------");
				My.p(String.format("\n|   %-18s %14s ", "(5) Staff login", "|"));
				My.p("\n -----------------------------------");
			}
		//System.out.printf("\n(1)%s \n\n(2)%s \n\n(3)%s \n\n(4)%s \n\n(5)%s", "Sandwiches", "Salads", "Hot food", "Checkout", "Staff login");
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
		int quantity = MyVal.validInt("Enter quantity : ");
		qty.add(quantity);
		return quantity;
	}
	
	public static double qtyTotal(double quantity, double itemPrice) {

		double qtyTotal = quantity * itemPrice;
		subTotal.add(qtyTotal);
		return qtyTotal;
	}

	static void stockUpdateHot ()
	{
    	double newPrice = 0.0;
		System.out.println("\nAvailability Main Menu");
	    System.out.println("*******************");
	    System.out.println("1. Delete an Item");
	    System.out.println("2. Update Item Price");
	    System.out.println("3. Print Item List");
	    System.out.println("4. Exit");

	    option = MyVal.validIntRange("Select option [1-4] :", 1, 4);
	    
	    switch (option)
	    {
	    case 1:
	    	option = 0;

			printHotFood();
		
			My.p("\nRemoved "+ hotFoodArray.get(option-1));
	    	hotFoodArray.remove(option-1);
	    	hotFoodPrice.remove(option-1);
	    	hotFoodMeal.remove(option-1);
	    	
	    	stockUpdateHot();
	    	break;
	 
	    case 2:
	    	printHotFood();
		
			newPrice = MyVal.validDouble("Enter the price", newPrice);
	    	hotFoodPrice.set(option-1, newPrice);
	    	
	    	stockUpdateHot();
	    	break;
	    case 3:
	    	printHotFood();
			stockUpdateHot();
	    	break;
	    case 4:
	    	mainMenu();
	    	break;
	    }
	    
	}
	
	static void admin() /*Admin method will be used to identify a staff member, who can make changes to the system 
						depending on stock levels, and remove items from being displayed accordingly. 
						Of course, the staff member can also order, with their discount rate automatically applied*/
	{
		String staff_1 = "jmcelwee";
		String staff_2 = "treety";
		String login = "";
		
		Scanner key = new Scanner (System.in);
		My.pl("Please enter your sign-in ID");
		login = key.nextLine();
		
		int count = 0;
	
			if (login.equals(staff_1)| login.equals(staff_2))
			{
				My.pl("\nWelcome member. Remeber you get an automatic 10% discount on your order");
				staff = login;
				mainMenu();
			}
			else
			{
				count = count++;
				My.p("\nIncorrect sign in details!");
			}
	}
}
