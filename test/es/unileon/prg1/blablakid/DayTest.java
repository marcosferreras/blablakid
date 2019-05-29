package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DayTest {
	private Day day;
	
	@Before
	public void setup() throws BlaException{
		day = new Day(3,3);
	}
	
	@Test (expected = BlaException.class)
	public void wrongWeekDayNegativeTest() throws BlaException{
		new Day(2,-1);
	}
	
	@Test (expected = BlaException.class)
	public void wrongWeekDayVeryBigTest() throws BlaException{
		new Day(6,10);
	}
	
	@Test (expected = BlaException.class)
	public void wrongWeekNRides2Test() throws BlaException{
		new Day(-1,2);
	}
	
	@Test
	public void getSetWeekDays() throws BlaException{
		this.day.setWeekDay(0);
		assertEquals(WeekDays.MONDAY,this.day.getWeekDay());
		this.day.setWeekDay(1);
		assertEquals(WeekDays.TUESDAY,this.day.getWeekDay());
		this.day.setWeekDay(2);
		assertEquals(WeekDays.WEDNESDAY,this.day.getWeekDay());
		this.day.setWeekDay(3);
		assertEquals(WeekDays.THURSDAY,this.day.getWeekDay());
		this.day.setWeekDay(4);
		assertEquals(WeekDays.FRIDAY,this.day.getWeekDay());
	}
	
	@Test (expected = BlaException.class)
	public void wrongGetSetWeekDaysTest() throws BlaException{
		this.day.setWeekDay(9);
	}
	
	@Test 
	public void addTest() throws BlaException{
		Time startTime = new Time(12,30);
		Time endTime = new Time(15,30);
		Ride ride = new Ride(startTime,endTime,"casa", "palomera");
		day.add(ride);
		assertEquals(day.toString(),"\n" + 
				"THURSDAY rides:\n" + 
				"casa > palomera : 12:30 / 15:30");
	}
	
	@Test 
	public void removeTest() throws BlaException{
		Time startTime = new Time(12,30);
		Time endTime = new Time(15,30);
		Ride ride = new Ride(startTime,endTime,"casa", "palomera");
		day.add(ride);
		assertEquals(day.toString(),"\n" + 
				"THURSDAY rides:\n" + 
				"casa > palomera : 12:30 / 15:30");
		day.remove(ride.getStartPlace(), ride.getEndPlace());
		assertEquals(day.toString(),"");
	}
	
	@Test
	public void removeUnknowRideTest() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.day.add( ride);
		this.day.remove(ride);
	}
}