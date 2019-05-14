package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentsTests {
	private Parents parents;
	
	@Before
	public void setup() throws BlaException{
		this.parents = new Parents(6);
		Parent parent = new Parent("Jose",1);
		Kids kids = new Kids(3);
		kids.add(new Kid("Carlos"));
		parent.addKids(kids);
		this.parents.add(parent);
	}
	
	@Test (expected = BlaException.class)
	public void testNumOfParentsValid()throws BlaException{
		new Parents(-1);
	}
	
	@Test (expected = BlaException.class)
	public void testAddRepeated() throws BlaException{
		parents.add(new Parent("Jose",1));
	}
	
	@Test
	public void testadd() throws BlaException{
		parents.add(new Parent("Juan Carlos",1));
		assertEquals("Juan Carlos",parents.getParent(1).getName());
	}
	
	@Test (expected = BlaException.class)
	public void testdeleateNotExist() throws BlaException{
		parents.deleate("Francisco");
	}
	
	@Test 
	public void testdeleate() throws BlaException{
		this.parents.deleate("Jose");
		assertEquals(false,parents.checkParentExists("Jose"));
	}
	
	@Test 
	public void testcheckParentExists(){
		assertEquals(true,parents.checkParentExists("Jose"));
	}
	
	@Test 
	public void testcheckParentExistsError(){
		assertEquals(false , parents.checkParentExists("Marco"));
	}
	
	@Test
	public void testIsCorrectNumberFalseTest(){
		assertEquals(false , parents.checkParentExists("m"));
	}
	
	@Test
	public void testIsCorrectNumberTrueTest(){
		assertEquals(true , parents.checkParentExists("Jose"));
	}
	
	@Test
	public void testGetNextSetNext() {
		parents.setNext(6);
		assertEquals(6,parents.getNext());
	}
	
	@Test
	public void getParentTest() {
		assertEquals("Jose",parents.getParent(0).getName());
	}
}