package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RideTests {
	private Ride ride;
	
	@Before
	public void setup() throws BlaException{
		ride = new Ride(new Time(12,30),new Time(15,30),"casa", "palomera");
	}
	
	@Test
	public void testGetTime() throws BlaException{
		assertEquals(new Time(12,30).getMinute(),ride.getTimeStart().getMinute());
		assertEquals(new Time(12,30).getHour(),ride.getTimeStart().getHour());
	}
	
	@Test
	public void testGetTimeEnd() throws BlaException{
		assertEquals(new Time(15,30).getMinute(),ride.getTimeEnd().getMinute());
		assertEquals(new Time(15,30).getHour(),ride.getTimeEnd().getHour());
	}
	
	@Test
	public void testGetStartPalceEnd() {
		assertEquals("casa",ride.getStartPlace());
	}
	
	@Test
	public void testGetStartEnd() {
		assertEquals("palomera",ride.getEndPlace());
	}
	
	@Test
	public void testIsSame() {
		assertTrue(this.ride.isSame(ride.getStartPlace(), ride.getEndPlace()));
		assertFalse(this.ride.isSame("p",ride.getEndPlace()));
		assertFalse(this.ride.isSame(ride.getStartPlace(),"p"));
	}
	
	@Test (expected=BlaException.class)
	public void wrongOrderHoursTest() throws BlaException{
		new Ride(new Time(18,30),new Time(15,30),"casa", "palomera");
	}
	
	@Test
	public void toStringTest() {
		assertEquals("\n" + 
				"casa > palomera : 12:30 / 15:30",ride.toString());
	}
}
