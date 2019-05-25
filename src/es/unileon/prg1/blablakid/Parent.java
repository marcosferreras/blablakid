package es.unileon.prg1.blablakid;
public class Parent{
	
	private String name;
	private Week week;
	private Kids kids;
	
	public Parent(String name,int number) throws BlaException {
		this.name=name;
		this.kids = new Kids(number);
		week = new Week(number);
	}

	public void add(Kid kid) throws BlaException {
		this.kids.add(kid);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void remove(String start,String end,WeekDays weekDay) throws BlaException{
		this.week.remove(start, end,weekDay);
	}
	
	public void add(Ride ride, WeekDays weekDay) throws BlaException{
		this.add(ride, weekDay);
	}
}