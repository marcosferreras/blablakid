package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day{
	private WeekDays weekDay;
	private Rides rides;
	private static final Logger logger= LogManager.getLogger(Day.class);
	
	public Day(int numberRides,int numberDay)  throws BlaException {
		setWeekDay(numberDay);
		rides = new Rides(numberRides);
		logger.info("A day "+weekDay+" was created");
	}
	
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
	
	public WeekDays getWeekDay() {
		return this.weekDay;
	}
	
	public void add(Ride ride)throws BlaException {
		this.rides.add(ride);
	}
	
	public Ride remove(String start, String end)throws BlaException{
		Ride ride=this.rides.search(start,end);
		this.rides.remove(start, end);
		return ride;
	}
	
	public boolean remove(Ride ride) {
		return this.rides.remove(ride);
	}
	
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
