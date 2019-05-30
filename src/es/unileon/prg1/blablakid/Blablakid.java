package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Blablakid{
	Kids kids;
	Parents parents;
	private static final Logger logger= LogManager.getLogger(Kid.class);
	
	protected Blablakid(int maxNumOfKids) throws BlaException{
		this.kids = new Kids(maxNumOfKids);
		this.parents = new Parents(maxNumOfKids*2);
	}
	public void add(Kid kid) throws BlaException {
		kids.add(kid);
	}
	
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
	
	public void add(Activity activity, String kidName) throws BlaException {
		Kid kid = kids.search(kidName);
		if(kid == null){
			logger.error("The kid "+kidName+" does not exist");
			throw new BlaException("Error: The kid "+kidName+" does not exist");
		}
			kid.add(activity);
	}
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
	public void removeRide(String nameParent, WeekDays day, String rideStart, String rideEnd) throws BlaException{		
		Ride ride=this.parents.remove(nameParent, day, rideStart, rideEnd);
		this.kids.remove(ride);
	}
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
	public void removeParent(String name) throws BlaException {
		this.parents.remove(name);
	}
	public String checkStatus() {
		return kids.checkStatus();
	}
	public String toString(){
		StringBuffer output=new StringBuffer();
		output.append("////////////////////////\n\n");
		output.append(this.kids.toString());
		output.append(this.parents.toString());
		output.append("\n\n////////////////////////");
		return output.toString();
	}
}
