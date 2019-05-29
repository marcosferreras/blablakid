package es.unileon.prg1.blablakid;
/**
 * 
 * @author Marcos Ferreras Rodriguez
 *
 */
public class Activities{
	private Activity[] activities;
	private int next;
	/**
	 * Constructor of the class
	 */
	protected Activities() {
		activities = new Activity[3];
	}
	/**
	 * Add an activity to the collection 
	 * @param activity The activity to add
	 */
	public void add(Activity activity) throws BlaException {
		if(this.next >= 2) {
			throw new BlaException("Error: The child has reached his limit of 3 activities. Try to delete some activity.");
		} else if (search(activity.getName(), activity.getDay()) != null) {
			throw new BlaException("Error: Activity "+activity.getName()+" is already added in "+activity.getDay()+". Try to remove it before");
		} else {
			this.activities[this.next]=activity;
			this.next++;
		}
	}
	/**
	 * Remove an activity from the collection
	 * @param name Name of the activity to remove
	 * @param day Day of the activity
	 */
	public void remove(String name, WeekDays day) throws BlaException {
		Activity activity = search(name, day);
		if(activity == null) {
			throw new BlaException("Error: the child introduced does not exist");
		} else {
					organize(position(activity));
					this.activities[this.next]=null;
					this.next--;
			}
	}

	/**
	 * Check if the activity exists
	 * @param name Name of the activity to remove
	 * @param day Day of the activity
	 * @return True if the activity exists or False if not
	 */
	public Activity search(String name, WeekDays day) {
		Activity activity = null;
		boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next)) {
			if(name.toLowerCase().equals(activities[i].getName().toLowerCase()) && day.equals(activities[i].getDay())){
				activity = this.activities[i];
				exist = true;
			}
			i++;
		}
		return activity;
	}
	/**
	 * Organizes the array in order to delete the gaps
	 * @param position Position of the element to organize
	 */
	private void organize(int position){
		
		while((position+1) < activities.length){
			activities[position] = activities[position+1];
			position++;
		}
		activities[(activities.length)-1] = null;
	} 
	/**
	 * Find the position in the list of an Activity object
	 * @param activity The activity to find his position
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
	public Rides getRides() throws BlaException {
		Rides rides = new Rides(this.next+1);
		for(int i = 0; i < this.next; i++) {
			if (this.activities[i].getAfter() != null) {
				rides.add(this.activities[i].getAfter());
			}
			if (this.activities[i].getBefore() != null) {
			rides.add(this.activities[i].getBefore());
			}
		}
		return rides;
	}
	public boolean removeRide(Ride ride) {
		boolean deleted = false;
		int i = 0;
		while(i<this.next && !deleted) {
			deleted = this.activities[i].removeRide(ride);
			i++;
		}
		return deleted;
	}
	/**
	 * Obtain the state of the kid's rides
	 * @return The state of the kid's rides
	 */
	public String checkStatus() {
		StringBuffer salida= new StringBuffer();
		for(int i = 0; i < this.next ; i++) {
			salida.append(this.activities[i].checkStatus());
		}
		return salida.toString();
	}
	/**
	 * Generate all the information about the activities of a kid
	 * @return All the information about the activities of a kid
	 */
	@Override
	public String toString() {
		StringBuffer salida= new StringBuffer();
		for(int i = 0; i < this.next ; i++) {
			salida.append("\n##### Activity "+(i+1)+" #####");
			salida.append(this.activities[i].toString());
		}
		return salida.toString();
	}
}