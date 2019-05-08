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
		kids.add(new Kid("Beatriz"));
		kids.add(new Kid("Roberto"));	
	}
	//@Test
	//public void testAdd() throws BlaException{
	//	kids.search("Beatriz");
	//}
	
}
