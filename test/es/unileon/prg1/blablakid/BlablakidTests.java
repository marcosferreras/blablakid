package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlablakidTests {
	private Blablakid blablakid;
	
	@Before
	public void setUp() throws BlaException {
		blablakid = new Blablakid(3);
		Kids kids = new Kids(1);
		kids.add(new Kid("Daniel"));
		this.blablakid.add(new Kid("Daniel"));
		this.blablakid.add(new Parent("Pedro",2,1),kids);
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
	public void testRemoveFakeKid() throws BlaException {
		this.blablakid.removeKid("Danie"); 
	}
	
	@Test (expected = BlaException.class)
	public void testAddActivityFakeKid() throws BlaException {
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
	@Test (expected = BlaException.class)
	public void testRemoveActivityFakeKid() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
		this.blablakid.removeActivity("Danie", "Baloncesto", WeekDays.MONDAY);
	} 
	@Test 
	public void testRemoveActivityWithRides() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
		this.blablakid.addRide("Pedro", "Baloncesto", "Daniel", new Ride(new Time(17,00),new Time(18,00), "Casa", "Palomera"), WeekDays.MONDAY);
		this.blablakid.addRide("Pedro", "Baloncesto", "Daniel", new Ride(new Time(21,00),new Time(22,00), "Palomera", "Casa"), WeekDays.MONDAY);
		this.blablakid.removeActivity("Daniel", "Baloncesto", WeekDays.MONDAY);
	}
	@Test 
	public void testAddRide() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
		this.blablakid.addRide("Pedro", "Baloncesto", "Daniel", new Ride(new Time(17,00),new Time(18,00), "Casa", "Palomera"), WeekDays.MONDAY);
	}
	@Test 
	public void testRemoveRide() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
		this.blablakid.addRide("Pedro", "Baloncesto", "Daniel", new Ride(new Time(17,00),new Time(18,00), "Casa", "Palomera"), WeekDays.MONDAY);
		this.blablakid.removeRide("Pedro", WeekDays.MONDAY, "Casa", "Palomera");
	}
	@Test (expected = BlaException.class)
	public void testAddRideFakeKid() throws BlaException {
		this.blablakid.add(new Activity("Baloncesto","Palomera",WeekDays.MONDAY,new Time(18,00),new Time(20,00)), "Daniel");
		this.blablakid.addRide("Pedro", "Baloncesto", "Manuel", new Ride(new Time(17,00),new Time(18,00), "Casa", "Palomera"), WeekDays.MONDAY);
	}

	
}