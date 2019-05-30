package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Mario Alverez Iglesias
 *
 */

public class Day{
	private WeekDays weekDay;
	private Rides rides;
	private static final Logger logger= LogManager.getLogger(Day.class);
	
	/**
	 * Costructor of the class day and creates an object of type rides
	 * @param numberRides A number of rides that the parent make per day
	 * @param numberDay A number of the day 0-4 of type int
	 * @throws If the number of day is greater than 4 or less than 0
	 */
	public Day(int numberRides,int numberDay)  throws BlaException {
		setWeekDay(numberDay);
		rides = new Rides(numberRides);
		logger.info("A day "+weekDay+" was created");
	}
	
	/**
	 * Set the WeekDays class
	 * @param number A number of the week from0 to 4
	 * @throws If the number of day is greater than 4 or less than 0
	 */
	public void setWeekDay(int number) throws BlaException{
		switch(number){
			case 0:
				this.weekDay = WeekDays.MONDAY;
			break;
			case 1:
				this.weekDay = WeekDays.TUESDAY;
			break;
			case 2:
				this.weekDay = WeekDays.WEDNESDAY;
			break;
			case 3:
				this.weekDay = WeekDays.THURSDAY;
			break;
			case 4:
				this.weekDay = WeekDays.FRIDAY;
			break;
			default:
				logger.error("Error:That day does not a correct number for the week day");
				throw new BlaException ("Error:That day does not a correct number for the week day");
				
		}
	}
	/**
	 * @return A WeekDays object
	 */
	public WeekDays getWeekDay() {
		return this.weekDay;
	}
	
	/**
	 * Add a ride to rides
	 * @param ride An object of type ride
	 * @throws BlaException
	 */
	public void add(Ride ride)throws BlaException {
		this.rides.add(ride);
	}
	
	/**
	 * Remove a ride
	 * @param start A start place of type String
	 * @param end An end place of type String
	 * @return the ride before be remove
	 * @throws If the ride has not exist
	 */
	public Ride remove(String start, String end)throws BlaException{
		Ride ride=this.rides.search(start,end);
		this.rides.remove(start, end);
		return ride;
	}
	/**
	 * Remove a ride
	 * @param ride A Ride object which will be remove
	 * @return A boolean in true if the ride was removed
	 */
	public boolean remove(Ride ride) {
		return this.rides.remove(ride);
	}
	/**
	 * ToString of the class
	 * @return the information of the class in a String if rides have at least 1 ride
	 */
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("");
		if (this.rides.haveInformation()) {
			output.append("\n"+weekDay+" rides:");
			output.append(this.rides.toString());
		}
		return output.toString();
	}
}
