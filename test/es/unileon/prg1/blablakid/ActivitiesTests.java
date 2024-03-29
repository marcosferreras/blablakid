package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActivitiesTests {
	private Activities activities;
	@Before
	public void setUp() throws Exception {
		this.activities = new Activities();
		}
	@Test 
	public void testAddAndSearchActivity() throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity); 
		assertEquals(activity, this.activities.search("Baloncesto", WeekDays.MONDAY));
	}
	@Test (expected = BlaException.class)
	public void addFull() throws BlaException {
		this.activities.add(new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		this.activities.add(new Activity("Voleibol", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
		this.activities.add(new Activity("Badminton", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00)));
	}
	@Test (expected = BlaException.class)
	public void testAddRepeatedActivity() throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity);
		this.activities.add(activity);

	}
	@Test 
	public void testSearchNotFound() throws BlaException {
		assertNull(this.activities.search("Baloncesto", WeekDays.MONDAY));
	}
	@Test 
	public void testSearchSameNameDifferentDay() throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity);
		assertNull(this.activities.search("Baloncesto", WeekDays.TUESDAY));
	}
	@Test 
	public void testSearchDifferentNameSameDay() throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity);
		assertNull(this.activities.search("Futbol", WeekDays.TUESDAY)); 
	}
	@Test 
	public void testRemoveActivity() throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity);
		this.activities.remove("Baloncesto", WeekDays.MONDAY);
		assertNull(this.activities.search("Baloncesto", WeekDays.MONDAY)); 
	}
	@Test (expected = BlaException.class)
	public void testRemoveActivityNotFound() throws BlaException {
		this.activities.remove("Baloncesto", WeekDays.MONDAY);
	}
	
	@Test 
	public void testRemoveRideBefore()throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity);
		Ride ride = new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera");
		activity.add(ride);
		assertTrue(this.activities.removeRide(ride));
	} 
	@Test 
	public void testGetRides()throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity);
		Ride ride = new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera");
		Ride ride1 = new Ride(new Time(20,00), new Time(22,00), "Palomera", "Casa");
		activity.add(ride);
		activity.add(ride1);
		assertEquals("\n" + 
				"Palomera > Casa : 20:0 / 22:0\n" + 
				"Casa > Palomera : 11:0 / 18:0",this.activities.getRides().toString());
	} 
	@Test 
	public void testCheckStatusOnlyAfter() throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity);
		assertEquals("\n" + 
				"MONDAY To: Palomera. Arrive to Palomera before 18:0\n" + 
				"MONDAY From: Palomera. Arrive to Palomera after 20:0",this.activities.checkStatus());
	}
	@Test
	public void testToString() throws BlaException {
		Activity activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		this.activities.add(activity); 
		assertEquals(this.activities.toString(),"\n##### Activity 1 #####\nBaloncesto(Palomera - MONDAY)18:0>20:0\nNo ride before Baloncesto assigned\nNo ride after Baloncesto assigned");
	}
}
