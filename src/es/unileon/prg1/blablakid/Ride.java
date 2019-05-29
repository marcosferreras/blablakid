package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ride{
	
	private Time timeStart;
	private Time timeEnd;
	private String startPlace;
	private String endPlace;
	private static final Logger logger= LogManager.getLogger(Ride.class);
	
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

	public Time getTimeStart() {
		return timeStart;
	}
	public String getStartPlace() {
		return this.startPlace;
	}
	public String getEndPlace() {
		return this.endPlace;
	}

	public Time getTimeEnd() {
		return timeEnd;
	}

	public String toString() {
		return ("\n"+this.startPlace+" > "+this.endPlace+" : "+timeStart.toString()+" / "+ timeEnd.toString());
	}
	public boolean isSame(String start,String end) {
		boolean exit=false;
		if (this.startPlace.toLowerCase()==start.toLowerCase() && this.endPlace.toLowerCase()==end.toLowerCase()) exit=true;
		return exit;
	}
}
