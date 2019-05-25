package es.unileon.prg1.blablakid;
public class Ride{
	
	private Time timeStart;
	private Time timeEnd;
	private String startPlace;
	private String endPlace;
	
	public Ride(Time timeStart, Time timeEnd, String startPlace, String endPlace ) throws BlaException{
		if(timeStart.isBefore(timeEnd)) {
			this.timeStart=timeStart;
			this.timeEnd=timeEnd;
			this.startPlace=startPlace;
			this.endPlace = endPlace;
		} else throw new BlaException("please change the order of the hours");
	}

	public Time getTimeStart() {
		return timeStart;
	}
	public String getStartPlace() {
		return this.startPlace;
	}
	public String getEndPlace() {
		return this.endPlace;
	}


	public Time getTimeEnd() {
		return timeEnd;
	}

	public String toString() {
		return ("\n"+this.startPlace+" > "+this.endPlace+" : "+timeStart.toString()+" / "+ timeEnd.toString());
	}
	public boolean isSame(String start,String end) {
		boolean exit=false;
		if (this.startPlace==start && this.endPlace==end) exit=true;
		return exit;
	}
}
