package general;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyVal 
{
	static Scanner key = new Scanner (System.in);
	
	public static int validInt(String msg, int num)
	{
		boolean ok = true;
		
		do
		{
			try
			{
				ok = true;
				My.pl("\n\t" + msg );
				num = key.nextInt();
				key.nextLine();
				
			}
			catch (InputMismatchException e)
			{
				My.p("\n\tError: Illegal character(s) in input. Please re-enter.");
				key.nextLine();
				ok = false;
			}
		}while (!ok);
		
		return num;
		}
	
	public static int validIntRange(String msg, int min, int max)
		{
			int num = 0;
			boolean ok = true;
			
			do
			{
				try
				{
					ok = true;
					My.pl("\n\t" + msg );
					num = key.nextInt();
					key.nextLine();
					
					if (num<min || num > max)
					{
						ok = false;
						My.pl(String.format("\n\tError: Range is %2d - %2d. Please re-enter.", min , max));
					}
				}
				catch (InputMismatchException e)
				{
					My.pl("\n\tError: Illegal character(s) in input. Please re-enter.");
					key.nextLine();
					ok = false;
				}
			}while (!ok);
			
			return num;
			}
		
	
	public static int validIntRangeArrayList(String msg, int min, int i)
	{
		int num = 0;
		boolean ok = true;
		
		do
		{
			try
			{
				ok = true;
				My.pl("\n\t" + msg );
				num = key.nextInt();
				key.nextLine();
				
				if (num<min || num > i)
				{
					ok = false;
					My.pl(String.format("\n\tError: Range is %2d - %2d. Please re-enter.", min , i));
				}
			}
			catch (InputMismatchException e)
			{
				My.pl("\n\tError: Illegal character(s) in input. Please re-enter.");
				key.nextLine();
				ok = false;
			}
		}while (!ok);
		
		return num;
		}
	
	
	public static double validDouble(String msg, double x)
		{
			double num = 0;
			boolean ok = true;
			
			do
			{
				try
				{
					ok = true;
					My.p("\n\t" + msg );
					num = key.nextDouble();
					key.nextLine();
					
				}
				catch (InputMismatchException e)
				{
					My.p("\n\tError: Illegal character(s) in input. Please re-enter.");
					key.nextLine();
					ok = false;
				}
			}while (!ok);
			
			return num;
			}
		
	public static double validDoubleRange(String msg, double min, double max)

		{
			double num = 0;
			boolean ok = true;
			
			do
			{
				try
				{
					ok = true;
					My.p("\n\t" + msg );
					num = key.nextDouble();
					key.nextLine();
					
					if (num<min || num > max)
					{
						ok = false;
						My.p(String.format("\n\tError: Range is %2d - %2d. Please re-enter.", min , max));
					}
				}
				catch (InputMismatchException e)
				{
					My.p("\n\tError: Illegal character(s) in input. Please re-enter.");
					key.nextLine();
					ok = false;
				}
			}while (!ok);
			
			return num;
			}

	public static int validInt(String msg) 

	{
		int num = 0;
		boolean ok = true;
		
		do
		{
			try
			{
				ok = true;
				My.p("\n" + msg);
				num = key.nextInt();
				key.nextLine();
				
			}
			catch (InputMismatchException e)
			{
				My.p("\n\tError: Illegal character(s) in input. Please re-enter.");
				key.nextLine();
				ok = false;
			}
		}while (!ok);
		
		return num;
		}
		
	public static char validYN(String s)
	{
		char ch = ' ';
		boolean ok;
		String temp = "";
		
		do
		{
			try
			{
				ok = true;
				My.pl(s);
				My.pl("\n(Y) Yes / (N) No");
				temp = key.nextLine();
				temp = temp.toUpperCase();
				ch = temp.charAt(0);
				
				if(ch !='Y' && ch !='N')
				{
					ok = false;
					My.pl(String.format("\n\tError: Input must be either Y or N.  Please re-enter."));
				}
			}
			
			catch (InputMismatchException e)
			{
				My.pl("\n\tError:  Illegal character(s) in input - Please re-enter.");	
				key.nextLine();
				ok = false;
			}
		
		}while(!ok);
		
		return ch;
	}

	public static double validDouble(String s)
	{
		double num = 0.0;
		boolean ok;
		
		do
		{
			try
			{
				ok = true;
				My.p(s);
				num = key.nextDouble(); 
				key.nextLine();
			}
			
			catch (InputMismatchException e)
			{
				My.p("\n\tError:  Illegal character(s) in input - Please re-enter.");	
				key.nextLine();
				ok = false;
			}
		
		}while(!ok);
		
		return num;
	}
}