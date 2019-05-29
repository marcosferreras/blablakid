package es.unileon.prg1.blablakid;
public class Week{
	
	private Day []day;
	
	public Week(int number)  throws BlaException{
		day = new Day[5];
		for (int i=0;i<5;i++) {
			this.day[i] = new Day(number,i);
		}
	}
	
	public void add(WeekDays day,Ride ride) throws BlaException{
		this.day[day.ordinal()].add(ride);
	}
	
	public Ride remove(WeekDays day,String start, String end) throws BlaException{
		return this.day[day.ordinal()].remove(start,end);
	}
	
	public boolean remove(Ride ride) {
		int number=0;
		boolean out=false;
		while(number<5 && !out) {
			out=this.day[number].remove(ride);
			number++;
		}
		return out;
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