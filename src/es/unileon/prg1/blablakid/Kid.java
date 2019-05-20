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
	public boolean addRide(String activityName,Ride ride, WeekDays day)throws BlaException {
		return activities.addRide(activityName,ride, day);
	}
	
	public String toString(){
		StringBuffer salida= new StringBuffer();
		salida.append("\n****** "+this.name+" ******");
		salida.append(activities.toString());
		return salida.toString(); 
	}
}
