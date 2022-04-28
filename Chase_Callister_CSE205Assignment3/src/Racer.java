/*
 * Name: Chase Callister
 * Assignment#3
 * Time Taken: 36 hours
 */
public abstract class Racer
{
     protected int carNumber;
     protected double speed;
     protected double currentProgress;
     protected String carType;
     protected String carInfo;
     protected int position;
     
     public abstract int getCarNumber();
     public abstract double getSpeed();
     public abstract double getCurrentProgress();     
     public abstract void resetProgress();
     public abstract double generateCarSpeed();     
     public abstract void makeProgress(double modifier);    
     public abstract void setNumber(int num);
     public abstract int getPosition();
     public abstract void setPosition();

     
     

}
