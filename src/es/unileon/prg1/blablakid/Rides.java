package es.unileon.prg1.blablakid;
public class Rides{
	
	private Ride[] ride;
	private int next=0;
	
	public Rides(int numRides) throws BlaException {
		if (numRides<1) {
			throw new BlaException("teh number of rides must be higher than 0");
		}else {
			ride = new Ride[numRides];
			next++;
		}
	}
	
	public void  add(Ride ride) {
		this.ride[next]=ride;
		next++;
	}
	
	public Ride search(String start, String end) {
		return this.ride[find(start,end)];
	}
	
	private int find(String start, String end) {
		int i=0, num=-1;
		boolean out=false;
		do {
			if (ride[i].isSame(start,end)) {
				out=true;
				num=i;
			}
			else i++;
		}while (!out);
		return num;
	}
	
	public void remove(String start, String end) throws BlaException{
		int num=find(start,end);
		if (num!=-1) {
			this.ride[num]=null;
			Ride aux;
			for (int j=num;j<next;j++) {
				aux=this.ride[j+1];
				this.ride[j]=aux;
			}
			this.ride[next]=null;
			next--;
		} else throw new BlaException("That ride dosent exist");
	}

		public String toString() {
			StringBuffer output = new StringBuffer();
			for(int i=0;i<this.next;i++) {
				output.append(this.ride[i].toString());
			}
			return output.toString();
		}

}
