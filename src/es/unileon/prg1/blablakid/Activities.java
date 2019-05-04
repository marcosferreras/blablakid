package es.unileon.prg1.blablakid;
public class Activities{
	private Activity[] activities;
	private int next;
	protected Activities() {
		activities = new Activity[3];
	}
	protected boolean addActivity(Activity activity) throws BlaException {
		boolean isSave = false;
		if(this.next < 3) {
			this.activities[this.next] = activity;
			this.next++;
			isSave = true;
		}
		return isSave;
	}
}