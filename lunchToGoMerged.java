package assignment_1;

import java.util.*;

import general.*;

public class lunchToGoMerged {
	
	//Final Reciept printing array lists
		static ArrayList<String> basketItems= new ArrayList<String>();//Basket from hot food section to be added onto basketItems for printing
		static ArrayList<String> notes= new ArrayList<String>();
		static ArrayList<Double> priceBasket= new ArrayList<Double>();
		static ArrayList<Integer> qty= new ArrayList<Integer>();
		static ArrayList<Double> subTotal= new ArrayList<Double>();
		
		//Hot food array lists which are used to add to the overall basket
		static ArrayList<String> hotFoodArray = new ArrayList<String>();
		static ArrayList<Double> hotFoodPrice = new ArrayList<Double>();
		static ArrayList<String> hotFoodMeal = new ArrayList<String>();
		static ArrayList<Double> mealPrice = new ArrayList<Double>();
		static ArrayList<Integer> hotFoodQty = new ArrayList<Integer>();
		
		static ArrayList<String> sides= new ArrayList<String>();
		static ArrayList<Double> sidesPrice= new ArrayList<Double>();
		
		//The sandwich content are stored as ArrayLists <String>, like bread, spread, meat, etc.		
		static ArrayList<String> bread = new ArrayList<String>();
		static ArrayList<String> spread = new ArrayList<String>();
		static ArrayList<String> meat = new ArrayList<String>(); 
		static ArrayList<String> salad = new ArrayList<String>();
		static ArrayList<String> sauce = new ArrayList<String>();
					
		//Overall strings for printing the recipe
		static ArrayList<String> sandwichContent = new ArrayList<String>();
		static ArrayList<String> sandwichExtraContent = new ArrayList<String>();
		
		//The extras for the bill stored as ArrayLists <Double>, meat, salad and bill.
		static ArrayList<Double> sandwichExtraPriceBasket = new ArrayList<Double>();
					
		//Global variables which are used throughout both food selections
		static int option = 0; //used and reset to select an item from the menu
		static int quantity = 0; //Substitutes the value into the qtyTotal method
		static char yesNo = ' '; //Simple yes or no statement which is reset throughout
		static String note = ""; //Blank String to write in a note if needed
		static String staff = ""; //Compares to staff_1 and _2 to login
		static double total = 0.0; //Total price of the order
		static int nSand = 0, nCont = 0, nExtras = 0;
		static double sandwichPriceBasket = 0.0;
		static int count = 0;//Used to keep track of failed logins
	
	
	public static void main(String[] args)
	{
		arraysAdd(); //Adds all of the array elements to the list once, and only once. Keeps it much neater having it collapsed 

		mainMenu();//Majority of the program runs by this one method, which calls upon other methods to jump from different scenarios.
	}
	
	//Overall program
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
		hotFoodArray.add("Chicken Curry"); //Hot Items
		
		hotFoodPrice.add(4.50);
		hotFoodPrice.add(4.00);
		hotFoodPrice.add(2.50);
		hotFoodPrice.add(2.50);
		hotFoodPrice.add(2.50);
		hotFoodPrice.add(0.80);
		hotFoodPrice.add(0.80);
		hotFoodPrice.add(1.00);
		hotFoodPrice.add(3.00);//indexed prices
		
		hotFoodMeal.add("+1 side");
		hotFoodMeal.add("+1 side");
		hotFoodMeal.add("+ Crusty roll");
		hotFoodMeal.add("+ Crusty roll");
		hotFoodMeal.add("+ Crusty roll");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("+1 side £3.50 or +2 sides £4.00"); //Strings of the meal deal options available

		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");
		hotFoodMeal.add("*Nothing available*");//For all the sides, as they cannot be meal deals
		
		mealPrice.add(5.00);
		mealPrice.add(4.50);
		mealPrice.add(2.75);
		mealPrice.add(2.75);
		mealPrice.add(2.75);
		mealPrice.add(3.50);
		mealPrice.add(4.00);//Fewer meal deal prices as not all items are full meals
		
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
		
