/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */
public class StreetRacer extends Racer
{

	static final double MIN_MOD = 5.5, MAX_MOD = 7.0;

	public StreetRacer(int num)
	{
		
		this.speed = generateCarSpeed();
		this.carType = "Street Racer";
		this.carNumber = num;
		this.position = 0;
	}

	@Override
	public int getCarNumber()
	{
		return this.carNumber;
	}

	@Override
	public double getSpeed()
	{
		return this.speed;
	}

	@Override
	public double getCurrentProgress()
	{
		return this.currentProgress;
	}

	@Override
	public void makeProgress(double modifier)
	{
		this.currentProgress += (speed * modifier) + 0.5;		
	}
	
	@Override
	public double generateCarSpeed()
	{		
		double temp = Math.random();
		while (temp < MIN_MOD || temp > MAX_MOD)
		{
			temp = Math.random() * 10;
		}			
		return temp;
	}

	@Override
	public void resetProgress()
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public String toString()
	{
		this.carInfo = ("Racer #" + this.carNumber + " " + this.carType + " - " + (int)(this.currentProgress) + " units");
		return this.carInfo;
	}

	@Override
	public void setNumber(int num)
	{
		this.carNumber = num;		
	}

	@Override
	public int getPosition()
	{
		return this.position;
	}

	@Override
	public void setPosition()
	{
		this.position++;		
	}
}
