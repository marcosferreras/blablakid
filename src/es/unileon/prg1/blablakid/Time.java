package es.unileon.prg1.blablakid;
public class Time{
	
	private int hour;
	private int minute;
	
	public Time(int hour,int minute) throws BlaException{
		if (hour<0) throw new BlaException("Negative hours dont exist");
		else if (hour>24) throw new BlaException("that hour is very hight");
		else this.hour=hour;
		
		if (minute<0) throw new BlaException("Negative minutes dont exist");
		else if (minute>24) throw new BlaException("that minut is very hight");
		else this.minute=minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	private boolean isLess(int hour, int minute) {
		boolean exit=false;
		if (hour>this.hour) exit=true;
		else if (hour==this.hour) {
			if (minute>this.minute) exit=true;
			else exit=false;
		}else exit=false;
		return exit;
	}
	
}
