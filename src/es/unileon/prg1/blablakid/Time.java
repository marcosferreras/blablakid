package es.unileon.prg1.blablakid;
public class Time{
	
	private int hour;
	private int minute;
	
	public Time(int hour,int minute) throws BlaException{
		if (hour<0) {
			throw new BlaException("Error: Negative hours don't exist");
		} else if (hour>24) {
			throw new BlaException("Error: The hour entered can't be higher than 23");
		} else {
			this.hour=hour;
		}
		
		if (minute<0) {
			throw new BlaException("Error: Negative minutes don't exist");
		} else if (minute>59) {
			throw new BlaException("Error: The minute entered can't be higher than 59");
		} else {
			this.minute=minute;
		}
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
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
	public String toString() {
		StringBuffer salida = new StringBuffer();
		salida.append(this.hour+":"+this.minute);
		return salida.toString();
	}
	
}
