package es.unileon.prg1.blablakid;
public class Kid{
	String name;
	Activities activities;
	int next;
	protected Kid (String name){
		this.name = name;
		activities = new Activities();
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
		Activity activity = this.activities.search(activityName, day);
		if(activity == null) {
			throw new BlaException("Error: The activity "+activityName+" does not exist");
		} else {
			activity.add(ride);
		}
	}
	public void removeActivity(String activityName, WeekDays day) throws BlaException {
		this.activities.remove(activityName, day);
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
