package es.unileon.prg1.blablakid;
/**
 * @author Marcos Ferreras Rodriguez
 *
 */
public class Activity{
	int next;
	WeekDays day;
	String name;
	String place;
	Time start;
	Time end;
	Ride before;
	Ride after;
	/**
	 * Constructor
	 * @param name Name of the activity
	 * @param place Place where the kid does the activity
	 * @param day Day of the week of the activity
	 * @param start When start the activity
	 * @param end When end the activity
	 * @throws If the end time is before that the start time
	 */
	public Activity (String name, String place, WeekDays day, Time start, Time end) throws BlaException {
		setSchedule(start,end);
		this.name = name;
		this.place = place;
		this.day = day;
		this.start = start;
		this.end = end;
	}
	/**
	 * @return Name of the activity
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @return Name of the place where takes place the activity
	 */
	public String getPlace(){
		return this.place;
	}
	/**
	 * @return Weekday of the activity
	 */
	public WeekDays getDay(){
		return this.day;
	}
	private void setSchedule(Time start, Time end) throws BlaException {
		if(end.isBefore(start)) {
			throw new BlaException("Error: The start time of the activity is after the end");
		} else {
			this.start = start;
			this.end = end;
		}
	}
	/**
	 * @return Time when start the activity
	 */
	public Time getStart(){
		return this.start;
	}
	/**
	 * @return Time when end the activity
	 */
	public Time getEnd(){
		return this.end;
	}
	/**
	 * @return Ride before the activity
	 */
	public Ride getBefore(){
		return this.before;
	}
	/**
	 * @return Ride after the activity
	 */
	public Ride getAfter(){
		return this.after;
	}
	
	/**
	 * Add a ride to the activity
	 * @param ride A ride to add to the activity of a kid
	 * @return True if the ride was added or False if not
	 */
	public void add(Ride ride)throws BlaException {
		if(ride.getTimeEnd().isBefore(this.start)) {
			if (this.before != null) {
				throw new BlaException("Error: This ride is already assigned. Try to remove it before");
			} else if (!ride.getEndPlace().toLowerCase().equals(this.place.toLowerCase())){
				throw new BlaException("Error: The ride have to finish in "+this.place);
			} else {
				this.before = ride;
			}
		} else if (this.end.isBefore(ride.getTimeStart())) {
			if (this.after != null) {
				throw new BlaException("Error: This ride is already assigned. Try to remove it before");
			} else if (!ride.getStartPlace().toLowerCase().equals(this.place.toLowerCase())) {
				throw new BlaException("Error: The ride have to start in "+this.place);
			} else {
				this.after = ride;
			}
		} else {
			throw new BlaException("Error: The ride is incorrect, must be finish before the start time of the activity or start after the end time of the activity");
		}
	}
	/**
	 * @return The state of a kid rides
	 */
	public String checkStatus() {
		StringBuffer salida = new StringBuffer();
			if (this.before == null) {
				salida.append("\n"+day.toString()+" To: "+this.place+". Arrive to "+this.place+" before "+this.start.toString());
			} 
			if(this.after == null) {
				salida.append("\n"+day.toString()+" From: "+this.place+". Arrive to "+this.place+" after "+this.end.toString());
			} 
		return salida.toString();
	}
	/**
	 * @return Information of the activity
	 */
	@Override
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
