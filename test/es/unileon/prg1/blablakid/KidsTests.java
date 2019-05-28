package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidsTests {
	private Kids kids;
	private Kid kid;
	
	@Before
	public void setUp() throws BlaException{
		kids = new Kids(3);
		kid = new Kid("Beatriz");
		kids.add(kid);
		
	}
	@Test (expected = BlaException.class)
	public void testNumOfKidsValid()throws BlaException{
		new Kids(0);
	}
	@Test (expected = BlaException.class)
	public void testAddRepeated() throws BlaException{
		kids.add(new Kid("Beatriz"));
	}
	@Test (expected = BlaException.class) 
	public void testAddFull() throws BlaException{
		kids.add(new Kid("Manuel"));
		kids.add(new Kid("Daniel"));	
		kids.add(new Kid("Fran"));
	}
	@Test
	public void testAdd() throws BlaException{
		assertEquals(kids.search("Beatriz").getName(), "Beatriz");
	}
	@Test 
	public void testSearchNotFound() throws BlaException{
		assertEquals(kids.search("Pablo"), null);
	}
	@Test
	public void testRemove()throws BlaException{
		kids.remove("Beatriz");
		assertEquals(kids.search("Beatriz"), null);
	}
	@Test (expected = BlaException.class)
	public void testRemoveNotFound()throws BlaException {
		kids.remove("Angel");
	}
	@Test 
	public void testGetLength()throws BlaException {
		assertEquals(3, this.kids.getLength());
	}
	@Test 
	public void testGetNext()throws BlaException {
		assertEquals(1, this.kids.getNext());
	}
	@Test 
	public void testGetKid()throws BlaException {
		assertEquals(this.kid, this.kids.getKid(0));
	}
	@Test
	public void testCheckStatus() {
		assertEquals("RIDES STATUS:", this.kids.checkStatus());
	}
	@Test
	public void testToString() {
		assertEquals(kids.toString(), "KIDS:\n\n****** Beatriz ******");
	}
}
