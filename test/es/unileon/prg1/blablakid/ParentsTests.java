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
		assertEquals("Juan",parents.checkParentExists("juan").getName());
	}
	
	@Test (expected = BlaException.class)
	public void testdeleateNotExist() throws BlaException{
		parents.remove("Francisco");
	}
	
	@Test 
	public void testremove() throws BlaException{
		this.parents.remove("Jose");
		assertEquals(null,parents./*toString()*/checkParentExists("jose"));
	}
	
	@Test 
	public void testcheckParentExists(){
		assertEquals("Jose",parents.checkParentExists("Jose").getName());
	}
	
	@Test 
	public void testcheckParentExistsError(){
		assertEquals(null , parents.checkParentExists("Juan"));
	}
	
	@Test
	public void testIsCorrectNumberFalseTest(){
		assertEquals(null , parents.checkParentExists("m"));
	}
	
	@Test
	public void testIsCorrectNumberTrueTest(){
		assertEquals("Jose" , parents.checkParentExists("Jose").getName());
	}
	
	@Test
	public void getParentTest() {
		assertEquals("Jose",parents.checkParentExists("Jose").getName());
	}
	
	
	
}