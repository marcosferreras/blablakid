package es.unileon.prg1.blablakid;
public class Week{
	
	private Day []day;
	private int next=0;
	
	public Week(int number)  throws BlaException{
		day = new Day[5];
		for (int i=0;i<5;i++) {
			this.day[i] = new Day(number,i);
		}
	}
	
	private int found(Day day) {
		int output=-1;
		for (int i=0;i<next;i++) {
			if (this.day[i].getWeekDay()==day.getWeekDay()) output=i;
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