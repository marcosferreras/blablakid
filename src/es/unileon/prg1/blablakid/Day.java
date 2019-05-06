package es.unileon.prg1.blablakid;
public class Day{
	private Rides rides;
	private int numberDay;
	
	public Day(int numberDay)  throws BlaException {
		if (numberDay>0 && numberDay>5) {
			this.numberDay=numberDay;
		}
		else throw new BlaException ("that day doesnt exists in a week");
	}
}