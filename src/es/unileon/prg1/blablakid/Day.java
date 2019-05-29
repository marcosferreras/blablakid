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
				throw new BlaException ("That day does not a correct number for the week day");
				
		}
	}
	
	public WeekDays getWeekDay() {
		return this.weekDay;
	}
	
	public void add(Ride ride)throws BlaException {
		this.rides.add(ride);
	}
	
	public Ride remove(String start, String end)throws BlaException{
		this.rides.remove(start, end);
		return this.rides.search(start,end);
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
