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
	
	public void remove(String start, String end,WeekDays weekDay)throws BlaException{
		int i=0;
		do {
			if(this.day[i].getWeekDay()!=weekDay) {
				this.day[i].remove(start, end);
			}
			i++;
		}while(this.day[i].getWeekDay()!=weekDay && i<5);
	}
	
	public void add(Ride ride,WeekDays weekDay) {
		int i=0;
		do {
			if(this.day[i].getWeekDay()!=weekDay) {
				this.day[i].add(ride);
			}
			i++;
		}while(this.day[i].getWeekDay()!=weekDay && i<5);
	}
	
	public String toString() {
		StringBuffer output=new StringBuffer();
		output.append("\nRides of the week:");
		for (int i=0;i<5;i++) {
			output.append(this.day[i].toString());
		}
		return output.toString();
	}
}