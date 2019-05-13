package es.unileon.prg1.blablakid;
public class Time{
	
	private int hour;
	private int minute;
	
	public Time(int hour,int minute) throws BlaException{
		if (hour<0) throw new BlaException("Negative hours dont exist");
		else if (hour>24) throw new BlaException("that hour is very hight");
		else this.hour=hour;
		
		if (minute<0) throw new BlaException("Negative minutes dont exist");
		else if (minute>60) throw new BlaException("that minut is very hight");
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

	/*
	 * Check if the time sent as a parameter is greater than the local variable of the class
	 * @return True-is greater False- isn't greater
	 */
	public boolean isBefore(Time time) {
		boolean exit=false;
		if (time.getHour()>this.hour) {
			exit=true;
		} else if (time.getHour()==this.hour) {
			if (time.getMinute()>this.minute) {
				exit=true;
			}
		}
		return exit;
	}
	/*
	 * Check if the time sent as a parameter is greater than the local variable of the class
	 * @return True-is greater False- isn't greater
	 */
	public boolean isEqual(Time time) {
		return ((this.hour == time.getHour()) && (this.minute == time.getMinute()));
	}
	
}
