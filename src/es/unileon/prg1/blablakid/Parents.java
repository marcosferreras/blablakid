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
	 * @param numParents Maximun number of kids indicated at runtime
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
	 * @param a number of tipe int
	 * @throws If the number is less or equal to zero
	 */
	private boolean isCorrectNumber(int numParents) throws BlaException {
		boolean output=true;
		if (numParents<=0) {
			logger.error("Error:The number must be greater than zero");
			throw new BlaException ("Error:The number must be greater than zero");
		}
		return output;
	}
	
	public void removeKid(String name) throws BlaException{
		for (int i=0;i<this.next;i++) {
			if(parent[i].find(name)) {
				this.parent[i].remove(name);
			}
		}
	}
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
	
	public void add(String name, WeekDays day,Ride ride) throws BlaException{
		int number=find(name);
		if (number==-1) {
			logger.error("Error:That parent does not exist");
			throw new BlaException("Error:That parent does not exist");
		}
		this.parent[number].add(day, ride);
	}
	
	public Ride remove(String name, WeekDays day,String start,String end) throws BlaException{
		int number=find(name);
		if (number==-1) {
			logger.error("Error:That parent does not exist");
			throw new BlaException("Error:That parent does not exist");
		}
		return this.parent[number].remove(day,start,end);
		
	}
	
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
		}
		
	}
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
	
	public String toString() {
		StringBuffer output= new StringBuffer();
		output.append("\nPARENTS:");
		for (int i=0;i<this.next;i++) {
			output.append(parent[i].toString());
		}
		return output.toString();
	}
}
	