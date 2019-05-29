package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Week{
	
	private Day []day;
	private static final Logger logger= LogManager.getLogger(Week.class);
	
	public Week(int number)  throws BlaException{
		day = new Day[5];
		for (int i=0;i<5;i++) {
			this.day[i] = new Day(number,i);
		}
		logger.info("A week was created for the parent");
	}
	
	public void add(WeekDays day,Ride ride) throws BlaException{
		this.day[day.ordinal()].add(ride);
	}
	
	public Ride remove(WeekDays day,String start, String end) throws BlaException{
		return this.day[day.ordinal()].remove(start,end);
	}
	
	public boolean remove(Ride ride) {
		int number=0;
		boolean out=false;
		while(number<5 && !out) {
			out=this.day[number].remove(ride);
			number++;
		}
		return out;
	}
	
	public String toString() {
		StringBuffer output=new StringBuffer();
		output.append("\nRIDES:");
		for (int i=0;i<5;i++) {
			output.append(this.day[i].toString());
		}
		return output.toString();
	}
}