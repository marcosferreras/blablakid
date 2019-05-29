package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentTest {
	private Parent parent;
	
	@Before
	public void setup() throws BlaException{

		this.parent = new Parent("Carlos",1,3);
		this.parent.add(new Kid("Carlos"));
	}
		
	@Test
	public void builderTest() {
		assertEquals("Carlos",parent.getName());
	}
	
	@Test
	public void addremoveRideTest() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.parent.add( WeekDays.MONDAY, ride);
		this.parent.remove(WeekDays.MONDAY,ride.getStartPlace(),ride.getEndPlace());
	}
	@Test
	public void findTest() {
		assertEquals(true,parent.find("Carlos"));
	}
	
	@Test
	public void toStringTest() {
		assertEquals("\n" + 
				"##### Carlos #####\n" + 
				"Kids:\n" + 
				"\n" + 
				"****** Carlos ******\n" + 
				"\n" + 
				"RIDES:",parent.toString());
	}
}