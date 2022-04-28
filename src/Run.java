/*
 * Name: Chase Callister
 * Assignment: 4
 * Class: CSE 205
 * Description: A data structure designed to solve the Josephus problem.
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Run 
{
	private static int numOfPeople, skip;
	private static Scanner in = new Scanner(System.in);
	private static boolean choice = false;
	private LinkedList listOfPeople;
	private static Node clone;

	/*
	 * Displays menu options to the user
	 */
	public static void main(String[] args) throws InterruptedException 
	{
		String temp;
		
		/*
		 * Menu will continue to display until user enters valid input
		 */
		do
		{
		System.out.println("Welcome to the Josephus Problem");
		System.out.print("How many people in the circle (1 - 100)? ");

		numOfPeople = checkInput(in.next());
		System.out.println();
		
		System.out.print("Enter number of people to skip between iterations: ");
		skip = checkInput(in.next());
		System.out.println();
		
		} while (!choice);		

		LinkedList listOfPeople = new LinkedList(numOfPeople);
		System.out.println("Initial puzzle " + listOfPeople.toString(listOfPeople));
		eliminatePeople(listOfPeople, skip);
		

	}


	/*
	 * Checks input from user as to no crash the program
	 */
	private static int checkInput(String str) 
	{
		for (int i = 0; i < 100; i++)
		{
			
			/*
			 * Ensures user input is a valid integer
			 */
			if (str.equals(Integer.toString(i)))
			{
				if (Integer.parseInt(str) > 0)
				{
					choice = true;
					System.out.println(Integer.parseInt(str));
					return Integer.parseInt(str);
				}
			}
		}
		System.out.println("Please enter a valid input");
		return -1;
		
	}
	
	/*
	 * Eliminates specific nodes from the list based on user provided perameters
	 */
	private static void eliminatePeople(LinkedList list, int rate) throws InterruptedException
	{
		int index = skip + 1;
		boolean contains;
		int peopleLeft = numOfPeople;
		for (int i = 1; i < numOfPeople + 1; i++)
		{
			
			/*
			 * Ensures that the node being deleted is always within the list
			 */
			if (index >= peopleLeft)
			{
				index -= peopleLeft;
				index = Math.abs(index);
			}			
			
			System.out.println("Eliminated #" + list.getData(list, index));
			LinkedList.deleteFirst(list, index);
			System.out.println("Remaining: " + list.toString(list));
			TimeUnit.SECONDS.sleep(1);
			index += skip + 1;
			peopleLeft--;
			
			/*
			 * End conditions for when the prgram has finished with eliminations
			 */
			if (peopleLeft == 1)
			{
				System.out.println("The Survivor is: " + list.toString(list));
				break;
			}
			if (peopleLeft == 0)
			{
				System.out.println("There is no survivor");
				break;
			}

		}
	}
	

}
