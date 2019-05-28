package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentsTests {
	private Parents parents;
	
	@Before
	public void setup() throws BlaException{
		this.parents = new Parents(6);
		Parent parent2, parent = new Parent("Jose",2,10);
		parent2=new Parent("Marco",2,10);
		parent.add(new Kid("Carlos"));
		this.parents.add(parent);
		this.parents.add(parent2);
	}
	@Test
	public void toStringTest() {
		assertEquals("\n" + 
				"PARENTS:\n" + 
				"##### Jose #####\n" + 
				"Kids:\n" + 
				"\n" + 
				"****** Carlos ******\n" + 
				"\n" + 
				"RIDES:\n" + 
				"MONDAY rides:\n" + 
				"TUESDAY rides:\n" + 
				"WEDNESDAY rides:\n" + 
				"THURSDAY rides:\n" + 
				"FRIDAY rides:\n" + 
				"##### Marco #####\n" + 
				"Kids:\n" + 
				"\n" + 
				"RIDES:\n" + 
				"MONDAY rides:\n" + 
				"TUESDAY rides:\n" + 
				"WEDNESDAY rides:\n" + 
				"THURSDAY rides:\n" + 
				"FRIDAY rides:",parents.toString());
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
		assertEquals(2,parents.search("juan"));
	}
	
	@Test (expected = BlaException.class)
	public void testdeleateNotExist() throws BlaException{
		parents.remove("Francisco");
	}
	
	@Test 
	public void testremove() throws BlaException{
		this.parents.remove("Jose");
		assertEquals(-1,parents.search("jose"));
	}
	
	@Test 
	public void testcheckParentExists(){
		assertEquals(0,parents.search("Jose"));
	}
	
	@Test 
	public void testcheckParentExistsError(){
		assertEquals(-1 , parents.search("Juan"));
	}
	
	@Test
	public void testIsCorrectNumberFalseTest(){
		assertEquals(-1 , parents.search("m"));
	}
	
	@Test
	public void testIsCorrectNumberTrueTest(){
		assertEquals(0 , parents.search("Jose"));
	}

	
	
	
}