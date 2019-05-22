package es.unileon.prg1.blablakid;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidsTests {
	private Kids kids;
	
	@Before
	public void setUp() throws BlaException{
		kids = new Kids(3);
		kids.add(new Kid("Beatriz"));
		
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
	public void testToString() {
		assertEquals(kids.toString(), "KIDS:\n****** Beatriz ******");
	}
}
