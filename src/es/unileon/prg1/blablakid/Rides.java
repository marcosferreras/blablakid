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
	
	public void  add(Ride ride) {
		this.rides[next]=ride;
		next++;
	}
	
	private int find(String start, String end) {
		int i=0, num=-1;
		boolean out=false;
		do {
			if (rides[i].isSame(start,end)) {
				out=true;
				num=i;
			}
			else i++;
		}while (!out);
		return num;
	}
	
	public void deleate(String start, String end) throws BlaException{
		int num=find(start,end);
		if (num!=-1) {
			this.rides[num]=null;
			Ride aux;
			for (int j=num;j<next;j++) {
				aux=this.rides[j+1];
				this.rides[j]=aux;
			}
			this.rides[next]=null;
			next--;
		} else throw new BlaException("That ride dosent exist");
	}

}