		hotFoodArray.addAll(sides); //Sides are seperate aswell because we need to have its own dedicate menu for the meal deals.
		
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
		
		hotFoodPrice.addAll(sidesPrice);
		
		//Treety Code //The bread type are stored as an Array list of String.
		bread.add("White");
		bread.add("Brown");
		bread.add("Granary");
		bread.add("White Roll");
		bread.add("Brown Roll");
		bread.add("White Wrap");
		bread.add("Brown Wrap");
		bread.add("Gluten Free Roll");
		
		spread.add("Butter");
		spread.add("Mayonnaise");
		
		meat.add("Grilled Chicken");
		meat.add("Breaded Chicken");
		meat.add("Ham");
		meat.add("Peperoni");
		meat.add("Turkey");
		meat.add("Steak");
		meat.add("Tuna");
		meat.add("Chicken supreme");	
		meat.add("Taco Chicken");
		meat.add("Chicken Tikka");	
		
		salad.add("Lettuce");
		salad.add("Tomato");
		salad.add("Onions");
		salad.add("Peppers");
		salad.add("Cucumber");
		salad.add("Steetcorn");
		salad.add("Cheese");
		salad.add("Pickles");	
		salad.add("Rice");
		salad.add("Egg");	
		salad.add("Spinach");
		salad.add("Coleslaw");
		
