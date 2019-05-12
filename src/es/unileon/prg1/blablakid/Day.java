package es.unileon.prg1.blablakid;
public class Day{
	private Rides rides;
	private int numberRides;
	
	public Day(int numberRides)  throws BlaException {
		if (numberRides>0) {
			rides = new Rides(numberRides);
			this.numberRides=numberRides;
		}
		else throw new BlaException ("that day doesnt a correct number for the rides");
	}
}
