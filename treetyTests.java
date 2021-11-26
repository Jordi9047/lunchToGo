package Assignment;

import java.util.Scanner;
import java.util.ArrayList;
import general.*;

public class treetyTests
{
	public static void main(String[] args) 
	{
	
		ArrayList<String> breads = new ArrayList(10);  
	
		breads.add("(1)White");
		breads.add("(2)Brown");
		breads.add("(3)Granary");
		breads.add("(4)White");
		breads.add("(5)White");
		breads.add("(6)White");
		
		Scanner key = new Scanner(System.in);
		
		String[] food = {"Sandwich", "Salad", "Hot food"};
		
		String[] spread = {"Butter", "Mayonnaise"};
		
		ArrayList<int[]> breadtype = new ArrayList<int[]>();
		
		int breadchoice = 0, spreadchoice = 0, meatchoice = 0, saladchoice = 0, saucechoice = 0;
		
		char checkout, extras;
		
		do
		{
			do
				{
				
				System.out.print(breads);
				My.p("\n\n\tPlease the choice of bread number: ");
				breadchoice = key.nextInt();
				My.p("\n\n\tPlease the choice of spread number: ");
				spreadchoice = key.nextInt();
				My.p("\n\n\tPlease the choice of meat number: ");
				meatchoice = key.nextInt();
				My.p("\n\n\tPlease the choice of salad number: ");
				saladchoice = key.nextInt();
				My.p("\n\n\tPlease the choice of sauce number: ");
				saucechoice = key.nextInt();
				key.nextLine();
				
		
				My.p("\n\n\tWould you like any extras: ");
				extras = key.nextLine().charAt(0);
				
				} while(Character.toUpperCase(extras) == 'Y');
				
			My.p("\n\n\tWould you like to go to the check out: ");
			checkout = key.nextLine().charAt(0);
			
			
		} while (Character.toUpperCase(checkout) == 'N');
		

	}

}
