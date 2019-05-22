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
	public String getPlace(){
		return this.place;
	}
	public WeekDays getDay(){
		return this.day;
	}
	/*
	 * @return Before ride of the activity
	 */
	public Time getStart(){
		return this.start;
	}
	public Time getEnd(){
		return this.end;
	}
	public Ride getBefore(){
		return this.before;
	}
	public Ride getAfter(){
		return this.after;
	}
	
	/*
	 * Add a ride to the activity
	 * @param A ride to add to the activity of a kid
	 * @return True if the ride was added or False if not
	 */
	public boolean add(Ride ride)throws BlaException {
		boolean isValid = false;
		if(ride.getTimeEnd().isEqual(this.start)) {
			if (this.before != null) {
				throw new BlaException("Error: This ride is already assigned. Try to remove it before");
			} else {
				this.before = ride;
				isValid = true;
			}
		} else if (ride.getTimeStart().isEqual(this.end)) {
			if (this.after != null) {
				throw new BlaException("Error: This ride is already assigned. Try to remove it before");
			} else {
				this.after = ride;
				isValid = true;
			}
		} else {
			throw new BlaException("Error: This ride does not exist in this kid");
		}
		return isValid;
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
