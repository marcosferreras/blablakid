package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Mario Alvarez Iglesias
 */

public class Parents {
	int next;
	private Parent parent[];
	private static final Logger logger= LogManager.getLogger(Parents.class);
	
	/**
	 * Constructor
	 * @param numParents max number of kids indicated at runtime
	 * @throws If the number of Parents is less or equal to zero
	 */
	public Parents(int numParents) throws BlaException {
		if (isCorrectNumber(numParents)) {
			parent = new Parent[numParents];
			this.next=0;
			logger.info("Has been created a Parents object whose length is "+numParents);
		}
	}
	
	/**
	 * Check if a number greater than 0
	 * @param a number of type int
	 * @throws If the number is less or equal to zero
	 * @return True if the number is less or equals to zero
	 */
	private boolean isCorrectNumber(int numParents) throws BlaException {
		boolean output=true;
		if (numParents<=0) {
			logger.error("Error:The number must be greater than zero");
			throw new BlaException ("Error:The number must be greater than zero");
		}
		return output;
	}
	
	/**
	 * Remove a kid of a parent
	 * @param a number of type int
	 */
	public void removeKid(String name) throws BlaException{
		for (int i=0;i<this.next;i++) {
			if(parent[i].find(name)) {
				this.parent[i].remove(name);
			}
		}
	}
	
	/**
	 * Find a parent comparing the name
	 * @param a name of the parent of type String
	 * @return a number of type int with the position of the parent in the array and if the parent isnt found return -1
	 */
	public int find(String name) {
		int i=0,out=-1;
		while (i<this.next && -1==out) {
			if (parent[i].getName().toLowerCase().equals(name.toLowerCase())) {
				out=i;
			}
			i++;
		}
		return out;
	}
	
	/**
	 * Add a parent
	 * @param An object of type parent to add
	 * @throws If the array of parents is compleat
	 * @throws If the parent has already exist
	 */
	public void add(Parent parent) throws BlaException{
		if (this.next==this.parent.length) {
			logger.error("Error:there are not enougth space for a new parent");
			throw new BlaException("Error:there are not enougth space for a new parent");
		}
		if (find(parent.getName())!=-1) {
			logger.error("Error:That parent has already exist");
			throw new BlaException("Error:That parent has already exist");
		}
			this.parent[next++]=parent;
			logger.info("The parent "+parent.getName()+" was added");
	}
	/**
	 * Add a ride
	 * @param A name of the parent of type String
	 * @param An object of type WeekDays to add the ride in that day
	 * @param An object of type Ride to add it
	 * @throws If the ride has already exist
	 * @throws If the parent has not exist
	 */
	public void add(String name, WeekDays day,Ride ride) throws BlaException{
		int number=find(name);
		if (number==-1) {
			logger.error("Error:That parent does not exist");
			throw new BlaException("Error:That parent does not exist");
		}
		this.parent[number].add(day, ride);
	}
	
	/**
	 * Remove a ride
	 * @param A name of the parent of type String
	 * @param An object of type WeekDays to add the ride in that day
	 * @param A start place of type String
	 * @param A end place of type String
	 * @throws If the ride has not exist
	 * @throws If the parent has not exist
	 * @return The object ride before been remove
	 */
	public Ride remove(String name, WeekDays day,String start,String end) throws BlaException{
		int number=find(name);
		if (number==-1) {
			logger.error("Error:That parent does not exist");
			throw new BlaException("Error:That parent does not exist");
		}
		return this.parent[number].remove(day,start,end);
		
	}
	
	/**
	 * Remove a Ride
	 * @param An object of type Rides
	 */
	public void remove(Rides rides) {
		Ride ride;
		int number=0;
		boolean outRide=false;
		for (int i=0;i<rides.getNext();i++) {
			ride = rides.getRide(i);
			while(number<this.next && !outRide) {
				outRide=this.parent[number].remove(ride);
				number++;
			}
			outRide=false;
			number=0;
		}
		
	}
	
	/**
	 * Remove a parent
	 * @param A name of the parent to remove of type String
	 * @throws If the parent does not exist
	 */
	public void remove(String name) throws BlaException{
		int number=find(name);
		if (number==-1) {
			logger.error("Error: That parent does not exist");
			throw new BlaException("Error: That parent does not exist");
		}
		this.parent[number]=null;
		for (int i=number;i<next-1;i++) {
			
			this.parent[i]=this.parent[i+1];
		
		}
		this.parent[next-1]=null;
		this.next--;
		logger.info("The parent called "+name+" was remove from the app");
	}
	
	/**
	 * ToString of the class
	 * @return the information of the class
	 */
	public String toString() {
		StringBuffer output= new StringBuffer();
		output.append("\nPARENTS:");
		for (int i=0;i<this.next;i++) {
			output.append(parent[i].toString());
		}
		return output.toString();
	}
}
	