package es.unileon.prg1.blablakid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author Marcos Ferreras Rodriguez
 */
public class Kid{
	String name;
	Activities activities;
	int next;
	private static final Logger logger= LogManager.getLogger(Kid.class);
	/**
	 * Constructor
	 * @param name Name of the kid
	 */
	public Kid (String name){
		this.name = name;
		activities = new Activities();
		logger.info("Kid '"+name+"' created");
	}
	/**
	 * Gets the name of a kid
	 * @return The name of the kid 
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * Add an activity to the kid
	 * @param activity Activity to add
	 */
	public void add(Activity activity)throws BlaException{
		activities.add(activity);
	}
	/**
	 * Add a ride to the kid
	 * @param activityName Name of the Activity
	 * @param ride Ride to add
	 * @param day Weekday
	 */
	public void add(String activityName,Ride ride, WeekDays day)throws BlaException {
		Activity activity = searchActivity(activityName, day);
		activity.add(ride);
	}
	/**
	 * Remove a kid's activity
	 * @param activityName Name of the activity
	 * @param day Weekday
	 */
	public void remove(String activityName, WeekDays day) throws BlaException {
		this.activities.remove(activityName, day);
	}
	/**
	 * Search a kid's activity
	 * @param activityName Name of the activity
	 * @param day Weekday
	 * @return The activity
	 * @throws If the activity does not exist
	 */
	public Activity searchActivity(String activityName, WeekDays day) throws BlaException {
		Activity activity = this.activities.search(activityName, day);
		if(activity == null) {
			logger.error("The activity "+activityName+" does not exist in kid "+this.name);
			throw new BlaException("Error: The activity "+activityName+" does not exist in kid "+this.name);
		}
		return activity;
	}
	/**
	 * Obtain all the rides of the kid
	 * @return The rides of the kid
	 */
	public Rides getRides() throws BlaException {
		return this.activities.getRides();
	}
	/**
	 * 
	 * Remove a ride from the activity of a kid
	 * ride Ride to remove
	 * @return True if was deleted, False if not
	 */
	public boolean removeRide(Ride ride) {
		return this.activities.removeRide(ride);
	}
	/**
	 * Obtain the state of the kid's rides
	 * @return The state of the kid's rides
	 */
	public String checkStatus() {
		return this.activities.checkStatus();
	}
	/**
	 * Generate all the information about a kid
	 * @return All the information about a kid
	 */
	@Override
	public String toString(){
		StringBuffer salida= new StringBuffer();
		salida.append("\n****** "+this.name+" ******");
		salida.append(activities.toString());
		return salida.toString(); 
	}
}
