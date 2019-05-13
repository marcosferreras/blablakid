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
	public boolean add(Ride ride)throws BlaException {
		boolean valid = false;
		if(isValidRideBefore(ride) == true) {
			this.before = ride;
			valid = true;
		} else if (isValidRideAfter(ride) == true) {
			this.after = ride;
			valid = true;
		}
		return valid;
	}
	public boolean isValidRideBefore(Ride ride) throws BlaException {
		boolean valid = false;
		if (ride.getTimeEnd().getHour() != this.start.getHour() || ride.getTimeEnd().getMinute() != this.start.getMinute() ) {
			throw new BlaException("Error: This ride doesn´t exist in this kid");
		} else if (this.after != null) {
			throw new BlaException("Error: This ride is already assigned. Try to remove it before");
		} else if (this.start.isBefore(ride.getTimeStart())) {
			throw new BlaException ("Error: The start time of the activity is before the pick-up time");
		} else {
			valid = true;
		}
		return valid;	
	}
	public boolean isValidRideAfter(Ride ride) throws BlaException {
		boolean valid = false;
		if (ride.getTimeStart().getHour() != this.end.getHour() || ride.getTimeStart().getMinute() != this.end.getMinute() ) {
			throw new BlaException("Error: This ride doesn´t exist in this kid");
		} else if (this.before != null) {
			throw new BlaException("Error: This ride is already assigned. Try to remove it before");
		} else if (ride.getTimeStart().isBefore(this.end)) {
			throw new BlaException ("Error: The start time of the activity is before the pick-up time");
		} else {
			valid = true;
		}
		return valid;
	}
	public String toString() {
		StringBuffer salida = new StringBuffer();
		salida.append("\n"+this.name+"("+this.place+" - "+day.toString()+")"+this.start.toString()+">"+this.end.toString());
		if (this.before == null) {
			salida.append("\nNo ride before "+this.name+" assigned");
		} else {
			salida.append(this.before.toString());
		}
		if(this.after == null) {
			salida.append("\nNo ride after "+this.name+" assigned");
		} else {
			salida.append(this.after.toString());
		}
		return salida.toString();
	}
}
