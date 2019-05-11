package es.unileon.prg1.blablakid;
public class Activity{
	int next;
	WeekDays day;
	String name;
	String place;
	Time start;
	Time end;
	Ride before;
	Ride after;
	public Activity (String name, String place, WeekDays day, Time start, Time end) {
		this.name = name;
		this.place = place;
		this.day = day;
		this.start = start;
		this.end = end;
	}
	public String getName(){
		return this.name;
	}
	/*public void add(Ride ride) {
		isValid(ride);
	}
	public boolean isValid(Ride ride) {
		boolean valid = false;
		if (ride.getTime().get ==  ) {
			this.start = ride;
		}
		return valid;
	}*/
}
