package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RidesTest {
		private Rides rides;
		
		@Before
		public void setup() throws BlaException{
			rides = new Rides(3);
			Time startTime = new Time(12,30);
			Time endTime = new Time(15,30);
			Ride ride = new Ride(startTime,endTime,"casa", "palomera");
			rides.add(ride);
		}
		
		@Test
		public void findTest() {
			assertEquals(0,rides.find("casa", "palomera"));
		}
		
		@Test (expected = BlaException.class)
		public void removeNotExist() throws BlaException{
			this.rides.remove("c", "palomera");
		}
		
		@Test
		public void removeTest() throws BlaException{
			this.rides.remove("casa", "palomera");
			assertEquals(false,this.rides.haveInformation());
		}
}
