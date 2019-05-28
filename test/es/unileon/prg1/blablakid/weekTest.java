package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class weekTest {
	private Week week;
	
	@Before
	public void setup() throws BlaException {
		this.week = new Week(5);
	}
	
	@Test
	public void getDayTest() throws BlaException{
		Day day = new Day(3,0);
		assertEquals(day.getWeekDay(),week.getDay(WeekDays.MONDAY).getWeekDay());
	}
	
	@Test
	public void searchTest() throws BlaException{
		assertEquals(4,week.search(WeekDays.FRIDAY));
	}
	
	@Test
	public void toStringTest() throws BlaException{
		assertEquals("\nRIDES:",week.toString());
	}
}
