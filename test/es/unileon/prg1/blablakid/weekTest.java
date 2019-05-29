package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class weekTest {
	private Week week;
	
	@Before
	public void setup() throws BlaException {
		this.week = new Week(5);
	}
	
	@Test
	public void addRemoveRideTest() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.week.add( WeekDays.MONDAY, ride);
		assertSame(ride,this.week.remove(WeekDays.MONDAY,ride.getStartPlace(),ride.getEndPlace()));
	}
	
	@Test
	public void addRemoveUnknowRideTest() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.week.add( WeekDays.MONDAY, ride);
		this.week.remove(ride);
	}
	
	@Test
	public void toStringTest() throws BlaException{
		assertEquals("\nRIDES:",week.toString());
	}
}
