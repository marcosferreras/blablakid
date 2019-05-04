package es.unileon.prg1.blablakid;
public class Kid{
	String name;
	Activities activities;
	int next;
	protected Kid (String name){
		this.name = name;
		activities = new Activities();
	}
	String getName(){
		return this.name;
	}
	void add(Activity activity)throws BlaException{
		/*if(this.next >= 3) {
			throw new BlaException("Error: El niño "+name+" ha llegado a su límite de 3 actividades");
		} else {
			this.activities = activities;
			this.next++;
		}*/
		if(!activities.addActivity(activity)) {
			throw new BlaException("Error: El niño "+name+" ha llegado a su límite de 3 actividades");
		}
	}
	
	public String toString(){
		return this.name;
	}
}
