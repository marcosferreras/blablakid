package es.unileon.prg1.blablakid;
public class Parent{
	
	private String name;
	private Week week;
	private Kids kids;
	
	public Parent(String name,int numberRides, int numberKids) throws BlaException {
		this.name=name;
		this.kids = new Kids(numberKids);
		week = new Week(numberRides);
	}

	public void add(Kid kid) throws BlaException {
		this.kids.add(kid);
	}
	
	
	public String getName() {
		return name;
	}
	
	public void remove(String start,String end,WeekDays weekDay) throws BlaException{
		this.week.remove(start, end,weekDay);
	}
	
	public void add(Ride ride, WeekDays weekDay) throws BlaException{
		this.week.add(ride, weekDay);
	}
	
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("\n***** "+this.name+" *****\n");
		output.append(kids.toString());
		output.append(week.toString());
		return output.toString();
	}
}