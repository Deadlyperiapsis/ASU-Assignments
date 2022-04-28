/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */
public class ToughRacer extends Racer
{
	static final double MIN_MOD = 2.0, MAX_MOD = 3.0;

	public ToughRacer(int num)
	{
		
		this.speed = generateCarSpeed();
		this.carType = "Steady Racer";
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
		double bonusSpeed = 5 * (1.0 - modifier);
		this.currentProgress += this.speed + bonusSpeed;		
	}
	
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
		this.currentProgress = 0.0;
		
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
