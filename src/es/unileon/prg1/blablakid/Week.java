package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Mario Alverez Iglesias
 *
 */

public class Week{
	
	private Day []day;
	private static final Logger logger= LogManager.getLogger(Week.class);
	
	/**
	 * Constructor of week and create the days
	 * @param A number of rides per day of type int
	 */
	public Week(int number)  throws BlaException{
		day = new Day[5];
		for (int i=0;i<5;i++) {
			this.day[i] = new Day(number,i);
		}
		logger.info("A week was created for the parent");
	}
	
	/**
	 * Add a ride
	 * @param An object of type WeekDays to add the ride in that day
	 * @param An object of type Ride to add it
	 * @throws If the ride has already exist
	 */
	public void add(WeekDays day,Ride ride) throws BlaException{
		this.day[day.ordinal()].add(ride);
	}
	
	/**
	 * Remove a ride
	 * @param An object of type WeekDays to add the ride in that day
	 * @param A start place of type String
	 * @param A end place of type String
	 * @throws If the ride has not exist
	 * @return The object ride before been remove
	 */
	public Ride remove(WeekDays day,String start, String end) throws BlaException{
		return this.day[day.ordinal()].remove(start,end);
	}
	
	/**
	 * Remove a Ride
	 * @param An object of type Rides
	 * @return A boolean which is true if the ride was remove
	 */
	public boolean remove(Ride ride) {
		int number=0;
		boolean out=false;
		while(number<5 && !out) {
			out=this.day[number].remove(ride);
			number++;
		}
		return out;
	}
	
	/**
	 * ToString of the class
	 * @return the information of the class in a String
	 */
	@Override
	public String toString() {
		StringBuffer output=new StringBuffer();
		output.append("\nRIDES:");
		for (int i=0;i<5;i++) {
			output.append(this.day[i].toString());
		}
		return output.toString();
	}
}