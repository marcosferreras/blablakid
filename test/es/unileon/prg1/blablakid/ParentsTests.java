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
		parent2=new Parent("Carlos",2,10);
		parent.add(new Kid("Carlos"));
		this.parents.add(parent);
		this.parents.add(parent2);
	}
	
	@Test (expected = BlaException.class)
	public void testNumOfParentsValid()throws BlaException{
		new Parents(-1);
	}
	
	@Test (expected = BlaException.class)
	public void testAddRepeated() throws BlaException{
		parents.add(new Parent("Jose",1,10));
	}
	
	@Test
	public void testadd() throws BlaException{
		parents.add(new Parent("Juan Carlos",1,10));
		assertEquals("Juan Carlos",parents.checkParentExists("Juan Carlos").getName());
	}
	
	@Test (expected = BlaException.class)
	public void testdeleateNotExist() throws BlaException{
		parents.remove("Francisco");
	}
	
	@Test 
	public void testremove() throws BlaException{
		this.parents.remove("Carlos");
		assertEquals(null,parents.checkParentExists("Carlos"));
	}
	
	@Test 
	public void testcheckParentExists(){
		assertEquals("Jose",parents.checkParentExists("Jose").getName());
	}
	
	@Test 
	public void testcheckParentExistsError(){
		assertEquals(null , parents.checkParentExists("Marco"));
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
	
	@Test
	public void removeRideTest()throws BlaException{
		
	}
}