/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */
public class DirtSegment extends RoadSegment
{

	double modifier;
	int length;
	static final double MIN_MOD = 0.0, MAX_MOD = 0.3;

	public DirtSegment()
	{
		this.modifier = getDirtModifier();
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
		else if(dieRoll < .4)
			return new GravelSegment();
		else
			return new DirtSegment();		
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
	
	private static double  getDirtModifier()
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
		return "D: " + this.length;
	}

	@Override
	public String getString()
	{
		return "Dirt";
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
