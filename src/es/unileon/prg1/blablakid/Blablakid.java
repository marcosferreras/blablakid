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
		Kid kid = this.kids.search(name);
		Rides rides;
		if(kid == null) { 
			throw new BlaException("Error: The kid "+name+" does not exist");
		} 
		rides = kid.getRides();
		this.kids.remove(name);
		this.parents.removeKid(name);
		//TODO Falta eliminar los rides del niño de los rides de los padres
	}
	
	public void add(Activity activity, String nameKid) throws BlaException {
		Kid kid = kids.search(nameKid);
		if(kid == null){
			throw new BlaException("Error: The kid "+nameKid+" does not exist");
		}
			kid.add(activity);
	}
	public void removeActivity(String nameKid, String activityName, WeekDays day) throws BlaException {
		Kid kid = kids.search(nameKid);
		Activity activity;
		Ride rideAfter;
		Ride rideBefore;
		Rides rides = new Rides(2);
		if (kid == null) {
			throw new BlaException("Error: The kid "+nameKid+" does not exist");
		}
		activity = kid.searchActivity(activityName, day);
		if (activity == null) {
			throw new BlaException("Error: The activity "+activityName+" does not exist in "+nameKid+" in "+ day.toString());
		} 
		rideAfter = activity.getAfter();
		rideBefore = activity.getBefore();
		if(rideAfter != null) {
			rides.add(rideAfter);
		}
		if(rideBefore != null) {
			rides.add(rideBefore);
		}
		kid.removeActivity(activityName, day);
		//parents.removeRide
	}
	public void addRide(String parentName,String activityName,String kidName,Ride ride, WeekDays day) throws BlaException {
		Kid kid = kids.search(kidName);
		Activity activity;
		int number=parents.search(parentName); 
		if(kid == null) {
			throw new BlaException("Error: The kid "+kidName+" does not exist");
		}
		activity = kid.searchActivity(activityName, day);
		if (activity == null) {
			throw new BlaException("Error: The activity "+activityName+" does not exist in "+kidName+" in "+ day.toString());
		} 
		activity.add(ride);	
		if(number==-1) {
			throw new BlaException("Error: That parent does not exists");
		}else {
			parents.getParent(number).getDay(day).add(ride);
		}
	}
	public void removeRide(String nameParent, WeekDays day, String rideStart, String rideEnd) throws BlaException{		
		int number=this.parents.search(nameParent);
		if(number==-1) {
			throw new BlaException("Error: That parent does not exists");
		}else {
			parents.getParent(number).getDay(day).remove(rideStart, rideEnd);;
		}
		//A partir de aqui borrado del ride de la actividad
		/*
		this.kids.removeRide(ride);
		 */
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
