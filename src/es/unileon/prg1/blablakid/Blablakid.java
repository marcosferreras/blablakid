package es.unileon.prg1.blablakid;
public class Blablakid{
	Kids kids;
	Parents parents;
	protected Blablakid(int maxNumOfKids) throws BlaException{
		this.kids = new Kids(maxNumOfKids);
		this.parents = new Parents(maxNumOfKids*2);
	}
	public void add(Kid kid) throws BlaException {
		kids.add(kid);
	}
	
	public void removeKid(String name) throws BlaException {
		this.kids.remove(name);
	}
	
	public void add(Activity activity, String nameKid) throws BlaException {
		Kid kid = kids.search(nameKid);
		if(kid == null){
			throw new BlaException("Error: The kid "+nameKid+" does not exist");
		} else {
			kid.add(activity);
		}
	}
	public void removeActivity(String nameKid, String activityName, WeekDays day) throws BlaException {
		Kid kid = kids.search(nameKid);
		kid.removeActivity(activityName, day);
		
	}
	public void addRide(String parentName,String activityName,String kidName,Ride ride, WeekDays day) throws BlaException {
		Kid kid = kids.search(kidName);
		Parent parent;
		if(kid == null) {
			throw new BlaException("Error: The kid "+kidName+" does not exist");
		} else {
			kid.addRide(activityName,ride,day);	
		}
		parent=this.parents.checkParentExists(parentName);
		if(parent==null) {
			throw new BlaException("Error: That parent does not exists");
		}else {
			parent.getWeek().getDay(day).getRides().add(ride);
		}
	}
	public void removeRide(String nameParent, WeekDays day, String rideStart, String rideEnd) throws BlaException{
		Parent parent;		
		parent=this.parents.checkParentExists(nameParent);
		if(parent==null) {
			throw new BlaException("Error: That parent does not exists");
		}else {
			parent.getWeek().getDay(day).getRides().remove(rideStart, rideEnd);
		}
	}
	public void add(Parent parent, Kids kids) throws BlaException{
		Kid kid;
		if(kids.getLength()>this.kids.getLength()) {
			throw new BlaException("Error: The maximum number of kids is "+this.kids.getLength());
		}
		for(int i = 0; i < kids.getNext(); i++) {
			kid = this.kids.search(kids.getKid(i).getName()); 
			if(kid == null) {
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
