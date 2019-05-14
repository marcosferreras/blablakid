package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	private Time time;
	
	@Before
	public void setup() throws BlaException{
		time = new Time(15,30);
	}
	
	@Test (expected = BlaException.class)
	public void constructorNegativeHourTest() throws BlaException{
		new Time(-1,30);
	}
	
	@Test (expected = BlaException.class)
	public void constructorVeryHightHourTest() throws BlaException{
		new Time(100,30);
	}
	
	@Test (expected = BlaException.class)
	public void constructorNegativeMInuteTest() throws BlaException{
		new Time(10,-30);
	}
	
	@Test (expected = BlaException.class)
	public void constructorVeryHightMinuteTest() throws BlaException{
		new Time(10,300);
	}
	
	@Test
	public void setGetHour() {
		this.time.setHour(10);
		assertEquals(10,this.time.getHour());
	}
	
	@Test
	public void setGetMinute() {
		this.time.setMinute(10);
		assertEquals(10,this.time.getMinute());
	}
	
	@Test
	public void constructorTest() throws BlaException{
		Time aux =new Time(1,1);
		assertEquals(1,aux.getHour());
		assertEquals(1,aux.getMinute());
	}
}