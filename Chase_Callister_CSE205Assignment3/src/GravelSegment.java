/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */
public class GravelSegment extends RoadSegment
{

	double modifier;
	int length;
	static final double MIN_MOD = 0.3, MAX_MOD = 0.6;

	public GravelSegment()
	{
		this.modifier = getGravelModifier();
		this.length = generateLength();
	}
	
	@Override
	public RoadSegment generateNeighbor()
	{		
		double dieRoll = Math.random();
		if(dieRoll < .05)
			return new AsphaltSegment();
		else if(dieRoll < .1)
			return new CrumbledSegment();
		else if(dieRoll < .25)
			return new DirtSegment();
		else
			return new GravelSegment();		
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
	
	private static double  getGravelModifier()
	{
		double temp = Math.random();
		while (temp < MIN_MOD || temp > MAX_MOD)
		{
			temp = Math.random();
		}				
		return temp;		
	}
	
	@Override 
	public String toString()
	{
		return "G: " + this.length;
	}

	@Override
	public String getString()
	{
		return "Gravel";
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
