package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidTests {
	private Kid kid;
	
	@Before
	public void setUp() throws Exception {
		kid = new Kid("Daniel");
		}
	@Test 
	public void testKid() {
		assertEquals("Daniel", kid.getName());
	}
	@Test
	public void testAddActivity()throws BlaException {
		
		kid.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
	}
	@Test
	public void testAddRide() throws BlaException {
		kid.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		Ride ride = new Ride(new Time(15,00), new Time(16,00), "Casa", "Palomera");
		kid.add("Baloncesto",ride,WeekDays.MONDAY);
		assertEquals("\n" + 
				"****** Daniel ******\n" + 
				"##### Activity 1 #####\n" + 
				"Baloncesto(Palomera - MONDAY)18:0>20:0\n" + 
				"Casa > Palomera : 15:0 / 16:0\n" + 
				"No ride after Baloncesto assigned", this.kid.toString());
	}
	@Test (expected = BlaException.class)
	public void testAddFailRide() throws BlaException {
		kid.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		Ride ride = new Ride(new Time(15,00), new Time(16,00), "Casa", "Palomera");
		kid.add("Baloncesto",ride,WeekDays.TUESDAY);
	}
	@Test
	public void testRemoveActivity() throws BlaException {
		kid.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		kid.remove("baloncesto", WeekDays.MONDAY);
		assertEquals("\n****** Daniel ******", kid.toString());
	}
	@Test 
	public void testGetRides() throws BlaException{
		kid.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		Ride ride = new Ride(new Time(15,00), new Time(16,00), "Casa", "Palomera");
		kid.add("Baloncesto",ride,WeekDays.MONDAY);
		assertEquals("\nCasa > Palomera : 15:0 / 16:0",kid.getRides().toString());
	}
	@Test 
	public void testRemoveRide() throws BlaException{
		kid.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		Ride ride = new Ride(new Time(15,00), new Time(16,00), "Casa", "Palomera");
		kid.add("Baloncesto",ride,WeekDays.MONDAY);
		assertTrue(kid.removeRide(ride));
	}
	@Test 
	public void testRemoveFalseRide() throws BlaException{
		kid.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		Ride ride = new Ride(new Time(15,00), new Time(16,00), "Casa", "Palomera");
		Ride ride1 = new Ride(new Time(15,00), new Time(16,00), "Casa", "Palomera");
		kid.add("Baloncesto",ride,WeekDays.MONDAY);
		assertFalse(kid.removeRide(ride1));
	}
	@Test 
	public void testCheckStatus() throws BlaException{
		kid.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		Ride ride = new Ride(new Time(15,00), new Time(16,00), "Casa", "Palomera");
		kid.add("Baloncesto",ride,WeekDays.MONDAY);
		assertEquals("\nMONDAY From: Palomera. Arrive to Palomera after 20:0",kid.checkStatus());
	}
}
