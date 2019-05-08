package es.unileon.prg1.blablakid;
public class Activity{
	int next, day;;
	String name, place;
	Time after;
	Time before;
	public Activity (String name, String place, int day, Time after, Time before) {
		this.name = name;
		this.place = place;
		this.day = day;
		this.after = after;
		this.before = before;
	}
	public String getName(){
		return this.name;
	}
}
