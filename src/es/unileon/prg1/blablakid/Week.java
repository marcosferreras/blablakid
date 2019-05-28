package es.unileon.prg1.blablakid;
public class Week{
	
	private Day []day;
	
	public Week(int number)  throws BlaException{
		day = new Day[5];
		for (int i=0;i<5;i++) {
			this.day[i] = new Day(number,i);
		}
	}
	
	public int search(WeekDays weekDay) {
		int output=-1;
		for (int i=0;i<5;i++) {
			if (this.day[i].getWeekDay()==weekDay) output=i;
		}
		return output;
	}
	
	public Day getDay(WeekDays weekDay) {
		int i=search(weekDay);
		return this.day[i];
	}
	
	public String toString() {
		StringBuffer output=new StringBuffer();
		output.append("\nRIDES:");
		for (int i=0;i<5;i++) {
			output.append(this.day[i].toString());
		}
		return output.toString();
	}
}