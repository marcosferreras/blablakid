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
}