/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Race
{
	private Scanner in = new Scanner(System.in);
	private RoadSegment[] raceTrack;	
	private int trackLength, amountOfCars = 8;
	private Racer[] raceCars = new Racer[amountOfCars];
	private boolean choice = false;
	private int update = 0;


	public void run()
	{
		
		displayStartMenu();
		
	}

	/*
	 * Displays options to user
	 */
	private void displayStartMenu()
	{
		
		System.out.println("Menu Displayed");
		do
		{
			System.out.println("Welcome to Racer Dirby!");
			System.out.println("Would you like to:");
			System.out.println("1 - Determine the length of the race");
			System.out.println("2 - Run a random race");
			System.out.println("9 - Exit");
			determineStartMenuInput(in.next());
		}while(!choice);		
	}

	/*
	 * Determines user input from menu options
	 */
	private void determineStartMenuInput(String str)
	{
		if (str.equals("1"))
		{
			choice = true;
			runCustom();
			
		}
		if (str.equals("2"))
		{
			choice = true;
			runRandom();
						
		}
		if (str.equals("9"))
		{
			choice = true;
			exit();
			
		}
		else
		{
			System.out.println("Please enter valid menu option!");
			choice = false;
		}
	}

	/*
	 * Runs custom race
	 */
	private void runCustom() 
	{
		generateCars();
		setLength();
		generateRaceTrack();
		start();
	}

	/*
	 * The cars actually race in this method
	 */
	private void start() 
	{
		boolean winner = false;
		outputTrack();
		for (int i = 0; !winner || i < 10; i++)
		{

			if (raceCars[i].getPosition() >= raceTrack.length - 1)
			{
				System.out.println("RACECAR #" + i + " IS THE WINNER!"); 
				winner = true;
				exit();
			}
			int position = raceCars[i].getPosition() + 1;
			raceCars[i].makeProgress(raceTrack[position].getModifier());
			System.out.println(raceCars[i].toString() + " into Segment#" + position + " " + raceTrack[position].getString() + " - " + raceTrack[position].getLength() + " units long.");
			if (raceCars[i].getCurrentProgress() >= raceTrack[raceCars[i].getPosition()].getLength())
			{
				raceCars[i].setPosition();
				raceCars[i].resetProgress();
			}
			if (i == raceCars.length - 1)
			{
				i = 0;
				outputDivider();
				try
				{
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

		}
		
	}


	/*
	 * outputs divider
	 */
	private void outputDivider()
	{
		update++;
		System.out.println("###########################################################################");
		System.out.println("Update " + update + "!");
		System.out.println("------------------");
	}

	private void generateCars()
	{
		for (int i = 0; i < raceCars.length; i++)
		{
			float type = (float) Math.random();
			if (type < 0.33)
			{
				raceCars[i] = new StreetRacer(i + 1);
			}
			if (type < 0.66)
			{
				raceCars[i] = new SteadyRacer(i + 1);
			}
			if (type < 1.00)
			{
				raceCars[i] = new ToughRacer(i + 1);
			}
		}
			
	}

	/*
	 * Method to set length of racetrack
	 */
	private void setLength()
	{
		boolean valid = false;
		do
		{
			System.out.println("Enter desired length");
			valid = checkLength(in.next());
		} while (!valid);
		raceTrack = new RoadSegment[trackLength];
		
	}

	/*
	 * This method ensures proper input for racetrack size
	 */
	private boolean checkLength(String str)
	{
		try
		{
			trackLength = Integer.parseInt(str);
		} catch (NumberFormatException e)
		{
			System.out.println("Please enter a valid integer");
			return false;
		}		
		return true;
	}

	/*
	 * runs randomly generated race
	 */
	private void runRandom()
	{
		generateCars();
		raceTrack = new RoadSegment[generateLength()];
		generateRaceTrack();
		start();
	}

	/*
	 * creates racetrack array
	 */
	private void generateRaceTrack()
	{
		generateSegments();		
	}

	private void generateSegments()
	{
		raceTrack[0] = new AsphaltSegment();
		for (int i = 0; i < raceTrack.length - 1; i++)
		{
			raceTrack[i + 1] = raceTrack[i].generateNeighbor();
		}
		
	}

	/*
	 * Helper method for random race
	 */
	private int generateLength()
	{
		int num = 0;
		while (num < 10 || num > 50)
		{
			num = (int) (Math.random() * 50);
		}
		return num;

	}

	/*
	 * exits the program
	 */
	private void exit()
	{
		System.exit(0);		
	}
	
	/*
	 * outputs the layout of the track
	 */
	private void outputTrack()
	{
		for (int i = 0; i < raceTrack.length; i++)
		{
			System.out.print(raceTrack[i].getString() + " " + raceTrack[i].getLength() + " ");
			if (i % 10 == 0 && i > 0)
				System.out.println();
		}
		System.out.println();
		outputDivider();
	}



}
