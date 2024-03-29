package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 
 * @author Marcos Ferreras Rodriguez
 * @author Mario Alvarez Iglesias
 *
 */
public class Time{
	
	private int hour;
	private int minute;
	private static final Logger logger= LogManager.getLogger(Kid.class);
	/**
	 * Constructor
	 * @param hour Hour of the time
	 * @param minute Minute of the time
	 * @throws BlaException If the time is incorrect
	 */
	public Time(int hour,int minute) throws BlaException{
		if (hour<0) { 
			logger.error("The hour entered ("+hour+") don't exist");
			throw new BlaException("Error: Negative hours don't exist");
		} else if (hour>24) {
			logger.error("The hour entered ("+hour+") is higher than 23");
			throw new BlaException("Error: The hour entered can't be higher than 23");
		} else {
			this.hour=hour;
		}
		
		if (minute<0) {
			logger.error("The minute entered ("+minute+") is negative");
			throw new BlaException("Error: Negative minutes don't exist");
		} else if (minute>59) {
			logger.error("The minute entered ("+minute+") is higher than 59");
			throw new BlaException("Error: The minute entered can't be higher than 59");
		} else {
			this.minute=minute;
		}
		logger.info("Time "+toString()+" added");
	}
	/**
	 * Obtain the hour of the time
	 * @return The hour
	 */
	public int getHour() {
		return hour;
	}
	/**
	 * Obtain the minute of the time
	 * @return The minute
	 */
	public int getMinute() {
		return minute;
	}
	
	/**
	 * Check if the time sent as a parameter is greater than the local variable of the class
	 * @return True-is greater False- isn't greater
	 */
	public boolean isBefore(Time time) {
		boolean exit=false;
		if (time.getHour()>this.hour) {
			exit=true;
		} else if (time.getHour()==this.hour) {
			if (time.getMinute()>=this.minute) {
				exit=true;
			}
		}
		return exit;
	}
	/**
	 * Generate the time in format H:M
	 * @return The time
	 */
	@Override
	public String toString() {
		StringBuffer salida = new StringBuffer();
		salida.append(this.hour+":"+this.minute);
		return salida.toString();
	}
	
}
