package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTests {
	private Time time;
	
	@Before
	public void setup() throws BlaException{
		time = new Time(15,30);
	}
	
	@Test
	public void builderTest() throws BlaException{
		Time aux =new Time(1,1);
		assertEquals(1,aux.getHour());
		assertEquals(1,aux.getMinute());
	}
	
	@Test (expected = BlaException.class)
	public void testNegativeHour() throws BlaException{
		new Time(-1,30);
	}
	
	@Test (expected = BlaException.class)
	public void testHourHigherTo23() throws BlaException{
		new Time(100,30);
	}
	
	@Test (expected = BlaException.class)
	public void testNegativeMinutes() throws BlaException{
		new Time(10,-30);
	}
	
	@Test (expected = BlaException.class)
	public void testMInuteHigherTo59() throws BlaException{
		new Time(10,300);
	}
	
	@Test
	public void testGetHour() {
		assertEquals(15,this.time.getHour());
	}
	
	@Test
	public void testGetMinute() {
		assertEquals(30,this.time.getMinute());
	}
	
	@Test
	public void testIsBefore() throws BlaException {
		assertEquals(true, this.time.isBefore(new Time(19,00)));
		assertEquals(true, this.time.isBefore(new Time(15,31)));
	}
	@Test
	public void testIsNotBefore()throws BlaException {
		assertEquals(false, this.time.isBefore(new Time(15,00)));
	}
	@Test
	public void testToString() {
		assertEquals(time.toString(),"15:30");
	}
}