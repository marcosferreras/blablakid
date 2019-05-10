package es.unileon.prg1.blablakid;
public class Ride{
	
	private Time timeStart;
	private Time timeEnd;
	private String start;
	private String end;
	
	public Ride(Time timeStart, Time timeEnd, String Start, String end) {
		this.timeStart=timeStart;
		this.timeEnd=timeEnd;
		this.start=start;
		this.end=end;
	}

	public Time getTimeStart() {
		return timeStart;
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

	/*private boolean isSame() {
		boolean exit=false;
		if (timeStart==timeEnd)
	}*/
}
