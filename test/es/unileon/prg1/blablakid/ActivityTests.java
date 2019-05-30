package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActivityTests {
	private Activity activity;
	
	@Before
	public void setUp() throws Exception {
		this.activity = new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(18,00), new Time(20,00));
		}
	@Test 
	public void testGetName() {
		assertEquals("Baloncesto", this.activity.getName());
	}
	@Test
	public void testGetPlace() {
		assertEquals("Palomera", this.activity.getPlace());
	}
	@Test
	public void testGetDay() {
		assertEquals(WeekDays.MONDAY, this.activity.getDay());
	}
	@Test
	public void testGetStart() {
		assertEquals(18, this.activity.getStart().getHour());
		assertEquals(00, this.activity.getStart().getMinute());
	}
	@Test
	public void testGetEnd() {
		assertEquals(20, this.activity.getEnd().getHour());
		assertEquals(00, this.activity.getEnd().getMinute());
	}
	@Test (expected = BlaException.class)
	public void testIncorrectStartEnd() throws BlaException {
		new Activity("Baloncesto", "Palomera", WeekDays.MONDAY, new Time(20,00), new Time(19,00));
	}
	@Test (expected = BlaException.class)
	public void testIncorrectEndPlaceRideBefore() throws BlaException{
		this.activity.add(new Ride(new Time(15,00), new Time(18,00), "Casa", "Parque"));
	}
	@Test (expected = BlaException.class)
	public void testIncorrectStartPlaceRideAfter() throws BlaException{
		this.activity.add(new Ride(new Time(21,00), new Time(22,00), "San Mames", "Casa"));
	} 
	@Test (expected = BlaException.class)
	public void testIncorrectRide() throws BlaException{
		this.activity.add(new Ride(new Time(15,00), new Time(19,00), "Casa", "Palomera"));
	}
	@Test
	public void testGetBefore()throws BlaException {
		this.activity.add(new Ride(new Time(15,00), new Time(18,00), "Casa", "Palomera"));
		assertEquals(15,this.activity.getBefore().getTimeStart().getHour());
		assertEquals(00,this.activity.getBefore().getTimeStart().getMinute());
		assertEquals(18,this.activity.getBefore().getTimeEnd().getHour());
		assertEquals(00,this.activity.getBefore().getTimeEnd().getMinute());
	}
	@Test
	public void testGetAfter()throws BlaException {
		this.activity.add(new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa"));
		assertEquals(20,this.activity.getAfter().getTimeStart().getHour());
		assertEquals(00,this.activity.getAfter().getTimeStart().getMinute());
		assertEquals(21,this.activity.getAfter().getTimeEnd().getHour());
		assertEquals(00,this.activity.getAfter().getTimeEnd().getMinute());
	}
	@Test 
	public void testAddRideBefore()throws BlaException {
		Ride ride = new Ride(new Time(13,00), new Time(18,00), "Casa", "Palomera");
		this.activity.add(ride);
		assertEquals(this.activity.getBefore(),ride);
		//Check that it is not added to ride After
		assertNotSame(this.activity.getAfter(),ride);
	}
	@Test 
	public void testAddRideAfter()throws BlaException {
		Ride ride = new Ride(new Time(20,00), new Time(21,00),"Palomera", "Casa");
		this.activity.add(ride);
		assertEquals(this.activity.getAfter(),ride);
		//Check that it is not added to ride Before
		assertNotSame(this.activity.getBefore(),ride);
	}
	@Test (expected = BlaException.class)
	public void testAddRideBeforeRepeated()throws BlaException {
		this.activity.add(new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera"));
		this.activity.add(new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera")); 
	}
	@Test (expected = BlaException.class)
	public void testAddRideAfterRepeated()throws BlaException {
		this.activity.add(new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa"));
		this.activity.add(new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa"));
	}
	
	@Test (expected = BlaException.class)
	public void testAddIncorrectRide()throws BlaException {
		this.activity.add(new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa"));
		this.activity.add(new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa"));
	}
	@Test 
	public void testRemoveRideBefore()throws BlaException {
		Ride ride = new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera");
		this.activity.add(ride);
		assertTrue(this.activity.remove(ride));
	} 
	@Test 
	public void testRemoveFalseRide()throws BlaException {
		Ride ride = new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera");
		Ride ride1 = new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera");
		this.activity.add(ride);
		assertFalse(this.activity.remove(ride1));
	} 
	@Test 
	public void testRemoveRideAfter()throws BlaException {
		Ride ride = new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa");
		this.activity.add(ride);
		assertTrue(this.activity.remove(ride));
	} 
	@Test 
	public void testToString() throws BlaException {
		assertEquals("\nBaloncesto(Palomera - MONDAY)18:0>20:0\nNo ride before Baloncesto assigned\nNo ride after Baloncesto assigned",this.activity.toString());
		this.activity.add(new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera"));
		assertEquals("\nBaloncesto(Palomera - MONDAY)18:0>20:0\nCasa > Palomera : 11:0 / 18:0\nNo ride after Baloncesto assigned",this.activity.toString());
		this.activity.add(new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa"));
		assertEquals("\nBaloncesto(Palomera - MONDAY)18:0>20:0\nCasa > Palomera : 11:0 / 18:0\nPalomera > Casa : 20:0 / 21:0",this.activity.toString());
	}
	@Test 
	public void testToStringOnlyAfter() throws BlaException {
		this.activity.add(new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa"));
		assertEquals("\nBaloncesto(Palomera - MONDAY)18:0>20:0\nNo ride before Baloncesto assigned\nPalomera > Casa : 20:0 / 21:0",this.activity.toString());
	}
	@Test 
	public void testCheckStatusOnlyBefore() throws BlaException {
		this.activity.add(new Ride(new Time(20,00), new Time(21,00), "Palomera", "Casa"));
		assertEquals("\n" + 
				"MONDAY To: Palomera. Arrive to Palomera before 18:0",this.activity.checkStatus());
	}
	@Test 
	public void testCheckStatusOnlyAfter() throws BlaException {
		this.activity.add(new Ride(new Time(11,00), new Time(18,00), "Casa", "Palomera"));
		assertEquals("\nMONDAY From: Palomera. Arrive to Palomera after 20:0",this.activity.checkStatus());
	}
	
	
}