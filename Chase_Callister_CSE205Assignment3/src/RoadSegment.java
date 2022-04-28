/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */
public abstract class RoadSegment
{
     protected int length;
     protected double modifier;
     public RoadSegment[] raceTrack;
     public abstract RoadSegment generateNeighbor();
     public abstract int getLength();
     public abstract double getModifier();
     public abstract String getString();
     public abstract int generateLength();


}
