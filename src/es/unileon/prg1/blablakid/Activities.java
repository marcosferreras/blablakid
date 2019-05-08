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
		if(this.next >= 3) {
			throw new BlaException("Error: El niño ha llegado a su límite de 3 actividades. Pruebe a eliminar alguna actividad.");
		} else {
			this.activities[this.next] = activity;
			this.next++;
		}
	}
	/*
	 * Remove an activity from the collection
	 * @param Name of the activity to remove
	 */
	public void remove(String name) throws BlaException {
		Activity activity = search(name);
		if(activity == null) {
			throw new BlaException("Error: El niño introducido no existe");
		} else {
					activity = null;
					organize(position(activity));
					this.next--;
			}
	}
	/*
	 * Check if the activity exists
	 * @param Name of the activity
	 * @return False-It doesn't exist True
	 */
	protected Activity search(String name) {
		Activity activity = null;
		boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next) && this.activities[i]!= null) {
			if(name.equals(activities[i].getName())){
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
		while((exist == false) && (i < this.next) && this.activities[i]!= null) {
			if(activity.getName().equals(this.activities[i].getName())){
				exist = true;
			}
			i++;
		}
		return (i-1);
	}
}