		sauce.add("Mayo");
		sauce.add("Taco");
		sauce.add("BBQ");
		sauce.add("Ketchup");
		sauce.add("HP Brown Sauce");
	}
	
	static void mainMenu()

	{
		option = lunchToGoMerged.home(option);
		
		switch (option)
		{
		case 1:
	       	sandwich(); //Prints Treetys code, which was the Sandwich
	        break;
		case 2:
	       	System.out.println("Administrator has not authorised this part of the program");
	       	mainMenu();
	        break;
		case 3:
			hotFoodSelection();//Prints Jordans code, being the hot food
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
		}
	}
	
	static int home(int choice) 
	{
		option = 0;
		lunchToGoMerged.printHeader();
		lunchToGoMerged.mainSelection();
		return lunchToGoMerged.printFoodOption(option);
	}
	
	static void printHeader() {
		System.out.println("\n+-----------------------------------+");
		System.out.println("|            Welcome to             |");
		System.out.println("|           Lunch and go!           |");
		System.out.println("+-----------------------------------+");
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
		option = MyVal.validIntRange("\nPlease choose an option above", 1, 5);
		return option;
	}
	
	//Jordan's Code
	static void hotFoodSelection ()
	{
		printHotFood();
		
		lunchToGoMerged.basketHotPrice(option);
	}
	
	static void printHotFood ()
	{
		option = 0;

		System.out.printf("\n%-22s|%-20s|%-20s", "HOT FOOD", "PRICE", "DEALS");//Headers for the three elements
		System.out.print("\n---------------------- ------------------- --------------------------------");
		for (int i = 0; i < hotFoodArray.size(); i++) //For each iteration, if the iteration amount is < than hotFoodArray size, add an increment to the iteration
		{
			System.out.printf("\n\n%2s)%-19s|£%-19.2f|%-20s", i+1,hotFoodArray.get(i), hotFoodPrice.get(i), hotFoodMeal.get(i));//Print out i from the index of hotFoodArray, hotFoodPrice and hotFoodMeal.
			
		}
		My.p("\n---------------------- -------------------- -------------------------------");
		option = MyVal.validIntRangeArrayList("\nPlease choose an option above (1 - " + hotFoodArray.size() + ")", 1, hotFoodArray.size());//Range is the amount of items in the hot food list” . 
	}
	
	static void basketHotPrice (int foodItem) 
	{
		foodItem = foodItem-1;
		if (hotFoodMeal.get(foodItem).equals("+1 side"))
		{ 
			// This is a correction to make this code more usable if case 2 is picked (option ==2) then index 1 of hotFoodArray will be chosen.
			System.out.printf("\nYou've ordered: \n ----------------------- \n|%15s (£%.2f)|", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
			My.p("\n -----------------------");
			yesNo = MyVal.validYN("\n\nMake it a meal? " +hotFoodMeal.get(foodItem));
			
			if (yesNo == 'N')//no meal
				{
					basketItems.add(hotFoodArray.get(foodItem));
					priceBasket.add(hotFoodPrice.get(foodItem));
					addNotes();
					System.out.println("\n" + (hotFoodArray.get(foodItem)) + " added to basket");
					quantity = quantity();
					qtyTotal(quantity, hotFoodPrice.get(foodItem));
					goHome();
				}
			else//meaning yes
			{
				basketItems.add(hotFoodArray.get(foodItem)+ " Meal");
				System.out.println("\n" + (hotFoodArray.get(foodItem)) + " meal added to basket");
				priceBasket.add(mealPrice.get(foodItem));
				lunchToGoMerged.sidesMenuDeal();
			}
		}
		
			else if (hotFoodMeal.get(foodItem).equals("+ Crusty roll"))
			{
				System.out.printf("\nYou've ordered: \n ----------------------- \n|%15s (£%.2f)|", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
				My.p("\n -----------------------");
				yesNo = MyVal.validYN("\n\nMake it a meal? + 1 Crusty roll £2.75 ");
				
				if (yesNo == 'N')
					{
						basketItems.add(hotFoodArray.get(foodItem));
						priceBasket.add(hotFoodPrice.get(foodItem));
						addNotes();
						My.p("\n" + (hotFoodArray.get(foodItem)) + " added to basket");
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
							qtyTotal(quantity, mealPrice.get(foodItem));
							goHome();
						}
			}
			else if (hotFoodArray.get(foodItem).equals("Chicken Curry"))
			{
				option = 0;
				System.out.printf("\nYou've ordered: \n ----------------------- \n|%15s (£%.2f)|", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
				My.p("\n -----------------------");
				yesNo = MyVal.validYN("\n\nMake it a meal?");
									
				if (yesNo == 'N')
					{
						basketItems.add(hotFoodArray.get(foodItem));
						priceBasket.add(hotFoodPrice.get(foodItem));
						addNotes();
						System.out.println("\n" + (hotFoodArray.get(foodItem)) + " added to basket");
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
							if (option == 1)//Need as there are two meals for a chicken curry
							{
								priceBasket.add(mealPrice.get(5));
								
								System.out.printf("\n1 side meal (£%.2f)" ,mealPrice.get(5));
								lunchToGoMerged.sidesMenuDeal();
							}
								else if (option == 2)//Second meal deal option
								{
									System.out.printf("\n2 sides meal(£%.2f)" ,mealPrice.get(6));
									basketItems.add("");
									priceBasket.add(mealPrice.get(6));
									priceBasket.add(0.0);
									
									
									for (int i = 0; i < option; i++)//Loops the menu twice to select 2 options
									{
										System.out.printf("\n\n%-24s", "SIDES");
										
										System.out.print("\n-------------------");
										for (int j = 0; j < sides.size(); j++)
										{
											System.out.printf("\n\n%-1s)%-22s", j+1, sides.get(j));//Only our sides will be printed out here,even without the price. The meal has a set price and they can choose whatever side the customer wants									//System.out.printf("\n----------------------------------------------");
										}
									
									int sideOption = MyVal.validIntRange("\n\nPlease choose an option above", 1, sides.size());
									
									System.out.println("\n" + sides.get(sideOption-1) + " added as a side.");
															
									yesNo = MyVal.validYN("\nAre there any notes or requirements?");
									if(yesNo == 'N')
									{
										notes.add("+ " + sides.get(sideOption-1) + " side");
									}
										else
										{
											sauceChoice(); //Prints out the sauces menu but also the add notes functionality
											My.p("Note : ");
											Scanner key = new Scanner (System.in);
											note = key.nextLine();
											notes.add("+ " + sides.get(option-1) + " side / " + note); //New method make addNotesMeal to clean space
										}
										
									}
										quantity = quantity();
										
										qtyTotal(quantity, mealPrice.get(6)); //Getting the subtotal
										
										qty.add(quantity);//Adding the quantity to the list for the receipt later
										
										subTotal.add(0.0);
										
										goHome();
								}
							
						}
			}
							else
							{
								System.out.printf("\nYou've ordered: \n ----------------------- \n|%15s (£%.2f)|", hotFoodArray.get(foodItem),hotFoodPrice.get(foodItem));
								My.p("\n -----------------------");
								basketItems.add(hotFoodArray.get(foodItem));
								priceBasket.add(hotFoodPrice.get(foodItem));
								quantity = quantity();
								addNotes();
								qtyTotal(quantity, hotFoodPrice.get(foodItem));					
								My.p("\n" + (hotFoodArray.get(foodItem)) + " added to basket");
								goHome();
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
		
		yesNo = MyVal.validYN("\nAre there any notes or requirements?");
		if(yesNo == 'N')
		{
			notes.add("+ " + sides.get(option-1) + " side");
		}
			else
			{
				sauceChoice();
				My.p("Note : ");
				Scanner key = new Scanner (System.in);
				note = key.nextLine();
				notes.add("+ " + sides.get(option-1) + " side / " + note); //New method make addNotesMeal to clean space
			}
		
		goHome(); //Option of returning to the main menu, or returning to the start of the hot food selection again for another option.
	}
	
	static void sauceChoice()
	{
		My.pl("\nThese are the available sauce choices if you wish to change or add a sauce as a side");
		System.out.printf("\n%-24s", "SAUCES");
		
		System.out.print("\n-------------------");
			for (int i = 0; i < sauce.size(); i++) 
			{
				System.out.printf("\n\n%-1s)%-22s", i+1, sauce.get(i));
			}
	}
	
	static void addNotes ()
	{
		yesNo = MyVal.validYN("\nAny sauce for your item?");
		if(yesNo == 'N')
		{
			notes.add("");
		}
			else
			{
				sauceChoice();
				My.p("\n\nSauce or further requirement : ");
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

	public static int quantity() 
	{
		quantity = MyVal.validInt("Enter quantity : ");
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
		System.out.println("\n\nAvailability Main Menu");
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
		
			My.p("\n--Removed "+ hotFoodArray.get(option-1) + "--");
	    	hotFoodArray.remove(option-1);
	    	hotFoodPrice.remove(option-1);
	    	hotFoodMeal.remove(option-1);
	    	
	    	stockUpdateHot();
	    	break;
	 
	    case 2:
	    	printHotFood();
		
			newPrice = MyVal.validDouble("Enter the new price", newPrice);
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
	
	static double totalPrice(List<Double> list) // Total price method that calculates the total sum of the priceBasket
	{
	    double sum = 0; // Variable
	    for (double i: list) { //For each index in the list, loops to the size of the subTotal
	        sum += i; //Add the sum of the index to the sum
	    }
	    return sum; //Final result, our total, will be returned
	}
	
	static void reciept ()
	{
		System.out.printf("\n%-25s|%-40s|%-15s|%-15s|%-15s", "Item", "Notes", "Price", "Qty", "Subtotal");
		//System.out.printf("\n%-26s%-41s%-16s%-16s%-16s", "----", "-----", "-----", "---", "--------");
		System.out.print("\n************************************************************************************************************");
		
		//Sandwich part print out
		System.out.printf("\n%-25s|%-40s|%-15s|%-15s|£%-15s", "Sandwich", nExtras , "£3.00 + extras", nSand , sandwichPriceBasket);
		
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
	
	static void admin() /*Admin method will be used to identify a staff member, who can make changes to the system 
						depending on stock levels, and remove items from being displayed accordingly. 
						Of course, the staff member can also order, with their discount rate automatically applied*/
	{
		String staff_1 = "jmcelwee";
		String staff_2 = "treety";
		String login = "";	
		
		if (count == 3)
		{
			My.p("\n\nYou have entered in the wrong sign in details too many times. Returning to main menu...");
			try{
			    Thread.sleep(3000);//3000ms = 2s
			}catch(InterruptedException ex){
			}
			mainMenu();
		}
		else 
		{
			Scanner key = new Scanner (System.in);
			My.pl("\nPlease enter your sign-in ID");
			login = key.nextLine();
			
			if (login.equals(staff_1)| login.equals(staff_2))
			{
				My.pl("\nWelcome member. Remeber you get an automatic 10% discount on your order");
				staff = login;
				mainMenu();
			}
			else
			{
				count++;
				My.p("\nIncorrect sign in details!");
				admin();
			}
		}
	}
	

	//Treetys Code
	static void sandwich()
	{
		double sandwichPriceBasket = 0.0;
		int nSand = 0, nCont = 0, nExtras = 0;	
		int breadChoice = 0, spreadChoice = 0, meatChoice = 0, xmeatChoice = 0, saladChoice = 0, sauceChoice = 0;
		char checkOut, extrasM, extrasS, anySalad;
					
		do
		  {
			
			//Printing the Bread choices and input choice
			printBreadMenu();
			breadChoice = MyVal.validIntRange("Please enter the bread type: ", 1, 8);
			
			//Adding to the sandwichContent ArrayList
			My.p("\tThe bread type is " + bread.get(breadChoice - 1));
			sandwichContent.add(bread.get(breadChoice - 1));
			nCont ++;
			
			//Printing the Spread choices and input choice
			printSpreadMenu();
			spreadChoice = MyVal.validIntRange("Please enter the spread type: ", 1, 2);
			//Adding to the sandwichContent ArrayList
			My.p("\tThe spread chosen is " + spread.get(spreadChoice - 1));
			sandwichContent.add(spread.get(spreadChoice - 1));
			nCont ++;
			
			//Printing the Meat choices and input choice
			printMeatMenu();
			meatChoice = MyVal.validIntRange("Please enter the meat choice: ", 1, 10);	
			My.p("\tThe meat chosen is " + meat.get(meatChoice - 1));
			sandwichContent.add(meat.get(meatChoice - 1));
			nCont ++;
			
			//Giving the option of any extra meat.
			extrasM = MyVal.validYN("\n\tWould you like any extras: ");
			
			while (Character.toUpperCase(extrasM) == 'Y')
				{
					//Printing the Meat choices and input choice
					printMeatMenu();
					xmeatChoice = MyVal.validIntRange("Please enter the meat choice: ", 1, 10);	
				
					//Adding the extra meat choice to the sandwich content basket.
					My.p("\tThe extra meat chosen is " + meat.get(xmeatChoice - 1));
					sandwichExtraContent.add(meat.get(xmeatChoice - 1));
					nExtras ++;
					
					//Adding 60 pence to the basket sandwich price when the extra meat is chosen.
					sandwichExtraPriceBasket.add(0.60);
						
					//Adding 60 pence to the total sandwich bill when the extra meat is chosen.
					sandwichPriceBasket += 0.60;
					
					//Giving the option of extra meat, again.
					extrasM = MyVal.validYN("\n\tWould you like any extras: ");
				}
			
		
			//Giving the option of any salad at all.
			anySalad = MyVal.validYN("\tWould you like any salad:");
	
			if (Character.toUpperCase(anySalad) == 'Y')
				{
					//Printing the Salad choices and input choice
					printSaladMenu();
			
					//Giving the option of choosing the first salad.
					saladChoice = MyVal.validIntRange("Please enter the salad choice: ", 1, 12);
			
					//Adding the first salad choice to the sandwich content basket.
					My.p("\tThe salad chosen is " + salad.get(saladChoice - 1));
					sandwichContent.add(salad.get(saladChoice - 1));
					nCont ++;
					
					//Giving the option of the second salad.
					anySalad = MyVal.validYN("\n\tWould you like any more salad:");

					if (Character.toUpperCase(anySalad) == 'Y')
					{
						//Printing the Salad choices and input choice
						printSaladMenu();
			
						//Giving the option of choosing the second salad.
						saladChoice = MyVal.validIntRange("Please enter the salad choice: ", 1, 12);
						
						//Adding the second salad choice to the sandwich content basket.
						My.p("\tThe second salad chosen is " + salad.get(saladChoice - 1));
						sandwichContent.add(salad.get(saladChoice - 1));
						
						//Adding to the number of Sandwich content
						nCont ++;
						
						//Giving the option of extra salad.
						extrasS = MyVal.validYN("\n\tWould you like any extra salad:");

						while (Character.toUpperCase(extrasS) == 'Y')
							{
								//Printing the Salad choices and input choice
								printSaladMenu();

								//Giving the option of choosing extra salad.
								saladChoice = MyVal.validIntRange("Please enter the salad choice: ", 1, 12);
								My.p("\tThe salad chosen is " + salad.get(saladChoice - 1));
								sandwichExtraContent.add(salad.get(saladChoice - 1));
								
								//Adding to the number of Sandwich content and extras.
								nExtras ++;
								
								//Adding 35 pence to the Sandwich Extra Price Basket when the extra salad is chosen.
								sandwichExtraPriceBasket.add(0.35);
								
								//Adding 35 pence to the total sandwich bill when the extra salad is chosen.
								sandwichPriceBasket += 0.35;
								
								
								//Giving the option of any extra salad.
								extrasS = MyVal.validYN("\n\tWould you like any extras: ");
							} 	
						
						//Printing the Sauce choices and input choice
						printSauceMenu();
						
						sauceChoice = MyVal.validIntRange("Please the choice of sauce: ", 1, 5); 
							
						//Adding the chosen sauce to the sandwichContent ArrayList
						My.p("\tThe sauce chosen is " + sauce.get(sauceChoice - 1));
						sandwichContent.add(sauce.get(sauceChoice - 1));
						
						//Adding to the number of Sandwich content and extras
						nCont ++;
						} 	
					else
						{
							//Printing the Sauce choices and input choice
							printSauceMenu();
							
							sauceChoice = MyVal.validIntRange("Please the choice of sauce: ", 1, 5); 
								
							//Adding the chosen sauce to the sandwichContent ArrayList
							My.p("\tThe sauce chosen is " + sauce.get(sauceChoice - 1));
							sandwichContent.add(sauce.get(sauceChoice - 1));
							
							//Adding to the number of Sandwich content and extras
							nCont ++;
						}
				}
			else
				{
					//Printing the Sauce choices and input choice
					printSauceMenu();
					
					sauceChoice = MyVal.validIntRange("Please the choice of sauce: ", 1, 5); 
						
					//Adding the chosen sauce to the sandwichContent ArrayList
					My.p("\tThe sauce chosen is " + sauce.get(sauceChoice - 1));
					sandwichContent.add(sauce.get(sauceChoice - 1));
					nCont ++;
				}
			
			checkOut = MyVal.validYN("\n\tWould you like to go to the check out: ");
			
			//adding to the number Of Sandwich.
			nSand ++;
			
			//£3.00 is added to the basket sandwich price and also the total when a sandwich is chosen. 
			sandwichPriceBasket += 3.00;
			
			quantity = quantity();
			qtyTotal(quantity, sandwichPriceBasket );
			
		 } while (Character.toUpperCase(checkOut) == 'N');	
		
		My.p("\n**********************************************************************************");
		System.out.printf("\n*%-16s %63s", " Full lunch order", "*");
		
		My.p("\n**********************************************************************************");
		System.out.print("\n* Preview of Sandwich content and extras \t\t\t\t\t *"); 
		My.p("\n**********************************************************************************");
		System.out.printf("\n%-25s |%-15s %-18s %-15s %-20s", "* Sandwich Content", "Extras", "|Price", "|Subtotal", "   *");
		My.p("\n**********************************************************************************");
    
		//For Loop for each sandwich content and price.
		for (int j = 0; j < nCont; j++)
			{	
				//Printing sandwich content.
				System.out.printf("\n%-25s %-16s %-18s %-18s %-15s", sandwichContent.get(j), "|", "|", "|", "|");
			}
		
		for (int k = 0; k < nExtras; k++)
	        {
	        	//Printing the Sandwich Extra Content and prices as double numbers.
	        	System.out.printf("\n%27s %-15s|%-17.2f %-18s %-18s", "|", sandwichExtraContent.get(k), sandwichExtraPriceBasket.get(k),"|","|");
	        }
		
		//Printing the total price for each sandwich.
		My.p("\n**********************************************************************************");
		//My.p("\nThe total price for sandwich No " + (i+1) + " £" + sandwichPriceBasket);

		My.p("\nThe total sandwich bill: £" + sandwichPriceBasket);
		
		yesNo = MyVal.validYN("\nReturn to sandwich selection (Y), or home (N)?");

		if (yesNo == 'N')
		{
		 mainMenu();
		}
		else if (yesNo == 'Y')
		{
		sandwich();
		}
	}
	
	public static Void printBreadMenu() 
	{
		//The bread type are stored as an Array list of String.
		ArrayList<String> bread = new ArrayList<String>();  
		bread.add("White");
		bread.add("Brown");
		bread.add("Granary");
		bread.add("White Roll");
		bread.add("Brown Roll");
		bread.add("White Wrap");
		bread.add("Brown Wrap");
		bread.add("Gluten Free Roll");
		
		//Printing the Bread choices and input choice
		My.p("\n\t--------------------------------------------");
		My.p(String.format("\n\t|   %-18s %21s ", "Bread choices", "|"));
		My.p("\n\t--------------------------------------------");
		My.p(String.format("\n\t|1. %-16s %1s 5. %6s %7s", bread.get(0), "|", bread.get(4), "|"));
		My.p(String.format("\n\t|2. %-16s %1s 6. %6s %7s", bread.get(1), "|", bread.get(5), "|"));
		My.p(String.format("\n\t|3. %-16s %1s 7. %5s %7s", bread.get(2), "|", bread.get(6), "|"));
		My.p(String.format("\n\t|4. %-16s %1s 8. %2s %1s", bread.get(3), "|", bread.get(7), "|"));
		My.p("\n\t--------------------------------------------");
		
		return null;
	}
	
	public static Void printSpreadMenu()
	{
		//The spread choice are stored as an Array List of String.
		ArrayList<String> spread = new ArrayList<String>();  
		spread.add("Butter");
		spread.add("Mayonnaise");
		
		//Printing the Spread choices and input choice
		My.p("\n\t----------------------------------------------");
		My.p(String.format("\n\t|   %-18s %23s ", "Spread choices", "|"));
		My.p("\n\t----------------------------------------------");
		My.p(String.format("\n\t|1. %-16s %2s 2. %5s %9s", spread.get(0), "|", spread.get(1), "|"));
		My.p("\n\t----------------------------------------------");
		return null;
	}
	
	public static Void printMeatMenu() 
	{
		//The meat choice are stored as an Array List of String.
		ArrayList<String> meat = new ArrayList<String>();  
		meat.add("Grilled Chicken");
		meat.add("Breaded Chicken");
		meat.add("Ham");
		meat.add("Peperoni");
		meat.add("Turkey");
		meat.add("Steak");
		meat.add("Tuna");
		meat.add("Chicken supreme");	
		meat.add("Taco Chicken");
		meat.add("Chicken Tikka");	
				
		//Printing the Meat choices and input choice
		My.p("\n\t----------------------------------------------");
		My.p(String.format("\n\t|   %-18s %23s ", "Meat choices", "|"));
		My.p("\n\t----------------------------------------------");
		My.p(String.format("\n\t|1. %-16s %2s 6. %5s %13s", meat.get(0), "|", meat.get(5), "|"));
		My.p(String.format("\n\t|2. %-16s %2s 7. %4s %14s", meat.get(1), "|", meat.get(6), "|"));
		My.p(String.format("\n\t|3. %-16s %2s 8. %9s %3s", meat.get(2), "|", meat.get(7), "|"));
		My.p(String.format("\n\t|4. %-16s %2s 9. %9s %6s", meat.get(3), "|", meat.get(8), "|"));
		My.p(String.format("\n\t|5. %-16s %2s 10. %6s %4s", meat.get(4), "|", meat.get(9), "|"));
		My.p("\n\t----------------------------------------------");
		return null;
	}
	
	public static Void printSaladMenu() 
	{
		//The meat choice are stored as an Array List of String.
		ArrayList<String> salad = new ArrayList<String>();  
		salad.add("Lettuce");
		salad.add("Tomato");
		salad.add("Onions");
		salad.add("Peppers");
		salad.add("Cucumber");
		salad.add("Sweetcorn");
		salad.add("Cheese");
		salad.add("Pickles");	
		salad.add("Rice");
		salad.add("Egg");	
		salad.add("Spinach");
		salad.add("Coleslaw");
		
		//The meat choice are stored as an Array List of String.
		My.p("\n\t--------------------------------------------");
		My.p(String.format("\n\t|   %-18s %21s ", "Salad choices", "|"));
		My.p("\n\t--------------------------------------------");
		My.p(String.format("\n\t|1. %-16s %2s 7. %7s %9s", salad.get(0), "|", salad.get(6), "|"));
		My.p(String.format("\n\t|2. %-16s %2s 8. %8s %8s", salad.get(1), "|", salad.get(7), "|"));
		My.p(String.format("\n\t|3. %-16s %2s 9. %5s %11s", salad.get(2), "|", salad.get(8), "|"));
		My.p(String.format("\n\t|4. %-16s %2s 10. %3s %12s", salad.get(3), "|", salad.get(9), "|"));
		My.p(String.format("\n\t|5. %-16s %2s 11. %5s %8s", salad.get(4), "|", salad.get(10), "|"));
		My.p(String.format("\n\t|6. %-16s %2s 12. %5s %7s", salad.get(5), "|", salad.get(11), "|"));
		My.p("\n\t--------------------------------------------");
		return null;
	}
	
	public static Void printSauceMenu() 
	{
		//The bread type are stored as an Array List of String.
		ArrayList<String> sauce = new ArrayList<String>();  
		sauce.add("Mayo");
		sauce.add("Taco");
		sauce.add("BBQ");
		sauce.add("Ketchup");
		sauce.add("HP Brown Sauce");
		
		//Printing the Sauce choices and input choice
		My.p("\n\t-----------------------");
		My.p(String.format("\n\t| %-18s %-15s ", "Sauce choices", "|"));
		My.p("\n\t-----------------------");
		My.p(String.format("\n\t|1. %-16s %2s", sauce.get(0), "|"));
		My.p(String.format("\n\t|2. %-16s %2s", sauce.get(1), "|"));
		My.p(String.format("\n\t|3. %-16s %2s", sauce.get(2), "|"));
		My.p(String.format("\n\t|4. %-16s %2s", sauce.get(3), "|"));
		My.p(String.format("\n\t|5. %-16s %2s", sauce.get(4), "|"));
		My.p("\n\t-----------------------");
		return null;
	}
}



