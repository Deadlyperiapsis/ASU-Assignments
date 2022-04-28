/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */
public class CrumbledSegment extends RoadSegment
{

	double modifier;
	int length;
	static final double MIN_MOD = 0.6, MAX_MOD = 0.8;

	public CrumbledSegment()
	{
		this.modifier = getCrumbledModifier();
		this.length = generateLength();
	}
	
	@Override
	public RoadSegment generateNeighbor()
	{
		
		double dieRoll = Math.random();
		if(dieRoll < .1)
			return new DirtSegment();
		else if(dieRoll < .35)
			return new AsphaltSegment();
		else if(dieRoll < .60)
			return new GravelSegment();
		else
			return new CrumbledSegment();		
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
	
	private static double getCrumbledModifier()
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
		return "C: " + this.length;
	}

	@Override
	public String getString()
	{
		return "Crumbled";
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
