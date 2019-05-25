package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlablakidTests {
	private Blablakid blablakid;
	
	@Before
	public void setUp() throws BlaException {
		blablakid = new Blablakid(3);
		this.blablakid.add(new Kid("Daniel"));
	}
	@Test (expected = BlaException.class)
	public void testNumOfKidsNegative() throws BlaException {
		new Blablakid(-1);
	}
	@Test 
	public void testRemoveKid() throws BlaException {
		this.blablakid.removeKid("Daniel"); 
	}
	@Test (expected = BlaException.class)
	public void testAddActivityFalseKid() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Helena");
	}
	@Test 
	public void testAddActivity() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
	}
	@Test 
	public void testRemoveActivity() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
		this.blablakid.removeActivity("Daniel", "Baloncesto", WeekDays.MONDAY);
	}
	@Test 
	public void testAddRide() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
		this.blablakid.addRide("Pedro", "Baloncesto", "Daniel", new Ride(new Time(17,00),new Time(18,00), "Casa", "Palomera"), WeekDays.MONDAY);
	}
	@Test (expected = BlaException.class)
	public void testAddRideIncorrectKid() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
		this.blablakid.addRide("Pedro", "Baloncesto", "Manuel", new Ride(new Time(17,00),new Time(18,00), "Casa", "Palomera"), WeekDays.MONDAY);
	}
	@Test 
	public void testAddParent() throws BlaException {
		Kids kids = new Kids(3);
		kids.add(new Kid("Daniel"));
		this.blablakid.add(new Parent("Pedro",2), kids);
	}
	
}