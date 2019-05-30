package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Mario Alverez Iglesias
 *
 */
public class Rides{
	
	private Ride[] ride;
	private int next;
	private static final Logger logger= LogManager.getLogger(Rides.class);
	/**
	 * constructor
	 * @param numRides
	 * @throws BlaException
	 */
	public Rides(int numRides) throws BlaException {
		if (numRides<1) {
			logger.error("Error:The number of rides must be higher than 0");
			throw new BlaException("Error:The number of rides must be higher than 0");
		}
			ride = new Ride[numRides];
			next=0;
			logger.info("Has been created a rides object whith a max number of rides of"+numRides);
	}
	
	/**
	 * @param The position of the ride of type int
	 * @return An object of type ride
	 */
	public Ride getRide(int number) {
		return this.ride[number];
	}
	
	/**
	 * @return the next of type int
	 */
	public int getNext() {
		return this.next;
	}
	
	/**
	 * Add a parent
	 * @param An object of type ride to add
	 * @throws If the array of rides is compleat
	 * @throws If the ride has already exist
	 */
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
		logger.info("A ride object from "+ride.getStartPlace()+" at "+ride.getTimeStart().toString()+" to "+ride.getEndPlace()+" at "+ride.getTimeEnd().toString()+" was add");
	} 
	
	/**
	 * Find a ride 
	 * @param The start place of the ride of type String
	 * @param The start place of the ride of type String
	 * @return An object of type ride
	 */
	public Ride search(String start, String end) {
		Ride ride=null;
		int number=find(start,end);
		if(number!=-1) {
			ride=this.ride[number];
		}
		return ride;
	}
	
	/**
	 * Find a ride comparing the name
	 * @param a name of the ride of type String
	 * @return a number of type int with the position of the ride in the array and if the ride isnt found return -1
	 */
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
	
	/**
	 * Remove a ride
	 * @param A ride object to remove
	 * @return a boolean in true if the ride was remove
	 */
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
			logger.info("A ride object from "+ride.getStartPlace()+" at "+ride.getTimeStart().toString()+" to "+ride.getEndPlace()+" at "+ride.getTimeEnd().toString()+" was remove");
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
	
	/**
	 * Remove a ride
	 * @param A start place of the ride of type String
	 * @param A start end of the ride of type String
	 * @throws If the ride does not exist
	 */
	public void remove(String start, String end) throws BlaException{
		int number=find(start,end);
		if (number==-1) {
			logger.error("Error:That ride does not exist");
			throw new BlaException("Error:That ride does not exist");
		}
		logger.info("A ride object from "+this.ride[number].getStartPlace()+" at "+this.ride[number].getTimeStart().toString()+" to "+this.ride[number].getEndPlace()+" at "+this.ride[number].getTimeEnd().toString()+" was remove");
		this.ride[number]=null;
		for (int i=number;i<next-1;i++) {
			this.ride[i]=this.ride[i+1];			
		}
		this.ride[next-1]=null;
		this.next--;
	}

	/**
	 * To String of the class
	 * @return the information of the class
	 */
	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		for(int i=0;i<this.next;i++) {
				output.append(this.ride[i].toString());
		}
		return output.toString();
	}
	
	/**
	 * Check information
	 * @return A boolean in true if the first ride = null
	 */
	public boolean haveInformation() {
		boolean out=false;
		if (ride[0]!=null) out=true;
		return out;
	}
}
