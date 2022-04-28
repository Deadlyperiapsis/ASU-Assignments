/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */
public class AsphaltSegment extends RoadSegment
{
	
	double modifier;
	int length;

	public AsphaltSegment()
	{
		this.modifier = 1.0;
		this.length = generateLength();
	}
	
	@Override
	public RoadSegment generateNeighbor()
	{
		double dieRoll = Math.random();
		if(dieRoll < .05)
			return new DirtSegment();
		else if(dieRoll < .15)
			return new GravelSegment();
		else if(dieRoll < .4)
			return new CrumbledSegment();
		else
			return new AsphaltSegment();		
	}

	@Override
	public int getLength()
	{
		return this.length;
	}

	@Override
	public double getModifier()
	{
		return this.modifier;
	}
	
	@Override 
	public String toString()
	{
		return "A: " + this.length;
	}

	@Override
	public String getString()
	{
		
		return "Asphalt";
	}
	
	@Override
	public int generateLength()
	{
		int num = 0;
		while (num < 10 || num > 25)
		{
			num = (int) (Math.random() * 25);
		}
		return num;
	}
	
	

}
