package es.unileon.prg1.blablakid;
public class Rides{
	
	private Ride[] ride;
	private int next;
	
	public Rides(int numRides) throws BlaException {
		if (numRides<1) {
			throw new BlaException("The number of rides must be higher than 0");
		}
			ride = new Ride[numRides];
			next=0;
	}
	
	public Ride getRide(int number) {
		return this.ride[number];
	}
	
	public int getNext() {
		return this.next;
	}
	public void  add(Ride ride) throws BlaException{
		if (find(ride.getStartPlace(),ride.getEndPlace())!=-1) {
			throw new BlaException("Error: That ride has already exist");
		}
		this.ride[next]=ride;
		this.next++;
	} 
	
	public Ride search(String start, String end) {
		Ride ride=null;
		int number=find(start,end);
		if(number!=-1) {
			ride=this.ride[number];
		}
		return ride;
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
	
	public boolean remove(Ride ride) {
		int number=0;
		boolean out=false;
		while (number<this.next && !out) {
			if(ride==this.ride[number]) {
				out=true;
			} else {
				number++;
			}
		}
		if (out) {
			this.ride[number]=null;
			if (number<=(this.ride.length-1)) {
				for (int i=number;i<next;i++) {
					ride=this.ride[i+1];
					this.ride[i]=this.ride[i+1];
					this.ride[i+1]=ride;
				}
			}
			this.next--;
			
		}
		return out;
	}
	
	public void remove(String start, String end) throws BlaException{
		Ride ride;
		int number=find(start,end);
		if (number==-1) {
			throw new BlaException("That ride does not exist");
		}
		this.ride[number]=null;
		for (int i=number;i<next;i++) {
			ride=this.ride[i+1];
			this.ride[i]=this.ride[i+1];
			this.ride[i+1]=ride;
		}
		this.next--;
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
