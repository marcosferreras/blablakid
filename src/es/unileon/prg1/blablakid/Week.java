package es.unileon.prg1.blablakid;
public class Week{
	
	private Day []days;
	
	public Week() {
		days = new Day[5];
	}
	
	private void add(Day day, int number) throws BlaException{
		if (days[number]==null) this.days[number]=day;
		else throw new BlaException("that day have already exist, please remove first the day");
	}
	
	private void remove(Day day,int number) {
		this.days[number]=null;
	}
}