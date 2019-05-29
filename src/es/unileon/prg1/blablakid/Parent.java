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
		if (null==this.kids.search(name)) output=true;
		return output;
	}
	
	public void remove(String name) throws BlaException {
		this.kids.remove(name);
	}
	
	public String getName() {
		return name;
	}
	
	public Day getDay(WeekDays day) {
		return this.week.getDay(day);
	}
	
	public String toString() {
		StringBuffer output = new StringBuffer();
		int i=0;
		output.append("\n##### "+this.name+" #####\n");
		output.append("Kids:\n");
		while(kids.getKid(i)!=null && i<kids.getLength()){
			output.append(kids.getKid(i)+"\n");
			i++;
		}
		output.append(week.toString());
		return output.toString();
	}
}