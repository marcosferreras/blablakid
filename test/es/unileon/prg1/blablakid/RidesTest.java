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
		
		@Test (expected= BlaException.class)
		public void negativeNumberTests() throws BlaException{
		new Rides(-1);	
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
		
		@Test 
		public void addTest() throws BlaException{
			Ride ride=new Ride(new Time(10,30),new Time(12,30),"csa","palmera");
			this.rides.add(ride);
			assertEquals(1,rides.find("csa", "palmera"));
			assertEquals(2,rides.getNext());
		}
		
		@Test (expected = BlaException.class)
		public void addRepeatedTest() throws BlaException{
			Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
			this.rides.add(ride);
		}
		
		@Test
		public void searchTest() {
			assertSame(rides.getRide(0),rides.search("casa", "palomera"));
		}
		
		@Test
		public void notFoundTest() {
			assertEquals(null,rides.search("asa", "palomera"));
		}
		
		@Test
		public void haveInformationTest() {
			assertTrue(rides.haveInformation());
		}
		
		@Test 
		public void renoveTest() throws BlaException{
			Ride ride=new Ride(new Time(10,30),new Time(12,30),"csa","palmera");
			this.rides.add(ride);
			this.rides.remove("csa","palmera");
			assertEquals(1,rides.getNext());
		}
		
		@Test 
		public void removeCompleatedTest() throws BlaException{
			Ride ride=new Ride(new Time(10,30),new Time(12,30),"csa","palmera"), ride2=new Ride(new Time(10,30),new Time(12,30),"csa","palmer");
			this.rides.add(ride);
			this.rides.add(ride2);
			this.rides.remove("csa","palmera");
			assertEquals(2,rides.getNext());
			assertEquals(null,rides.getRide(2));
		}
		
		@Test 
		public void renoveUnknowTest() throws BlaException{
			Ride ride=new Ride(new Time(10,30),new Time(12,30),"csa","palmera");
			this.rides.add(ride);
			this.rides.remove(ride);
			assertEquals(1,rides.getNext());
		}
		
		@Test 
		public void removeUnknowCompleatedTest() throws BlaException{
			Ride ride=new Ride(new Time(10,30),new Time(12,30),"csa","palmera"), ride2=new Ride(new Time(10,30),new Time(12,30),"csa","palmer");
			this.rides.add(ride);
			this.rides.add(ride2);
			this.rides.remove(ride2);
			assertEquals(2,rides.getNext());
			assertEquals(null,rides.getRide(2));
			this.rides.add(ride2);
			this.rides.remove(ride);
		}
		
		@Test 
		public void renoveNotUnknowTest() throws BlaException{
			Ride ride=new Ride(new Time(10,30),new Time(12,30),"csa","palmera");
			this.rides.remove(ride);
			assertEquals(1,rides.getNext());
		}
		
		@Test
		public void toStringTest() {
			assertEquals("\n" + 
					"casa > palomera : 12:30 / 15:30",rides.toString());
		}
}
