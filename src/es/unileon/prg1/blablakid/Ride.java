package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 
 * @author Mario Alvarez Iglesias
 *
 */
public class Ride{
	
	private Time start;
	private Time end;
	private String startPlace;
	private String endPlace;
	private static final Logger logger= LogManager.getLogger(Ride.class);
	
	/**
	 * Costructor of the class ride
	 * @param start An object of type Time of the start of the ride
	 * @param end An object of type Time of the end of the ride
	 * @param startPlace String
	 * @param endPlace String
	 * @throws if start>end
	 */
	public Ride(Time start, Time end, String startPlace, String endPlace ) throws BlaException{
		if(!start.isBefore(end)) {
			logger.error("Error:Please change the order of the hours");
			throw new BlaException("Error:Please change the order of the hours");
		}
		this.start=start;
		this.end=end;
		this.startPlace=startPlace;
		this.endPlace = endPlace;
		logger.info("A ride object from "+startPlace+" at "+start.toString()+" to "+endPlace+" at "+end.toString());
	}

	/**
	 * @return A object time of the start of the ride
	 */
	public Time getTimeStart() {
		return start;
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
		return end;
	}
	
	/**
	 * ToString of the class
	 * @return All the information of the class
	 */
	@Override
	public String toString() {
		return ("\n"+this.startPlace+" > "+this.endPlace+" : "+start.toString()+" / "+ end.toString());
	}
	
	/**
	 * Compare two rides
	 * @param start A start place of type String
	 * @param end An end place of type String
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
