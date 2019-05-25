package es.unileon.prg1.blablakid;

public class Day{
	private WeekDays weekDay;
	private Rides rides;
	
	public Day(int numberRides,int numberDay)  throws BlaException {
		setWeekDay(numberDay);
		rides = new Rides(numberRides);
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
				throw new BlaException ("that day doesnt a correct number for the week day");
				
		}
	}
	
	public WeekDays getWeekDay() {
		return this.weekDay;
	}
	public void remove(String start, String end) throws BlaException{
		this.rides.remove(start,end);
	}	
	
	public void add(Ride ride) {
		this.rides.add(ride);
	}
	
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("\n"+weekDay+" rides:");
		return output.toString();
	}
}
