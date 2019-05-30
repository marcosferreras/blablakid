package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 
 * @author Marcos  Ferreras Rodriguez
 * @author Mario Alvarez Iglesias
 *
 */
public class Blablakid{
	Kids kids;
	Parents parents;
	private static final Logger logger= LogManager.getLogger(Kid.class);
	
	/**
	 * Constructor of the class
	 * @param A number of type int to the max number of parents and kids
	 * @throws If the number is equals or less than 0
	 */
	protected Blablakid(int maxNumOfKids) throws BlaException{
		this.kids = new Kids(maxNumOfKids);
		this.parents = new Parents(maxNumOfKids*2);
	}
	
	/**
	 * Add a kid
	 * @param An object of type int to add
	 * @throws If the kid has already exist 
	 */
	public void add(Kid kid) throws BlaException {
		kids.add(kid);
	}
	
	/**
	 * Remove a Kid
	 * @param A name of the kid to remove of type String
	 * @throws If the kid does not exist
	 */
	public void removeKid(String name) throws BlaException {
		Kid kid = this.kids.search(name);
		Rides rides;
		if(kid == null) { 
			logger.error("The kid "+name+" does not exist");
			throw new BlaException("Error: The kid "+name+" does not exist");
		} 
		rides = kid.getRides();
		this.kids.remove(name);
		this.parents.removeKid(name);
		this.parents.remove(rides);
	}
	
	/**
	 * Add a activity
	 * @param An object activity to add
	 * @param A kidName of type String
	 * @throws If activity has already exist
	 * @throws If kid does not exist
	 */
	public void add(Activity activity, String kidName) throws BlaException {
		Kid kid = kids.search(kidName);
		if(kid == null){
			logger.error("The kid "+kidName+" does not exist");
			throw new BlaException("Error: The kid "+kidName+" does not exist");
		}
			kid.add(activity);
	}
	
	/**
	 * Remove a activity and his rides
	 * @param A kidName of the kid who has the activity of type String
	 * @param A activityName of the activity to remove of type String
	 * @param  An object day of type WeekDays
	 * @throws If the kid does not exist
	 * @throws If the activity does not exist
	 */
	public void removeActivity(String kidName, String activityName, WeekDays day) throws BlaException {
		Kid kid = kids.search(kidName);
		Activity activity;
		Ride rideAfter; 
		Ride rideBefore;
		Rides rides = new Rides(2);
		if (kid == null) {
			logger.error("The kid "+kidName+" does not exist");
			throw new BlaException("Error: The kid "+kidName+" does not exist");
		}
		activity = kid.searchActivity(activityName, day);
		rideAfter = activity.getAfter();
		rideBefore = activity.getBefore(); 
		if(rideAfter != null) {
			rides.add(rideAfter);
		}
		if(rideBefore != null) {
			rides.add(rideBefore);
		}
		kid.remove(activityName, day);
		this.parents.remove(rides);
	}
	
	/**
	 * Add a ride
	 * @param A kidName of the kid who has the activity of type String
	 * @param A activityName of the activity to remove of type String
	 * @param A name of the parent of type String
	 * @param An object of type WeekDays to add the ride in that day
	 * @param An object of type Ride to add it
	 * @throws If the ride has already exist
	 * @throws If the parent has not exist
	 * @throws If the kid does not exist
	 * @throws If the activity does not exist
	 */
	public void addRide(String parentName,String activityName,String kidName,Ride ride, WeekDays day) throws BlaException {
		Kid kid = kids.search(kidName);
		Activity activity;
		if(kid == null) {
			logger.error("The kid "+kidName+" does not exist");
			throw new BlaException("Error: The kid "+kidName+" does not exist");
		}
		activity = kid.searchActivity(activityName, day);
		activity.add(ride);	
		this.parents.add(parentName, day, ride); 
	} 
	
	/**
	 * Remove a ride
	 * @param A name of the parent of type String
	 * @param An object of type WeekDays to add the ride in that day
	 * @param A start place of type String
	 * @param A end place of type String
	 * @throws If the ride has not exist
	 * @throws If the parent has not exist
	 */
	public void removeRide(String nameParent, WeekDays day, String rideStart, String rideEnd) throws BlaException{		
		Ride ride=this.parents.remove(nameParent, day, rideStart, rideEnd);
		this.kids.remove(ride);
	}
	
	/**
	 * Add a parent
	 * @param An object Kids to add to the parent
	 * @param An object of type parent to add
	 * @throws If the array of parents is compleat
	 * @throws If the parent has already exist
	 */
	public void add(Parent parent, Kids kids) throws BlaException{ 
		Kid kid;
		if(kids.getLength()>this.kids.getLength()) {
			logger.error("The kids that declared the parent("+kids.getLength()+") overcome saved children("+this.kids.getLength()+")");
			throw new BlaException("Error: The maximum number of kids is "+this.kids.getLength());
		}
		for(int i = 0; i < kids.getNext(); i++) {
			kid = this.kids.search(kids.getKid(i).getName()); 
			if(kid == null) {
				logger.error("The kid "+kids.getKid(i).getName()+" does not exist");
				throw new BlaException("Error: the kid "+kids.getKid(i).getName()+" does not exist"); 
			} else {
				parent.add(kid);
			}	
		}
		this.parents.add(parent);
	}
	
	/**
	 * Remove a parent
	 * @param A name of the parent to remove of type String
	 * @throws If the parent does not exist
	 */
	public void removeParent(String name) throws BlaException {
		this.parents.remove(name);
	}
	
	/**
	 * Obtain the state of all the kids's rides
	 * @return The state of all the kids's rides
	 */
	public String checkStatus() {
		return kids.checkStatus();
	}
	
	/**
	 * ToString of the class
	 * @return the information of the class
	 */
	@Override
	public String toString(){
		StringBuffer output=new StringBuffer();
		output.append("////////////////////////\n\n");
		output.append(this.kids.toString());
		output.append(this.parents.toString());
		output.append("\n\n////////////////////////");
		return output.toString();
	}
}
