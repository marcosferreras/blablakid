package es.unileon.prg1.blablakid;
public class Activities{
	private Activity[] activities;
	private int next;
	/*
	 * Constructor of the class
	 */
	protected Activities() {
		activities = new Activity[3];
	}
	/*
	 * Add an activity to the collection 
	 * @param The activity to add
	 */
	public void add(Activity activity) throws BlaException {
		if(this.next >= 2) {
			throw new BlaException("Error: El niño ha llegado a su límite de 3 actividades. Pruebe a eliminar alguna actividad.");
		} else if (search(activity.getName(), activity.getDay()) != null) {
			throw new BlaException("Error: Activity "+activity.getName()+" is already added in "+activity.getDay()+". Try to remove it before");
		} else {
			this.activities[this.next]=activity;
			this.next++;
		}
	}
	/*
	 * Remove an activity from the collection
	 * @param Name of the activity to remove
	 */
	public void remove(String name, WeekDays day) throws BlaException {
		Activity activity = search(name, day);
		if(activity == null) {
			throw new BlaException("Error: El niño introducido no existe");
		} else {
					organize(position(activity));
					this.activities[this.next]=null;
					this.next--;
			}
	}
	public boolean addRide(String activityName, Ride ride, WeekDays day) throws BlaException {	
		Activity activity = search(activityName, day);
		boolean isCorrect = false;
		if (activity == null) {
			throw new BlaException("Error: The activity "+activityName+" does not exist in this kid");
		} else {
			isCorrect = activity.add(ride);	
		}
		return isCorrect;
	}
	/*
	 * Check if the activity exists
	 * @param Name of the activity
	 * @return False-It doesn't exist True
	 */
	public Activity search(String name, WeekDays day) {
		Activity activity = null;
		boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next)) {
			if(name.equals(activities[i].getName()) && day.equals(activities[i].getDay())){
				activity = this.activities[i];
				exist = true;
			}
			i++;
		}
		return activity;
	}
	
	private void organize(int position){
		
		while((position+1) < activities.length){
			activities[position] = activities[position+1];
			position++;
		}
		activities[(activities.length)-1] = null;
	}
	/*
	 * Find the position in the list of an Activity object
	 * @param The activity to find position
	 * @return Position of the activity
	 */
	public int position(Activity activity) {
		boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next)) {
			if(activity.getName().equals(this.activities[i].getName())){
				exist = true;
			}
			i++;
		}
		return (i-1);
	}
	public String toString() {
		StringBuffer salida= new StringBuffer();
		for(int i = 0; i < this.next ; i++) {
			salida.append("\n##### Activity "+(i+1)+" #####");
			salida.append(this.activities[i].toString());
		}
		return salida.toString();
	}
}