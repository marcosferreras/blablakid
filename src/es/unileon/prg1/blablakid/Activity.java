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
	/*
	 * Builder
	 * @param name Name of the activity
	 * @param place Place where the kid does the activity
	 * @param day Day of the week of the activity
	 * @param When start the activity
	 * @param When end the activity
	 */
	public Activity (String name, String place, WeekDays day, Time start, Time end) {
		this.name = name;
		this.place = place;
		this.day = day;
		this.start = start;
		this.end = end;
	}
	/*
	 * @return Name of the activity
	 */
	public String getName(){
		return this.name;
	}
	/*
	 * @return Before ride of the activity
	 */
	public Ride getBefore(){
		return this.before;
	}
	/*
	 * Add a ride to the activity
	 * @param A ride to add to the activity of a kid
	 * @return True if the ride was added or False if not
	 */
	public boolean add(Ride ride)throws BlaException {
		boolean valid = false;
		if(isRideBefore(ride)) {
			this.before = ride;
			valid = true;
		} else if (isRideAfter(ride)) {
			this.after = ride;
			valid = true;
		}
		return valid;
	}
	private boolean isRideBefore(Ride ride) throws BlaException {
		boolean valid = false; 
		if (ride.getTimeEnd().isEqual(this.start)) {
			throw new BlaException("Error: This ride does not exist in this kid");
		} else if (this.after != null) {
			throw new BlaException("Error: This ride is already assigned. Try to remove it before");
		} else if (this.start.isBefore(ride.getTimeStart())) {
			throw new BlaException ("Error: The start time of the activity is before that the pick-up time");
		} else {
			valid = true;
		}
		return valid;	
	}
	private boolean isRideAfter(Ride ride) throws BlaException {
		boolean valid = false;
		if (ride.getTimeStart().isEqual(this.end)) {
			throw new BlaException("Error: This ride does not exist in this kid");
		} else if (this.before != null) {
			throw new BlaException("Error: This ride is already assigned. Try to remove it before");
		} else if (ride.getTimeStart().isBefore(this.end)) {
			throw new BlaException ("Error: The start time of the activity is before the pick-up time");
		} else {
			valid = true;
		}
		return valid;
	}
	/*
	 * @return Information of the activity
	 */
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
