package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Mario Alverez Iglesias
 *
 */
public class Parent{
	
	private String name;
	private Week week;
	private Kids kids;
	private static final Logger logger= LogManager.getLogger(Parent.class);
	
	/**
	 * Constructor
	 * @param name A name of the parent of type String
	 * @param numberRides the numberRides that the parent can make per day of type int
	 * @param numberKids the numberKids that the parent has of type int
	 * @throws If the number of kids is less or equal than 0
	 * @throws If the number of rides is less or equal than 0
	 */
	public Parent(String name,int numberRides, int numberKids) throws BlaException {
		if (numberRides<=0) {
			logger.error("Error: the number of rides must be greater than 0");
			throw new BlaException("Error: the number of rides must be greater than 0");
		}
		if (numberKids<=0) {
			logger.error("Error: the number of kids must be greater than 0");
			throw new BlaException("Error: the number of kids must be greater than 0");
		}
		this.name=name;
		this.kids = new Kids(numberKids);
		week = new Week(numberRides);
		logger.info("A parent called "+name+" who can made "+numberRides+" rides per day and with "+numberKids+" was created");
	}
	/**
	 * Add a kid
	 * @param kid An object of type Kid to add
	 */
	public void add(Kid kid) throws BlaException {
		this.kids.add(kid);
		logger.info("A kid called "+kid.getName()+" was added to the parent called "+this.name);
	}
	/**
	 * Find a kid
	 * @param name The name of the kid of type String
	 * @return A boolean which is true if the kid is inside Kids
	 */
	public boolean find(String name) {
		boolean output=false;
		if (null!=this.kids.search(name)) {
			output=true;
		}
		return output;
	}
	
	/**
	 * Add a ride
	 * @param day An object of type WeekDays to add the ride in that day
	 * @param ride An object of type Ride to add it
	 * @throws If the ride has already exist
	 */
	public void add(WeekDays day, Ride ride) throws BlaException{
		this.week.add(day,ride);
	}
	
	/**
	 * Remove a ride
	 * @param day An object of type WeekDays to add the ride in that day
	 * @param start A start place of type String
	 * @param end A end place of type String
	 * @throws If the ride has not exist
	 * @return The object ride before been remove
	 */
	public Ride remove(WeekDays day, String start, String end) throws BlaException{
		return this.week.remove(day,start,end);
	}
	
	/**
	 * Remove a Ride
	 * @param ride An object of type Rides
	 * @return A boolean which is true if the ride was remove
	 */
	public boolean remove(Ride ride) {
		return this.week.remove(ride);
	}
	
	/**
	 * Remove a kid of this.Kids
	 * @param name A name of the kid to remove of type String
	 * @throws BlaException If the kid does not exist
	 */
	public void remove(String name) throws BlaException {
		this.kids.remove(name);
	}
	
	/**
	 * @return A name of the parent of type String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ToString of the class
	 * @return the information of the class in a String
	 */
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("\n##### "+this.name+" #####\n");
		output.append("Kids:\n");
		output.append(kids.nameOfKids()+"\n");
		output.append(week.toString());
		return output.toString();
	}
}