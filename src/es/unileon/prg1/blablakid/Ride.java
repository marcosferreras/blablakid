package es.unileon.prg1.blablakid;
public class Ride{
	
	private Time timeStart;
	private Time timeEnd;
	private String startPlace;
	private String endPlace;
	
	public Ride(Time timeStart, Time timeEnd, String startPlace, String endPlace ) {
		this.timeStart=timeStart;
		this.timeEnd=timeEnd;
		this.startPlace=startPlace;
		this.endPlace = endPlace;
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
	public void setTimeStart(Time timeStart) {
		this.timeStart = timeStart;
	}

	public Time getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Time timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String toString() {
		return ("\n"+this.startPlace+" > "+this.endPlace+" : "+timeStart.toString()+" / "+ timeEnd.toString());
	}
	/*private boolean isSame() {
		boolean exit=false;
		if (timeStart==timeEnd)
	}*/
}
