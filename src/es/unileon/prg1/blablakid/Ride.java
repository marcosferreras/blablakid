package es.unileon.prg1.blablakid;
public class Ride{
	
	private Activity activity;
	private Time time;
	
	public Ride(Activity activity, Time time) {
		this.activity=activity;
		this.time=time;
	}
	
	public Time getTime() {
		return this.time;
	}
	
	public void setTime(Time time) {
		this.time=time;
	}
	
	public Activity getActivity() {
		return this.activity;
	}
	
	public void setActivity(Activity activity) {
		this.activity=activity;
	}
}
