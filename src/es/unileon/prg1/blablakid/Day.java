package es.unileon.prg1.blablakid;

public class Day{
	private WeekDays weekDay;
	private Rides rides;
	
	public Day(int numberRides,int numberDay)  throws BlaException {
		if (numberDay<0) throw new BlaException("The day of the week must be positive");
		else if (numberDay<5) throw new BlaException("This week only have five posible days");
		else setWeekDay(numberDay);
		
		if (numberRides>0) {
			rides = new Rides(numberRides);
		}
		else throw new BlaException ("that day doesnt a correct number for the rides");
	}
	
	public void setWeekDay(int number) {
		switch(number){
			case 0:
				this.weekDay = WeekDays.MONDAY;
			break;
			case 1:
				this.weekDay = WeekDays.TUESDAY;
			break;
			case 2:
				this.weekDay = WeekDays.WEDNESDAY;
			break;
			case 3:
				this.weekDay = WeekDays.THURSDAY;
			break;
			case 4:
				this.weekDay = WeekDays.FRIDAY;
			break;
			default:
		}
	}
	
	public WeekDays getWeekDay() {
		return this.weekDay;
	}
		
}
