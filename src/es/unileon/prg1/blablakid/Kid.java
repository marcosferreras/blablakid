package es.unileon.prg1.blablakid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class Kid{
	String name;
	Activities activities;
	int next;
	private static final Logger logger= LogManager.getLogger(Kid.class);
	protected Kid (String name){
		this.name = name;
		activities = new Activities();
		//logger.trace("Kid added to the collection");
	}
	/*
	 * Gets the name of a kid
	 * @ The name of the kid 
	 */
	public String getName(){
		return this.name;
	}
	/*
	 * Add an activity to the kid
	 * @param Activity to add
	 */
	public void add(Activity activity)throws BlaException{
		activities.add(activity);
	}
	public void addRide(String activityName,Ride ride, WeekDays day)throws BlaException {
		Activity activity = searchActivity(activityName, day);
		activity.add(ride);
	}
	public void removeActivity(String activityName, WeekDays day) throws BlaException {
		this.activities.remove(activityName, day);
	}
	public Activity searchActivity(String activityName, WeekDays day) throws BlaException {
		Activity activity = this.activities.search(activityName, day);
		if(activity == null) {
			throw new BlaException("Error: The activity "+activityName+" does not exist");
		}
		return activity;
	}
	public String checkStatus() {
		return this.activities.checkStatus();
	}
	public String toString(){
		StringBuffer salida= new StringBuffer();
		salida.append("\n****** "+this.name+" ******");
		salida.append(activities.toString());
		return salida.toString(); 
	}
}
