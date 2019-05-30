package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 
 * @author Mario Alvarez Iglesias
 *
 */
public class Ride{
	
	private Time timeStart;
	private Time timeEnd;
	private String startPlace;
	private String endPlace;
	private static final Logger logger= LogManager.getLogger(Ride.class);
	
	/**
	 * Costructor of the class ride
	 * @param An object of type Time of the start of the ride
	 * @param An object of type Time of the end of the ride
	 * @param startPlace
	 * @param endPlace
	 * @throws BlaException
	 */
	public Ride(Time timeStart, Time timeEnd, String startPlace, String endPlace ) throws BlaException{
		if(!timeStart.isBefore(timeEnd)) {
			logger.error("Error:Please change the order of the hours");
			throw new BlaException("Error:Please change the order of the hours");
		}
		this.timeStart=timeStart;
		this.timeEnd=timeEnd;
		this.startPlace=startPlace;
		this.endPlace = endPlace;
		logger.info("A ride object from "+startPlace+" at "+timeStart.toString()+" to "+endPlace+" at "+timeEnd.toString());
	}

	/**
	 * @return A object time of the start of the ride
	 */
	public Time getTimeStart() {
		return timeStart;
	}
	
	/**
	 * @return A start place of type String
	 */
	public String getStartPlace() {
		return this.startPlace;
	}
	
	/**
	 * @return A end place of type String
	 */
	public String getEndPlace() {
		return this.endPlace;
	}

	/**
	 * @return A object time of the end of the ride
	 */
	public Time getTimeEnd() {
		return timeEnd;
	}
	
	/**
	 * ToString of the class
	 * @return All the information of the class
	 */
	public String toString() {
		return ("\n"+this.startPlace+" > "+this.endPlace+" : "+timeStart.toString()+" / "+ timeEnd.toString());
	}
	
	/**
	 * Compare two rides
	 * @param A start place of type String
	 * @param An end place of type String
	 * @return a boolean in true if both are equals
	 */
	public boolean isSame(String start,String end) {
		boolean exit=false;
		if (this.startPlace.toLowerCase().equals(start.toLowerCase()) && this.endPlace.toLowerCase().equals(end.toLowerCase())){
			exit=true;
		}
		return exit;
	}
}
