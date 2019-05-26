package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentTest {
	private Parent parent;
	
	@Before
	public void setup() throws BlaException{

		this.parent = new Parent("Carlos",1,3);
		this.parent.add(new Kid("Carlos"));
	}
		
	@Test
	public void builderTest() {
		assertEquals("Carlos",parent.getName());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("\n" + 
				"##### Carlos #####\n" + 
				"Kids:\n" + 
				"\n" + 
				"****** Carlos ******\n" + 
				"\n" + 
				"RIDES:\n" + 
				"MONDAY rides:\n" + 
				"TUESDAY rides:\n" + 
				"WEDNESDAY rides:\n" + 
				"THURSDAY rides:\n" + 
				"FRIDAY rides:",parent.toString());
	}
	@Test
	public void getWeekTest() {
		assertEquals(parent.getWeek().toString(),"\n" + 
				"RIDES:\n" + 
				"MONDAY rides:\n" + 
				"TUESDAY rides:\n" + 
				"WEDNESDAY rides:\n" + 
				"THURSDAY rides:\n" + 
				"FRIDAY rides:");
	}
}