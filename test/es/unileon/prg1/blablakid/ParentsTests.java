package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentsTests {
	private Parents parents;
	
	@Before
	public void setup() throws BlaException{
		kids = new Kids(3);
		kids.add(new Kid("Beatriz"));
		parents = new Parents(6);
		parents.add(new Parent("Jose",kids));
	}
	
	@Test (expected = BlaException.class)
	public void testNumOfParentsValid()throws BlaException{
		new Kids(0);
	}
	
	@Test (expected = BlaException.class)
	public void testAddRepeated() throws BlaException{
		kids = new Kids(3);
		kids.add(new Kid("Beatriz"));
		parents.add(new Parent("Jose", kids));
	}
	
	@Test
	public void testadd() throws BlaException{
		kids = new Kids(3);
		kids.add(new Kid("Beatriz"));
		parents.add(new Parent("Juan Carlos", kids));
		assertEquals(2,parents.getNext());
	}
	
	@Test (expected = BlaException.class)
	public void testdeleateNotExist() throws BlaException{
		parents.deleate("Francisco");
	}
	
	@Test 
	public void testdeleate() throws BlaException{
		kids = new Kids(3);
		kids.add(new Kid("Beatriz"));
		Parent parent = new Parent("Jose Luis", kids);
		parents.add(parent);
		
		parents.deleate("Juan Carlos");
		
		assertEquals(1,parents.getNext());
		assertEquals(parent,parets.getParents(2));
	}
	
	@Test 
	public void testcheckParentExists(){
		assertEquals(true,parents.checkParentExists("Jose Luis"));
	}
	
	@Test 
	public void testcheckParentExistsError(){
		assertEquals(false , parents.checkParentExists("Marco"));
	}
	
	@Test
	public void testIsCorrectNumber(){
		assertEquals(false , parents.checkParentExists(-1));
	}
	
	@Test
	public void testIsCorrectNumber(){
		assertEquals(true , parents.checkParentExists(1));
	}
	
	@Test
	public void testGetNextSetNext() {
		parents.setNext(6);
		assertEquals(6,parents.getNext());
	}