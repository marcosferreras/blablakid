package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rides{
	
	private Ride[] ride;
	private int next;
	private static final Logger logger= LogManager.getLogger(Rides.class);
	
	public Rides(int numRides) throws BlaException {
		if (numRides<1) {
			logger.error("Error:The number of rides must be higher than 0");
			throw new BlaException("Error:The number of rides must be higher than 0");
		}
			ride = new Ride[numRides];
			next=0;
			logger.info("Has been created a rides object whith a max number of rides of"+numRides);
	}
	
	public Ride getRide(int number) {
		return this.ride[number];
	}
	
	public int getNext() {
		return this.next;
	}
	public void  add(Ride ride) throws BlaException{
		if (this.next==this.ride.length) {
			logger.error("Error:there are not enougth space for a new ride");
			throw new BlaException("Error:there are not enougth space for a new ride");
		}
		if (find(ride.getStartPlace(),ride.getEndPlace())!=-1) {
			logger.error("Error: That ride has already exist");
			throw new BlaException("Error: That ride has already exist");
		}
		this.ride[next]=ride;
		this.next++;
		logger.info("A ride from"+ride.getStartPlace()+" to "+ride.getEndPlace()+" was added");
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
			logger.info("A ride from"+this.ride[number].getStartPlace()+" to "+this.ride[number].getEndPlace()+" was remove");
			this.ride[number]=null;
			if (number<(this.ride.length-1)) {
				for (int i=number;i<next-1;i++) {
					
					this.ride[i]=this.ride[i+1];
				
				}
				this.ride[next-1]=null;
			}
			this.next--;
			
		}
		return out;
	}
	
	public void remove(String start, String end) throws BlaException{
		int number=find(start,end);
		if (number==-1) {
			logger.error("Error:That ride does not exist");
			throw new BlaException("Error:That ride does not exist");
		}
		logger.info("A ride from"+this.ride[number].getStartPlace()+" to "+this.ride[number].getEndPlace()+" was remove");
		this.ride[number]=null;
		for (int i=number;i<next-1;i++) {
			this.ride[i]=this.ride[i+1];			
		}
		this.ride[next-1]=null;
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
