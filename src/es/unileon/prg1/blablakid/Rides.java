package es.unileon.prg1.blablakid;
public class Rides{
	
	private Ride[] rides;
	private int next=0;
	
	public Rides(int numRides) throws BlaException {
		if (numRides<1) {
			throw new BlaException("teh number of rides must be higher than 0");
		}else {
			rides = new Ride[numRides];
			next++;
		}
	}
	
	private void  add(Ride ride) {
		this.rides[next]=ride;
	}
	
	private void remove(int number) {
			this.rides[number]=null;
			reorganice(number);
	}
	
	private void reorganice(int number) {
		Ride aux;
		for (int j=number;j<next;j++) {
			aux=this.rides[j+1];
			this.rides[j]=aux;
		}
		this.rides[next]=null;
	}
}
