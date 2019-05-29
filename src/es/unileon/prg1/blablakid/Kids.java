package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Marcos Ferreras Rodriguez
 */
public class Kids{
	private Kid kids[];
	private int next;
	private static final Logger logger= LogManager.getLogger(Kid.class);
	
	/**
	 * Constructor
	 * @param numKids Maximun number of kids indicated at runtime
	 * @throws If the number of kids is less or equal to zero
	 */
	public Kids(int numKids) throws BlaException{
		this.isNumOfKidsValid(numKids);
		kids = new Kid[numKids];
		logger.info("Has been created a kids object whose length is "+numKids);
		
	}
	private void isNumOfKidsValid(int numKids) throws BlaException {
		if(numKids <= 0) {
			logger.error("The maximum number of kids wasn't indicated at runtime");
			throw new BlaException("Error: You must indicate how parameter the maximum number of kids when you run the program");
		} 
	}
	/**
	 * Add a kid to the array
	 * @param kid The kid to add
	 * @throws If the kid already exists
	 * @throws If the limit of kids is reached
	 */
	protected boolean add(Kid kid) throws BlaException {
		boolean saveCorrect = false;
		if(search(kid.getName()) != null){
			logger.error("The kid "+kid.getName()+" already exists");
			throw new BlaException("Error: The kid "+kid.getName()+" already exists");
		} else if (this.next >= kids.length){
			logger.error("The limit of "+kids.length+" kids has been reached");
			throw new BlaException("Error: The limit of "+kids.length+" kids has been reached. Try to remove a kid");
		} else {
			kids[this.next] = kid;
			logger.info("The kid "+kid.getName()+" was added");
			saveCorrect = true;
			this.next++;
		}
		return saveCorrect;
	}
	/**
	 * Remove a Kid from the array
	 * @param name Name of the kid to remove
	 * @throws If the kid does not exist
	 */
	public void remove(String name)throws BlaException{
		Kid kid = search(name);
		if(kid == null) { 
			logger.error("The kid "+name+" does not exist");
			throw new BlaException("Error: The kid "+name+" does not exist");
		} 
		organize(position(kid)); 
		kids[this.next-1] = null;
		logger.info("The kid "+name+" was deleted");
		this.next--;				
	}
	private void organize(int position){
		while((position+1) < this.next){
			kids[position] = kids[position+1];
			position++;
		}
	}
	/**
	 * Obtain the position of a kid object in the array in format [0...length-1]
	 * @param kid
	 * @return The position of the kid
	 */
	public int position(Kid kid) {
		boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next)) {
			if(kid.getName().toLowerCase().equals(this.kids[i].getName().toLowerCase())){
				exist = true;
			}
			i++;
		}
		return (i-1);
	}
	/**
	 * Search a kid in the array
	 * @param name Name of the kid to search
	 * @return A kid object
	 */
	public Kid search(String name){
		Kid kid = null;
		Boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next)) {
			if(name.toLowerCase().equals(kids[i].getName().toLowerCase())){
				kid = kids[i];
				exist = true;
			}
			i++;
		}
		return kid;
	}
	public boolean removeRide(Ride ride) {
		boolean deleted = false;
		int i = 0;
		while(i<this.next && !deleted) {
			deleted = kids[i].removeRide(ride);
			i++;
		}
		return deleted;
	}
	/**
	 * Get the first empty position in the array
	 * @return First empty position in the array
	 */
	public int getNext() {
		return this.next;
	}
	/**
	 * Get length of the kids array
	 * @return length of the kids array
	 */
	public int getLength() {
		return this.kids.length;
	}
	/**
	 * Get a child given a position in the array
	 * @param position Position 
	 * @return The kid in the specified position
	 */
	public Kid getKid(int position) {
		return this.kids[position];
	}
	/**
	 * Obtain the state of all the kids's rides
	 * @return The state of all the kids's rides
	 */
	public String checkStatus() {
		StringBuffer salida= new StringBuffer();
		salida.append("RIDES STATUS:");
		for(int i = 0; i < this.next; i++){
			salida.append(kids[i].checkStatus());
		}
		return salida.toString();
	}
	/**
	 * Generate all the information about all the kids
	 * @return Shows all the information about all the kids
	 */
	@Override
	public String toString(){
		StringBuffer salida= new StringBuffer();
		salida.append("KIDS:\n");
		for(int i = 0; i < this.next; i++){
			salida.append(kids[i].toString());
		}
		return salida.toString();	
	}
	public String nameOfKids() {
		StringBuffer output= new StringBuffer();
		for(int i = 0; i < this.next; i++){
			output.append("\n****** "+kids[i].getName()+" ******");
		}
		return output.toString();
	}
			
}
