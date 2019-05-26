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
	
	public Week getWeek() {
		return this.week;
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