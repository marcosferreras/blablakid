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
	 
	public boolean find(String name) {
		boolean output=false;
		if (null!=this.kids.search(name)) {
			output=true;
		}
		return output;
	}
	
	public void add(WeekDays day, Ride ride) throws BlaException{
		this.week.add(day,ride);
	}
	
	public Ride remove(WeekDays day, String start, String end) throws BlaException{
		return this.week.remove(day,start,end);
	}
	
	public boolean remove(Ride ride) {
		return this.week.remove(ride);
	}
	public void remove(String name) throws BlaException {
		this.kids.remove(name);
	}
	
	public String getName() {
		return name;
	}
		
	public String toString() {
		StringBuffer output = new StringBuffer();
		int i=0;
		output.append("\n##### "+this.name+" #####\n");
		output.append("Kids:\n");
		while(i<kids.getNext()){
			output.append(kids.getKid(i)+"\n");
			i++;
		}
		output.append(week.toString());
		return output.toString();
	}
}