package es.unileon.prg1.blablakid;
public class Rides{
	
	private Ride[] ride;
	private int next=0;
	
	public Rides(int numRides) throws BlaException {
		if (numRides<1) {
			throw new BlaException("the number of rides must be higher than 0");
		}else {
			ride = new Ride[numRides];
		}
	}
	
	public void  add(Ride ride) throws BlaException{
		if (find(ride.getStartPlace(),ride.getEndPlace())==-1) {
			this.ride[next]=ride;
			this.next++;
		} else throw new BlaException("Error:That ride has already exist");
	} 
	
	public Ride search(String start, String end) {
		return this.ride[find(start,end)];
	}
	
	public int find(String start, String end) {
		int i=0, numero=-1;
		boolean out=false;
		while (!out && i<next) {
			if (ride[i].isSame(start,end)) {
				out=true;
				numero=i;
			}
			i++;
		}
		return numero;
	}
	
	public void remove(String start, String end) throws BlaException{
		int numero=find(start,end);
		if (numero!=-1) {
			this.ride[numero]=null;
			Ride auxiliar;
			for (int i=numero;i<next;i++) {
				auxiliar=this.ride[i+1];
				this.ride[i]=this.ride[i+1];
				this.ride[i]=auxiliar;
			}
			this.next--;
		} else throw new BlaException("That ride dosent exist");
	}

	public String toString() {
		StringBuffer output = new StringBuffer();
		for(int i=0;i<this.next;i++) {
				output.append(this.ride[i].toString());
		}
		return output.toString();
	}

	public boolean haveInformation() {
		boolean out=false;
		if (ride[0]!=null) out=true;
		return out;
	}
}
