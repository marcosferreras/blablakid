package es.unileon.prg1.blablakid;
public class Week{
	
	private Day []days;
	private int next=0;
	
	public Week() {
		days = new Day[5];
	}
	
	private void add(Day day) throws BlaException{
		if (found(day)==-1) {
			this.days[next]=day;
			this.next++;
		}
		else throw new BlaException("that day have already exist, please remove first the day");
	}
	
	private int found(Day day) {
		int output=-1;
		for (int i=0;i<next;i++) {
			if (days[i].getWeekDay()==day.getWeekDay()) output=i;
		}
		return output;
	}
	
	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
}