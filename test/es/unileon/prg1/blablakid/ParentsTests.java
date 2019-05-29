package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentsTests {
	private Parents parents;
	
	@Before
	public void setup() throws BlaException{
		this.parents = new Parents(3);
		Parent parent2, parent = new Parent("Jose",2,10);
		parent2=new Parent("Marco",2,10);
		parent.add(new Kid("Carlos"));
		this.parents.add(parent);
		this.parents.add(parent2);
	}
	@Test
	public void testToString() {
		assertEquals("\n" + 
				"PARENTS:\n" + 
				"##### Jose #####\n" + 
				"Kids:\n" + 
				"\n" + 
				"****** Carlos ******\n" + 
				"\n" + 
				"RIDES:\n" + 
				"##### Marco #####\n" + 
				"Kids:\n" + 
				"\n" + 
				"\n" + 
				"RIDES:",parents.toString());
	}
	
	@Test (expected = BlaException.class)
	public void testNumOfParentsValid()throws BlaException{
		new Parents(-10);
	}

	
	@Test (expected = BlaException.class)
	public void testAddRepeated() throws BlaException{
		parents.add(new Parent("Jose",1,10));
	}
	
	@Test
	public void testadd() throws BlaException{
		parents.add(new Parent("Juan",1,10));
		assertEquals(2,parents.find("juan"));
	}
	
	@Test (expected = BlaException.class)
	public void testdeleateNotExist() throws BlaException{
		parents.remove("Francisco");
	}
	
	@Test 
	public void testremove() throws BlaException{
		this.parents.remove("Jose");
		assertEquals(-1,parents.find("jose"));
	}
	
	@Test 
	public void testcheckParentExists(){
		assertEquals(0,parents.find("Jose"));
	}
	
	@Test 
	public void testcheckParentExistsError(){
		assertEquals(-1 , parents.find("Juan"));
	}
	
	@Test
	public void testIsCorrectNumberFalseTest(){
		assertEquals(-1 , parents.find("m"));
	}
	
	@Test
	public void testIsCorrectNumberTrueTest(){
		assertEquals(0 , parents.find("Jose"));
	}
	
	@Test
	public void testRemoveKid() throws BlaException{
		parents.removeKid("Carlos");
	}
	
	@Test (expected= BlaException.class)
	public void TestAddRideNotExistParent() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.parents.add("Jse", WeekDays.MONDAY, ride);
	}
	
	@Test (expected= BlaException.class)
	public void testAddRepeatedRideNotExistParentt() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.parents.add("Jose", WeekDays.MONDAY, ride);
		this.parents.add("Jose", WeekDays.MONDAY, ride);
	}
	
	@Test
	public void testAddRemoveRide() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.parents.add("Jose", WeekDays.MONDAY, ride);
		assertSame(ride,this.parents.remove("Jose",WeekDays.MONDAY,ride.getStartPlace(),ride.getEndPlace()));
	}
	
	@Test (expected= BlaException.class)
	public void testRemoveNotExistParent() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		this.parents.remove("Joe",WeekDays.MONDAY,ride.getStartPlace(),ride.getEndPlace());
	}
	
	@Test
	public void testRemoveRide() throws BlaException{
		Ride ride=new Ride(new Time(10,30),new Time(12,30),"casa","palomera");
		Rides rides=new Rides(5);
		rides.add(ride);
		this.parents.add("Jose", WeekDays.MONDAY, ride);
		this.parents.remove(rides);
	}
	
	@Test (expected = BlaException.class)
	public void testMaxNumberOfParents() throws BlaException{
		Parent parent = new Parent("ose",2,10);
		this.parents.add(parent);
		parent = new Parent("jos",2,10);
		this.parents.add(parent);
	}
	
	
}