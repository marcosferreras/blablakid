package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentTests {
	private Parent parent;
	
	@Before
	public void setup() throws BlaException{

		this.parent = new Parent("Carlos",2,3);
		this.parent.add(new Kid("Carlos"));
	}
		
	@Test
	public void testBuilder() {
		assertEquals("Carlos",parent.getName());
	}
	
	@Test
	public void testAddremoveRide() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.parent.add( WeekDays.MONDAY, ride);
		assertSame(ride,this.parent.remove(WeekDays.MONDAY,ride.getStartPlace(),ride.getEndPlace()));
	}
	@Test
	public void testRemoveRide() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		Rides rides=new Rides(3);
		rides.add(ride);
		this.parent.add( WeekDays.MONDAY, ride);
		this.parent.remove(ride);
	}
	@Test
	public void testFind() {
		assertEquals(true,parent.find("Carlos"));
	}
	
	@Test
	public void testToString() {
		assertEquals("\n" + 
				"##### Carlos #####\n" + 
				"Kids:\n" + 
				"\n" + 
				"****** Carlos ******\n" + 
				"\n" + 
				"RIDES:",parent.toString());
	}
}